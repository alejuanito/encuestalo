package com.encuestas.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.encuestas.data.bean.RolBean;
import com.encuestas.data.bean.RolOpcionBean;
import com.encuestas.data.model.Opcion;
import com.encuestas.data.model.Rol;
import com.encuestas.data.model.RolOpcion;
import com.encuestas.data.model.RolOpcionPK;
import com.encuestas.data.repository.RolOpcionRepository;
import com.encuestas.data.repository.RolRepository;
import com.encuestas.service.RolService;
import com.encuestas.service.converter.RolBeanToModelConverter;
import com.encuestas.service.converter.RolModelToBeanConverter;
import com.encuestas.service.exception.DataValidationErrorException;
import com.encuestas.service.validator.RolValidator;
import com.encuestas.util.Constantes;

@Service
public class RolServiceImpl implements RolService {
  @Autowired
  private RolRepository rolRepository;
  @Autowired
  private RolOpcionRepository rolOpcionRepository;
  @Autowired
  private MessageSource messageSource;

  @Override
  @Transactional
  public List<RolBean> listAll() {
    return new RolModelToBeanConverter().convertList(rolRepository.findAll());
  }

  @Override
  @Transactional
  public RolBean load(Integer idRol) {
    return new RolModelToBeanConverter().convert(rolRepository.findOne(idRol));
  }

  @Override
  @Transactional
  public RolBean create(RolBean rolBean) throws DataValidationErrorException {
    DataBinder dataBinder = new DataBinder(rolBean);
    dataBinder.setValidator(new RolValidator());

    dataBinder.validate();
    BindingResult bindingResult = dataBinder.getBindingResult();
    if (bindingResult.hasErrors()) {
      throw new DataValidationErrorException(bindingResult, messageSource);
    }

    Rol rol = new RolBeanToModelConverter().convert(rolBean);

    rol = rolRepository.save(rol);
    HashMap<String, RolOpcion> newOpcions = new HashMap<>();

    for (RolOpcionBean rolOpcionBean : rolBean.getRolOpciones()) {
      RolOpcion rolOpcion = new RolOpcion();
      rolOpcion.getOpcion().setCodigo(rolOpcionBean.getCoOpcion());
      rolOpcion.setCoOpcion(rolOpcionBean.getCoOpcion());
      rolOpcion.setIdRol(rol.getIdRol());
      rolOpcion.setRol(rol);
      newOpcions.put(rolOpcionBean.getOpcion().getCodigo(), rolOpcion);
    }
    
    rolOpcionRepository.save(newOpcions.values());
    rol.setRolOpciones(new ArrayList<>(newOpcions.values()));
    
    return new RolModelToBeanConverter().convert(rol);
  }

  @Override
  @Transactional
  public RolBean update(RolBean rolBean) throws DataValidationErrorException {
    DataBinder dataBinder = new DataBinder(rolBean);
    dataBinder.setValidator(new RolValidator());

    dataBinder.validate();
    BindingResult bindingResult = dataBinder.getBindingResult();
    if (bindingResult.hasErrors()) {
      throw new DataValidationErrorException(bindingResult, messageSource);
    }
    
    Rol rol = rolRepository.findOne(rolBean.getIdRol());

    HashMap<String, RolOpcion> newOpcions = new HashMap<>();

    for (RolOpcionBean rolOpcionBean : rolBean.getRolOpciones()) {
      RolOpcion rolOpcion = new RolOpcion();
      rolOpcion.getOpcion().setCodigo(rolOpcionBean.getCoOpcion());
      rolOpcion.setCoOpcion(rolOpcionBean.getCoOpcion());
      rolOpcion.setIdRol(rolBean.getIdRol());
      rolOpcion.setRol(rol);
      newOpcions.put(rolOpcionBean.getOpcion().getCodigo(), rolOpcion);
    }

    for (RolOpcion rolOpcion : rol.getRolOpciones()) {
      if (newOpcions.get(rolOpcion.getOpcion().getCodigo()) == null) {
         rolOpcionRepository.delete(new RolOpcionPK(rol.getIdRol(), rolOpcion.getOpcion().getCodigo()));
      }
    }

    rol.setEstado(rolBean.getEstado());
    rol.setNombre(rolBean.getNombre());
    
    rol = rolRepository.save(rol);
    
    rolOpcionRepository.save(newOpcions.values());
    rol.setRolOpciones(new ArrayList<>(newOpcions.values()));
    
    return new RolModelToBeanConverter().convert(rol);
  }

}
