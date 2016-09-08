/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.encuestas.service.impl;

import com.encuestas.data.bean.PlantillaEncuestaBean;
import com.encuestas.data.model.PlantillaEncuesta;
import com.encuestas.data.model.Usuario;
import com.encuestas.data.repository.PlantillaEncuestaRepository;
import com.encuestas.data.repository.UsuarioRepository;
import com.encuestas.service.PlantillaEncuestaService;
import com.encuestas.service.converter.PlantillaEncuestaConverter;
import com.encuestas.service.exception.DataValidationErrorException;
import com.encuestas.service.validator.PlantillaEncuestaValidator;
import com.encuestas.util.enums.EstadoEnum;
import com.encuestas.util.enums.TipoEncuestaEnum;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;


@Service
public class PlantillaEncuestaServiceImpl implements PlantillaEncuestaService {
  @Autowired
  private PlantillaEncuestaRepository plantillaEncuestaRepository;
  @Autowired
  private UsuarioRepository usuarioRepository;
  @Autowired
  private MessageSource messageSource;

  private final Logger LOGGER = Logger.getLogger(PlantillaEncuestaServiceImpl.class);

  @Override
  public List<PlantillaEncuestaBean> listAll() {
    List<PlantillaEncuesta> plantillas;
    plantillas = plantillaEncuestaRepository.findAll();
    return new PlantillaEncuestaConverter().convertList(plantillas);
  }

  @Override
  @Transactional
  public List<PlantillaEncuestaBean> listPreguntaAndRespuesta(Integer idLocal) {
    List<PlantillaEncuesta> plantillaEncuesta;
    plantillaEncuesta = plantillaEncuestaRepository
        .findEncuestaPreguntaRespuestaByLocalAndTipoEncuesta(idLocal, "ATEN", EstadoEnum.ACTIVO.getCodigo());
    return new PlantillaEncuestaConverter().convertList(plantillaEncuesta);
  }

  @Override
  @Transactional
  public PlantillaEncuestaBean load(Integer idPlantillaEncuesta) {
    PlantillaEncuesta plantillaEncuesta = plantillaEncuestaRepository.findOne(idPlantillaEncuesta);
    return new PlantillaEncuestaConverter().convert(plantillaEncuesta);
  }

  @Override
  @Transactional
  public PlantillaEncuestaBean create(PlantillaEncuestaBean plantillaEncuestaBean, String username)
      throws DataValidationErrorException {
    // validation
    DataBinder dataBinder = new DataBinder(plantillaEncuestaBean);
    dataBinder.setValidator(new PlantillaEncuestaValidator());

    dataBinder.validate();
    BindingResult bindingResult = dataBinder.getBindingResult();
    if (bindingResult.hasErrors()) {
      throw new DataValidationErrorException(bindingResult, messageSource);
    }
    // end validation

    Usuario usuario = usuarioRepository.findByUsername(username);
    PlantillaEncuesta plantillaEncuesta = new PlantillaEncuesta(plantillaEncuestaBean);
    plantillaEncuesta.setCoTipoEncuesta(TipoEncuestaEnum.ATENCION.getCodigo());
    plantillaEncuesta.setUsuario(usuario);
    // Si no se actualiza desde el metodo correcto ignorar.
    if (plantillaEncuesta.getIdPlantillaEncuesta() == null) {
      plantillaEncuestaRepository.save(plantillaEncuesta);
    }
    return new PlantillaEncuestaConverter().convert(plantillaEncuesta);
  }

  @Override
  @Transactional
  public PlantillaEncuestaBean update(PlantillaEncuestaBean plantillaEncuestaBean, String username) {
    PlantillaEncuesta plantillaEncuesta = new PlantillaEncuesta(plantillaEncuestaBean);
     Usuario usuario = usuarioRepository.findByUsername(username);
    // Si no se actualiza desde el metodo correcto ignorar.
    if (plantillaEncuesta.getIdPlantillaEncuesta() != null) {
        plantillaEncuesta.setUsuario(usuario);
      plantillaEncuestaRepository.save(plantillaEncuesta);
    }
    return new PlantillaEncuestaConverter().convert(plantillaEncuesta);
  }
}
