/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import java.util.*;

import com.encuestas.service.converter.ClienteBeanConverter;
import com.encuestas.util.StringUtils;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encuestas.data.bean.ClienteBean;
import com.encuestas.data.bean.ColaboradorBean;
import com.encuestas.data.bean.EmpresaBean;
import com.encuestas.data.bean.PersonaBean;
import com.encuestas.data.model.Cliente;
import com.encuestas.data.model.ClienteLocal;
import com.encuestas.data.model.Encuesta;
import com.encuestas.data.model.Local;
import com.encuestas.data.model.Usuario;
import com.encuestas.data.repository.ClienteLocalRepository;
import com.encuestas.data.repository.ClienteRepository;
import com.encuestas.data.repository.EncuestaRepository;
import com.encuestas.data.repository.LocalRepository;
import com.encuestas.data.repository.UsuarioRepository;
import com.encuestas.service.ClienteService;
import com.encuestas.service.ColaboradorService;
import com.encuestas.service.EncuestaService;
import com.encuestas.service.PersonaService;
import com.encuestas.service.converter.ClienteConverter;
import com.encuestas.service.converter.PersonaBeanConverter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class ClienteServiceImpl implements ClienteService{
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ClienteRepository clienteRepository;
    
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ClienteLocalRepository clienteLocalRepository;
    @Autowired
    private LocalRepository localRepository;
    @Autowired
    private PersonaService personaService;
    @Autowired
    private ColaboradorService colaboradorService;
    @Autowired
    private EncuestaRepository encuestaRepository;
    @Autowired
    private EncuestaService encuestaService;

    private final Logger LOGGER = Logger.getLogger(ClienteServiceImpl.class); 
    
    @Transactional
	@Override
	public ClienteBean createCliente(ClienteBean clienteBean, String userName) {
		// TODO Auto-generated method stub
		List<Cliente> listCliente = findCliente(clienteBean.getPersona().getNuDocumento(),
				clienteBean.getPersona().getTipoDocumento().getCoTipoDocumento());
                Usuario usuario = usuarioRepository.findByUsername(userName);
                Encuesta encuesta = encuestaRepository.findOne(clienteBean.getIdEncuesta());
		//PersonaBean persona = new PersonaBean ();
		Cliente cliente = new Cliente();
                ClienteLocal clienteLocal = new ClienteLocal();
                if(encuesta==null){
                    return null;
                }
                 ColaboradorBean colaborador = colaboradorService.getColaborador(userName);  
                 Local local = localRepository.findOne(colaborador.getLocal().getIdLocal());
		if(listCliente.isEmpty()){
			PersonaBean persona = personaService.createPersona(clienteBean.getPersona());			
			cliente.setPersona(new PersonaBeanConverter().convert(persona));
                        cliente.setEmpresa(usuario.getEmpresa());
                        cliente.setInPromocion(clienteBean.getInPromocion());
			LOGGER.debug("Persona: "+ cliente.getPersona().getIdPersona());
			
			clienteRepository.save(cliente);
			clienteRepository.flush();
                        
                        clienteLocal.setCliente(cliente);
                        clienteLocal.setLocal(local);
                        clienteLocal.setFeCreaRegistro(new Date());
                        clienteLocalRepository.save(clienteLocal);
                        
                        encuesta.setCliente(cliente);
                        
		}else{
			encuesta.setCliente(listCliente.get(0));
                        List<ClienteLocal> listClienteLocal =    clienteLocalRepository.findByLocalIdLocalAndClienteIdCliente(local.getIdLocal(), listCliente.get(0).getIdCliente());
                        if(listClienteLocal.isEmpty()){
                            clienteLocal.setCliente(listCliente.get(0));
                            clienteLocal.setLocal(local);
                            clienteLocal.setFeCreaRegistro(new Date());
                            clienteLocalRepository.save(clienteLocal);
                        }
		}		
                            
                encuestaRepository.save(encuesta);
		return new ClienteConverter().convert(cliente);
		
	}

    @Override
    public ClienteBean actualizar(ClienteBean clienteBean) {
        ClienteBeanConverter clienteBeanConverter = new ClienteBeanConverter();
        Cliente cliente = clienteBeanConverter.convert(clienteBean);
        cliente = clienteRepository.save(cliente);
        List<Object[]> ids = clienteRepository.consultaUltimoLocalCliente(clienteBean.getIdCliente());
        Map<Integer, Local> localMap = new HashMap<>();
        Map<Integer, Integer> clienteXLocalMap = new HashMap<>();

        for (Object[] id : ids) {
            Integer idCliente = Integer.parseInt(id[0]+"");
            Integer idLocalClienteUltimaVisita = id[1] == null ? null : Integer.parseInt(id[1]+"");

            if (idLocalClienteUltimaVisita != null && localMap.get(idLocalClienteUltimaVisita) == null) {
                localMap.put(idLocalClienteUltimaVisita, localRepository.findOne(idLocalClienteUltimaVisita));
            }

            if (idLocalClienteUltimaVisita != null) {
                clienteXLocalMap.put(idCliente, idLocalClienteUltimaVisita);
            }
        }


        return new ClienteConverter(localMap, clienteXLocalMap).convert(cliente);
    }
//        @Override
//        public List<ClienteBean> getClientePromocion(Integer idEmpresa, Boolean inPromocion, Integer idPromocion){
//            List<Cliente> listCliente = clienteRepository.findClientePorPromocion(idEmpresa, inPromocion, idPromocion);
//            return new ClienteConverter().convertList(listCliente);
//        }
        
        @Override
	@Transactional
	public List<Cliente> findCliente(String nuDocumento, String coTipoDocumento) {
		// TODO Auto-generated method stub
		return clienteRepository.findByPersonaNuDocumentoAndPersonaTipoDocumentoCoTipoDocumento(nuDocumento,
				coTipoDocumento);
	}
        
        @Override
        public List<ClienteBean> getClientePromocion(Integer idEmpresa, Boolean inPromocion, Integer idPromocion, Integer idLocal){
            String sql = "select cli.id_cliente, cli.id_persona, per.no_persona, per.ap_persona, per.am_persona, "
                    + " per.de_email, emp.id_empresa "
                    + "from ectm_cliente cli "
                    + " inner join ectm_empresa emp on emp.id_empresa = cli.id_empresa "
                    + " inner join ectm_persona per on per.id_persona = cli.id_persona "
                    + " inner join ectr_cliente_local cl on cl.id_cliente = cli.id_cliente "
                    + "where cli.id_cliente not in "
                    + " (select coalesce(pro.id_cliente,0) from ectc_promocion_enviada pro where pro.id_promocion = ? ) "
                    + " and cli.in_Promocion is true and emp.id_empresa = ? and per.de_email is not null and per.de_email <>  '' "
                    + " and  cl.id_local = ?";
            javax.persistence.Query query = entityManager.createNativeQuery(sql);
            LOGGER.debug("Query: "+sql);
            query.setParameter(1, idPromocion);
           // query.setParameter(2, inPromocion);
            query.setParameter(2, idEmpresa);
            query.setParameter(3, idLocal);
            List<Object[]> result = query.getResultList();
            List<ClienteBean> listReturn = new ArrayList<>();
            for (Object[] o : result) {
                ClienteBean cliente = new ClienteBean();
                PersonaBean persona = new PersonaBean();
                EmpresaBean empresa = new EmpresaBean();
                cliente.setIdCliente(Integer.parseInt(o[0].toString()));
                persona.setIdPersona(Integer.parseInt(o[1].toString()));
                persona.setNoPersona(o[2].toString());
                persona.setApPersona(o[3].toString());
                persona.setAmPersona(o[4].toString());
                persona.setDeEmail(o[5].toString());
                empresa.setIdEmpresa(Integer.parseInt(o[6].toString()));
                cliente.setPersona(persona);
                cliente.setEmpresa(empresa);
                listReturn.add(cliente);
            }
            return listReturn;
        }

    @Override
    public Page<ClienteBean> consultaCliente(String apPersona, String amPersona, String noPersona,
                                             String coTipoDocumento, String nuDocumento, Integer idLocal,
                                             Integer edadMin, Integer edadMax,
                                             Boolean inPromocion, Integer page, Integer size) {
        apPersona = String.format("%%%s%%", StringUtils.emptyWhenNullString(apPersona));
        amPersona = String.format("%%%s%%", StringUtils.emptyWhenNullString(amPersona));
        noPersona = String.format("%%%s%%", StringUtils.emptyWhenNullString(noPersona));
        nuDocumento = String.format("%%%s%%", StringUtils.emptyWhenNullString(nuDocumento));

        List<Object[]> ids = clienteRepository.consultaLocalesCliente(idLocal == null ? 0 : idLocal,
                edadMin == null ? 0 : edadMin,
                edadMax == null ? 0 : edadMax);
        List<Integer> idClientesAConsultar = new ArrayList<>();
        Map<Integer, Local> localMap = new HashMap<>();
        Map<Integer, Integer> clienteXLocalMap = new HashMap<>();

        for (Object[] id : ids) {
            Integer idCliente = Integer.parseInt(id[0]+"");
            Integer idLocalClienteUltimaVisita = id[1] == null ? null : Integer.parseInt(id[1]+"");

            idClientesAConsultar.add(idCliente);


            if (idLocalClienteUltimaVisita != null && localMap.get(idLocalClienteUltimaVisita) == null) {
                localMap.put(idLocalClienteUltimaVisita, localRepository.findOne(idLocalClienteUltimaVisita));
            }

            if (idLocalClienteUltimaVisita != null) {
                clienteXLocalMap.put(idCliente, idLocalClienteUltimaVisita);
            }
        }

        Page<Cliente> clientes;
        PageRequest pageRequest = new PageRequest(page, size);
        if (idClientesAConsultar.isEmpty()) {
            clientes = new PageImpl<Cliente>(new ArrayList<Cliente>(), pageRequest, 0);
        } else {
            clientes = clienteRepository.consultaCliente(apPersona, amPersona, noPersona, nuDocumento, coTipoDocumento, inPromocion, idClientesAConsultar, pageRequest);
        }
        return clientes.map(new ClienteConverter(localMap, clienteXLocalMap));
    }

    @Override
    public List<ClienteBean> consultaCliente(String apPersona, String amPersona, String noPersona, String coTipoDocumento, String nuDocumento, Integer idLocal, Integer edadMin, Integer edadMax, Boolean inPromocion) {

        apPersona = String.format("%%%s%%", StringUtils.emptyWhenNullString(apPersona));
        amPersona = String.format("%%%s%%", StringUtils.emptyWhenNullString(amPersona));
        noPersona = String.format("%%%s%%", StringUtils.emptyWhenNullString(noPersona));
        nuDocumento = String.format("%%%s%%", StringUtils.emptyWhenNullString(nuDocumento));

        List<Object[]> ids = clienteRepository.consultaLocalesCliente(idLocal == null ? 0 : idLocal,
                edadMin == null ? 0 : edadMin,
                edadMax == null ? 0 : edadMax);
        List<Integer> idClientesAConsultar = new ArrayList<>();
        Map<Integer, Local> localMap = new HashMap<>();
        Map<Integer, Integer> clienteXLocalMap = new HashMap<>();

        for (Object[] id : ids) {
            Integer idCliente = Integer.parseInt(id[0]+"");
            Integer idLocalClienteUltimaVisita = id[1] == null ? null : Integer.parseInt(id[1]+"");

            idClientesAConsultar.add(idCliente);


            if (idLocalClienteUltimaVisita != null && localMap.get(idLocalClienteUltimaVisita) == null) {
                localMap.put(idLocalClienteUltimaVisita, localRepository.findOne(idLocalClienteUltimaVisita));
            }

            if (idLocalClienteUltimaVisita != null) {
                clienteXLocalMap.put(idCliente, idLocalClienteUltimaVisita);
            }
        }

        List<Cliente> clientes = new ArrayList<>();
        if (!idClientesAConsultar.isEmpty()) {
            clientes = clienteRepository.consultaCliente(apPersona, amPersona, noPersona, nuDocumento, coTipoDocumento, inPromocion, idClientesAConsultar);
        }
        return new ClienteConverter(localMap, clienteXLocalMap).convertList(clientes);
    }
}
