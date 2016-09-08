package com.encuestas.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

//import com.encuestas.data.bean.ColaboradorBean;
import com.encuestas.data.bean.UsuarioBean;
import com.encuestas.data.bean.UsuarioRolBean;
import com.encuestas.data.model.CargoColaborador;
import com.encuestas.data.model.Colaborador;
import com.encuestas.data.model.Local;
import com.encuestas.data.model.Persona;
import com.encuestas.data.model.Usuario;
import com.encuestas.data.model.UsuarioRol;
import com.encuestas.data.repository.ColaboradorRepository;
import com.encuestas.data.repository.LocalRepository;
import com.encuestas.data.repository.PersonaRepository;
import com.encuestas.data.repository.RolRepository;
import com.encuestas.data.repository.UsuarioRepository;
import com.encuestas.data.repository.UsuarioRolRepository;
//import com.encuestas.service.ColaboradorService;
import com.encuestas.service.UsuarioService;
import com.encuestas.service.converter.ColaboradorConverter;
import com.encuestas.service.converter.UsuarioBeanToModelConverter;
import com.encuestas.service.converter.UsuarioModelToBeanConverter;
import com.encuestas.service.exception.ApplicationException;
import com.encuestas.service.exception.DataValidationErrorException;
import com.encuestas.service.validator.UsuarioValidator;
import com.encuestas.util.EncryptionUtils;

@Service
public class UsuarioServiceImpl implements UsuarioService {
  private static final Logger LOGGER = LogManager.getLogger(UsuarioServiceImpl.class);
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private UsuarioRolRepository usuarioRolRepository;
    @Autowired
    private LocalRepository localRepository;
    @Autowired
    private ColaboradorRepository colaboradorRepository;
//    @Autowired
//    private ColaboradorService colaboradorService;
    @Autowired
    private MessageSource messageSource;

    @Override
    @Transactional
    public UsuarioBean findByUsername(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        UsuarioBean usuarioBean = new UsuarioModelToBeanConverter().convert(usuario);

        List<Colaborador> colaboradorList = colaboradorRepository.findByUsuarioUsernameOrderByPersonaNoPersonaAsc(usuario.getUsername());
        
        if (!colaboradorList.isEmpty()) {
            Colaborador colaborador = colaboradorList.get(0);
            if (colaborador.getCargoColaborador() != null) {
              usuarioBean.setCargo(colaborador.getCargoColaborador().getCoCargoColaborador());
            }
            usuarioBean.setColaborador(new ColaboradorConverter().convert(colaborador));
        }
        return usuarioBean;
    }

    @Override
    @Transactional
    public List<UsuarioBean> listaTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return new UsuarioModelToBeanConverter().convertList(usuarios);
    }

    @Override
    @Transactional
    public UsuarioBean cargarDatosPorId(Integer idUsuario) {
        Usuario usuario = usuarioRepository.findOne(idUsuario);
        UsuarioBean usuarioBean = new UsuarioModelToBeanConverter().convert(usuario);
        
        List<Colaborador> colaboradorList = colaboradorRepository.findByUsuarioUsernameOrderByPersonaNoPersonaAsc(usuario.getUsername());
        
        if (!colaboradorList.isEmpty()) {
            Colaborador colaborador = colaboradorList.get(0);
            if (colaborador.getCargoColaborador() != null) {
              usuarioBean.setCargo(colaborador.getCargoColaborador().getCoCargoColaborador());
            }
            usuarioBean.setColaborador(new ColaboradorConverter().convert(colaborador));
        }
        return usuarioBean;
    }

    @Override
    @Transactional
    public UsuarioBean crear(UsuarioBean usuarioBean, String usernameCreador, String coCargoColaborador) throws DataValidationErrorException {
        DataBinder dataBinder = new DataBinder(usuarioBean);
        dataBinder.setValidator(new UsuarioValidator());

        dataBinder.validate();
        BindingResult bindingResult = dataBinder.getBindingResult();
        if (bindingResult.hasErrors()) {
          throw new DataValidationErrorException(bindingResult, messageSource);
        }

        Usuario usuarioExiste = usuarioRepository.findByUsernameIgnoreCase(usuarioBean.getUsername());

        if (usuarioExiste != null) {
            throw new ApplicationException("El usuario ya se encuentra registrado.");
        }

        Usuario usuarioCreador = usuarioRepository.findByUsername(usernameCreador);
        Usuario usuario = new UsuarioBeanToModelConverter().convert(usuarioBean);
        usuario.setEmpresa(usuarioCreador.getEmpresa());
        
        try {
            MessageDigest digester = MessageDigest.getInstance("MD5");
            digester.update(usuario.getPassword().getBytes());
            byte[] hash = digester.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
            usuario.setPassword(hexString.toString());
        } catch (NoSuchAlgorithmException e) {}
        
        List<Persona> personas = personaRepository.findByNuDocumentoAndTipoDocumentoCoTipoDocumento(usuario.getPersona().getNuDocumento(), usuario.getPersona().getTipoDocumento().getCoTipoDocumento());
        if (!personas.isEmpty()) {
            Persona persona = personas.get(0);
            persona.setNoPersona(usuario.getPersona().getNoPersona());
            persona.setApPersona(usuario.getPersona().getApPersona());
            persona.setAmPersona(usuario.getPersona().getAmPersona());
            usuario.setPersona(persona);
        }
        personaRepository.save(usuario.getPersona());
        usuarioRepository.save(usuario);
        
        Map<Integer, UsuarioRol> rolesAsignados = new HashMap<>();
        for (UsuarioRolBean usuarioRolBean : usuarioBean.getUsuarioRols()) {
            UsuarioRol usuarioRol = new UsuarioRol();
            usuarioRol.setIdRol(usuarioRolBean.getRol().getIdRol());
            usuarioRol.setIdUsuario(usuario.getIdUsuario());
            usuarioRol.setRol(rolRepository.findOne(usuarioRolBean.getRol().getIdRol()));
            usuarioRol.setUsuario(usuario);
            rolesAsignados.put(usuarioRolBean.getRol().getIdRol(), usuarioRol);
        }
        
        usuarioRolRepository.save(rolesAsignados.values());
        
        usuario.setUsuarioRol(new ArrayList<UsuarioRol>(rolesAsignados.values()));

//        ColaboradorBean colaboradorBean = colaboradorService.getColaborador(usernameCreador);
        Local local = localRepository.findOne(usuarioBean.getColaborador().getLocal().getIdLocal());
        
        Colaborador colaborador = new Colaborador();
        colaborador.setLocal(local);
        colaborador.setPersona(usuario.getPersona());
        colaborador.setUsuario(usuario);
        colaborador.setCargoColaborador(new CargoColaborador());
        colaborador.getCargoColaborador().setCoCargoColaborador(coCargoColaborador);
        
        colaboradorRepository.save(colaborador);
        
        return new UsuarioModelToBeanConverter().convert(usuario);
    }

    @Override
    @Transactional
    public UsuarioBean actualizar(UsuarioBean usuarioBean, String coCargoColaborador) throws DataValidationErrorException {
        DataBinder dataBinder = new DataBinder(usuarioBean);
        dataBinder.setValidator(new UsuarioValidator());

        dataBinder.validate();
        BindingResult bindingResult = dataBinder.getBindingResult();
        if (bindingResult.hasErrors()) {
          throw new DataValidationErrorException(bindingResult, messageSource);
        }
        
        Usuario usuario = usuarioRepository.findOne(usuarioBean.getIdUsuario());
        
        Map<Integer, UsuarioRol> rolesAsignados = new HashMap<>();
        for (UsuarioRolBean usuarioRolBean : usuarioBean.getUsuarioRols()) {
            UsuarioRol usuarioRol = new UsuarioRol();
            usuarioRol.setIdRol(usuarioRolBean.getRol().getIdRol());
            usuarioRol.setIdUsuario(usuario.getIdUsuario());
            usuarioRol.setRol(rolRepository.findOne(usuarioRolBean.getRol().getIdRol()));
            usuarioRol.setUsuario(usuario);
            rolesAsignados.put(usuarioRolBean.getRol().getIdRol(), usuarioRol);
        }
        
        for (UsuarioRol usuarioRol : usuario.getUsuarioRol()) {
            if (rolesAsignados.get(usuarioRol.getRol().getIdRol()) == null) {
                usuarioRolRepository.delete(usuarioRol);
            }
        }

        usuario.getPersona().setAmPersona(usuarioBean.getPersona().getAmPersona());
        usuario.getPersona().setApPersona(usuarioBean.getPersona().getApPersona());
        usuario.getPersona().setNoPersona(usuarioBean.getPersona().getNoPersona());
        
        usuario.setEstado(usuarioBean.getEstado());
        usuario.setInAdmin(usuarioBean.getInAdmin());

        personaRepository.save(usuario.getPersona());
        usuarioRepository.save(usuario);
        usuarioRolRepository.save(rolesAsignados.values());
        
        List<Colaborador> colaboradorList = colaboradorRepository.findByUsuarioUsernameOrderByPersonaNoPersonaAsc(usuario.getUsername());
        
        if (!colaboradorList.isEmpty()) {
            Colaborador colaborador = colaboradorList.get(0);
            colaborador.setCargoColaborador(new CargoColaborador());
            colaborador.getCargoColaborador().setCoCargoColaborador(coCargoColaborador);
            if (usuarioBean.getColaborador() != null && usuarioBean.getColaborador().getLocal() != null) {
                colaborador.setLocal(new Local());
                colaborador.getLocal().setIdLocal(usuarioBean.getColaborador().getLocal().getIdLocal());
            }
            colaboradorRepository.save(colaborador);
        }
        
        usuario.setUsuarioRol(new ArrayList<UsuarioRol>(rolesAsignados.values()));
        return new UsuarioModelToBeanConverter().convert(usuario);
    }

    @Override
    @Transactional
    public UsuarioBean changePassword(Integer idUsuario, String oldPassword, String newPassword, Boolean verifyPassword) throws ApplicationException {
      if (oldPassword == null) {
        oldPassword = "";
      }
      
      Usuario usuario = usuarioRepository.findOne(idUsuario);
      String encodedNewPassword = newPassword;
      String encodedOldPassword = oldPassword;
      
      encodedNewPassword = EncryptionUtils.encodeMd5String(newPassword);
      encodedOldPassword = EncryptionUtils.encodeMd5String(oldPassword);
      
      if (verifyPassword && !usuario.getPassword().equals(encodedOldPassword)) {
        throw new ApplicationException("Las contraseñas no son correctas.");
      }
      
      usuario.setPassword(encodedNewPassword);
      usuarioRepository.save(usuario);
      
      LOGGER.info("Changing password for user "+usuario.getUsername());
      
      return new UsuarioModelToBeanConverter().convert(usuario);
    }

}
