/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encuestas.data.bean.EncuestaBean;
import com.encuestas.data.bean.LocalBean;
import com.encuestas.data.model.Encuesta;
import com.encuestas.data.repository.EncuestaRepository;
import com.encuestas.data.repository.RespuestaEncuestaRepository;
import com.encuestas.service.EncuestaService;
import com.encuestas.service.LocalService;
import com.encuestas.service.converter.EncuestaBeanConverter;
import com.encuestas.service.converter.EncuestaConverter;


@Service
public class EncuestaServiceImpl implements EncuestaService{
    @Autowired
    private EncuestaRepository encuestaRepository;
    @Autowired
    private LocalService localService;
    @Autowired
    private RespuestaEncuestaRepository respuestaEncuestaRepository;
    @PersistenceContext
    private EntityManager entityManager;

    private final Logger LOGGER = Logger.getLogger(EncuestaServiceImpl.class);

	@Override
	@Transactional
	public EncuestaBean createEncuesta(EncuestaBean encuestaBean) {
		Encuesta encuesta = encuestaRepository.save(new EncuestaBeanConverter().convert(encuestaBean));
		encuesta.setFeEncuesta(new Date());
		return new EncuestaConverter().convert(encuesta);
	}

    @Override
    public List<EncuestaBean> consultaEncuesta(Date feDesde, Date feHasta, Integer idPlantillaEncuesta, PageRequest pageRequest) {
//        List<Integer> idEncuestaList = respuestaEncuestaRepository.buscarDistinctIdEncuesta(idPlantillaEncuesta, pageRequest);
//        List<Encuesta> encuestaList = encuestaRepository.findByIdEncuestaIn(idEncuestaList);
       // return new EncuestaConverter().convertList(encuestaList);
        return null;
    }

	@Override
	public EncuestaBean cargarEncuesta(Integer idEncuesta) {
		Encuesta encuesta = encuestaRepository.findOne(idEncuesta);
		return new EncuestaConverter().convert(encuesta);
	}
    
	@Override
        public Integer getCorrelativoEncuesta(String username){
            LocalBean local = localService.getLocal(username);
            return encuestaRepository.findCorrelativo(local.getIdLocal())+1;
        }
}
