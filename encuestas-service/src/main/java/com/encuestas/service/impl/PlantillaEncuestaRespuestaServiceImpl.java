/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import com.encuestas.data.bean.LocalBean;
import com.encuestas.data.bean.PlantillaEncuestaRespuestaBean;
import com.encuestas.data.model.PlantillaEncuestaRespuesta;
import com.encuestas.data.repository.PlantillaEncuestaRespuestaRepository;
import com.encuestas.service.PlantillaEncuestaRespuestaService;
import com.encuestas.service.converter.PlantillaEncuestaRespuestaConverter;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlantillaEncuestaRespuestaServiceImpl implements PlantillaEncuestaRespuestaService{


    @Autowired
    private PlantillaEncuestaRespuestaRepository plantillaEncuestaRespuestaRepository;
    @Autowired
    private LocalServiceImpl localServiceImpl;
    private final Logger LOGGER = Logger.getLogger(PlantillaEncuestaRespuestaServiceImpl.class);

    @Override
    public List<PlantillaEncuestaRespuestaBean> listRespuesta(Integer idPlantillaEncuestaDetalle) {
             List<PlantillaEncuestaRespuesta> listPreguntas = 
                             plantillaEncuestaRespuestaRepository.findByPlantillaEncuestaPreguntaIdPlantillaEncuestaDetalleOrderByNuOrdenAsc(idPlantillaEncuestaDetalle);

            return new PlantillaEncuestaRespuestaConverter().convertList(listPreguntas);
    }


	
    
}
