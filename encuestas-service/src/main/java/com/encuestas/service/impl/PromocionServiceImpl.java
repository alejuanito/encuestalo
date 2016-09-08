/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import com.encuestas.data.bean.ClienteBean;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.encuestas.data.bean.PromocionBean;
import com.encuestas.data.model.Empresa;
import com.encuestas.data.model.Promocion;
import com.encuestas.data.model.PromocionEnviada;
import com.encuestas.data.model.Usuario;
import com.encuestas.data.repository.PromocionEnviadaRepository;
import com.encuestas.service.ClienteService;
import com.encuestas.service.MailService;
import com.encuestas.service.PromocionService;
import com.encuestas.service.converter.PromocionModelToBeanConverter;
import com.encuestas.service.validator.PromocionValidator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.encuestas.data.repository.PromocionRepository;
import com.encuestas.data.repository.UsuarioRepository;
import com.encuestas.service.converter.ClienteBeanConverter;
import com.encuestas.util.Constantes;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;


@Service
public class PromocionServiceImpl implements PromocionService {

    @Autowired
    private PromocionRepository promocionRepository;
    @Autowired
    private PromocionEnviadaRepository promocionEnviadaRepository;
    @Autowired
    private MailService mailService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private ClienteService clienteService;
    
    private final Logger LOGGER = Logger.getLogger(PromocionServiceImpl.class);
    @Autowired
    private MessageSource messageSource;

    @Override
    public List<PromocionBean> listAll() {
        // TODO Auto-generated method stub
        List<Promocion> promocionList = promocionRepository.findAll();

        return new PromocionModelToBeanConverter().convertList(promocionList);
    }
    
    @Override
    public List<PromocionBean> listPromocion(String user) {
        // TODO Auto-generated method stub
         Usuario usuario = usuarioRepository.findByUsername(user);
        List<Promocion> promocionList = promocionRepository.findByLocalEmpresaIdEmpresa(usuario.getEmpresa().getIdEmpresa());

        return new PromocionModelToBeanConverter().convertList(promocionList);
    }

    @Override
    public PromocionBean load(Integer id) {
        // TODO Auto-generated method stub
        Promocion promocion = promocionRepository.findOne(id);

        return new PromocionModelToBeanConverter().convert(promocion);
    }
    
    @Override
    @Transactional

    public PromocionBean create(PromocionBean promocionBean, String user) {
        // validation
        LOGGER.trace("haciendo validaci�n");
        Usuario usuario = usuarioRepository.findByUsername(user);
        DataBinder dataBinder = new DataBinder(promocionBean);
        dataBinder.setValidator(new PromocionValidator());
        LOGGER.debug("Fecha Inicio Promocion: "+promocionBean.getFeInicio());
        LOGGER.debug("Fecha Fin Promocion: "+promocionBean.getFeFin());
        dataBinder.validate();
        BindingResult bindingResult = dataBinder.getBindingResult();
//        if (bindingResult.hasErrors()) {
//            throw new DataValidationErrorException(bindingResult, messageSource);
//        }
        // end validation

        // Usuario usuario = usuarioRepository.findByUsername(username);
        promocionBean.setNoImagen(promocionBean.getNoImagen());
        Promocion promocion = new Promocion(promocionBean);

        promocion.setEsPromocion(Constantes.ESTADO_ACTIVO);
        promocion.setUsuario(usuario);
        // Si no se actualiza desde el m�todo correcto ignorar.
        if (promocion.getIdPromocion() == null) {            
                
            promocionRepository.save(promocion);
        }
        return new PromocionModelToBeanConverter().convert(promocion);
    }

    @Override
    @Transactional
    public PromocionBean update(PromocionBean promocionBean, String user) {
        Usuario usuario = usuarioRepository.findByUsername(user);
        promocionBean.setNoImagen(promocionBean.getNoImagen());
        Promocion promocion = new Promocion(promocionBean);

        if (promocionBean.getIdPromocion() != null) {
            promocion.setUsuario(usuario);
            promocionRepository.save(promocion);
        }
        return new PromocionModelToBeanConverter().convert(promocion);
    }
    
    @Override
    @Transactional
    public PromocionBean desactivar(Integer idPromocion) {
        Promocion promocion = promocionRepository.findOne(idPromocion);
        promocion.setEsPromocion(Constantes.ESTADO_INACTIVO);
        
            promocionRepository.save(promocion);
      
        return new PromocionModelToBeanConverter().convert(promocion);
    }

  

   @Override
   public Boolean saveImage(String noImage, InputStream inputStream, String user) throws RuntimeException, IOException{        
        OutputStream outputStream = null;  
        //Usuario usuario = usuarioRepository.findByUsername(user);
        File image = new File(noImage);
        
        
        //File newFile = new File(noFile);
        if (!image.exists()) {
            image.createNewFile();
        }
        outputStream = new FileOutputStream(image);
        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }
        return true;
   }
   
    @Override
    @Transactional
    public Boolean enviarPromociones() {
        
        List<Promocion> promocionList = promocionRepository.findPromocionesActivas(new Date());
        LOGGER.debug("Promociones encontradas: "+ promocionList.size());
        Map<Integer, List<ClienteBean>> listPersonas = new HashMap<Integer, List<ClienteBean>>();
        for (Promocion promocion : promocionList){
            List<ClienteBean> listClientes = new ArrayList<>();
            listClientes = clienteService.getClientePromocion(promocion.getLocal().getEmpresa().getIdEmpresa(), Boolean.TRUE, promocion.getIdPromocion(), promocion.getLocal().getIdLocal());
            LOGGER.debug("Clientes encontrado para promocion: "+ promocion.getIdPromocion() +" - "+ listClientes.size() );
            listPersonas.put(promocion.getIdPromocion(), listClientes);
        }
        List<PromocionEnviada> promocionEnviadaList = new ArrayList<>();
        for (Promocion promocion : promocionList){
            
            List<ClienteBean> listClientesPromocion = listPersonas.get(promocion.getIdPromocion());
            String correos= "";
            Integer nuEnvios=0;
            //alejandro <alejandrojcc@gmail.com>
            for (ClienteBean cliente : listClientesPromocion){
                PromocionEnviada promoEnviada = new PromocionEnviada();
                
                promoEnviada.setPromocion(promocion);
                Empresa empresa = new Empresa(cliente.getEmpresa());
                promoEnviada.setEmpresa(empresa);
                promoEnviada.setCliente(new ClienteBeanConverter().convert(cliente));
                promoEnviada.setFeEnvio(new Date());
                promoEnviada.setUsuario(promocion.getUsuario());

                promocionEnviadaList.add(promoEnviada);
                if(nuEnvios<Constantes.CANT_EMAIL_SENDING){
                    correos = correos.concat(cliente.getPersona().getNoPersona().concat("<"+cliente.getPersona().getDeEmail()+ ">,"));
                    nuEnvios++;
                }                
            }
            LOGGER.debug("Listado correos: "+ correos);
           
            if(correos.length()>0){
            //Enviando emails
                correos = correos.substring(0, correos.length()-1);
                mailService.enviarPromocionesAdjunto(promocion, correos);
            }
            
            LOGGER.debug("Listado final: "+ correos);
        }
        promocionEnviadaRepository.save(promocionEnviadaList);
        return true;
    }
    
  
}
