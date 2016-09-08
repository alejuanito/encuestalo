/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encuestas.data.bean.EncuestaBean;
import com.encuestas.data.bean.LocalBean;
import com.encuestas.data.bean.RespuestaEncuestaBean;
import com.encuestas.data.model.RespuestaEncuesta;
import com.encuestas.data.repository.EncuestaRepository;
import com.encuestas.data.repository.RespuestaEncuestaRepository;
import com.encuestas.service.EncuestaService;
import com.encuestas.service.LocalService;
import com.encuestas.service.RespuestaEncuestaService;
import com.encuestas.service.converter.RespuestaEncuestaBeanConverter;
import com.encuestas.service.converter.RespuestaEncuestaConverter;
import java.util.Date;

@Service
public class RespuestaEncuestaServiceImpl implements RespuestaEncuestaService {
    @Autowired
    private RespuestaEncuestaRepository respuestaEncuestaRepository;
    @Autowired
    private EncuestaService encuestaService;
    
    @Autowired
    private EncuestaRepository encuestaRepository;
    @Autowired
    private LocalService localService;

    private final Logger LOGGER = Logger.getLogger(RespuestaEncuestaServiceImpl.class);

    @Override
    public RespuestaEncuestaBean createRespuestaEncuesta(RespuestaEncuestaBean encuestaBean) {

        RespuestaEncuesta encuesta = respuestaEncuestaRepository
                .save(new RespuestaEncuestaBeanConverter().convert(encuestaBean));
        return new RespuestaEncuestaConverter().convert(encuesta);
    }

    @Override
    @Transactional
    public EncuestaBean createListRespuestaEncuesta(List<RespuestaEncuestaBean> listEncuestaBean, String username) {
        // TODO Auto-generated method stub
        EncuestaBean encuestaBean = new EncuestaBean();
        if (!listEncuestaBean.isEmpty()) {
            LocalBean local = localService.getLocal(username);
            
            encuestaBean = listEncuestaBean.get(0).getEncuesta();
            encuestaBean.setFeEncuesta(new Date());
            encuestaBean.setLocal(local);
            String nuEncuesta="";
            Integer correlativo = encuestaRepository.findCorrelativo(local.getIdLocal()) + 1;
            nuEncuesta = nuEncuesta.concat(String.format("%03d", local.getNuLocal())).concat("-").concat(String.format("%06d", correlativo));
            encuestaBean.setNuEncuesta(nuEncuesta);
            encuestaBean.setNuCorrelativo(correlativo);
           // encuestaBean.setLocal(local);
            encuestaBean = encuestaService.createEncuesta(encuestaBean);
            List<RespuestaEncuesta> listRespuestas = new ArrayList<>();
            for (RespuestaEncuestaBean obj : listEncuestaBean) {
                RespuestaEncuesta respuesta = new RespuestaEncuesta();
                obj.setEncuesta(encuestaBean);

                respuesta = new RespuestaEncuestaBeanConverter().convert(obj);
                listRespuestas.add(respuesta);
            }

            LOGGER.debug("List Respuesta" + listRespuestas.size());
            respuestaEncuestaRepository.save(listRespuestas);
            respuestaEncuestaRepository.flush();
        } else {

        }
        return encuestaBean;
    }

    @Override
    @Transactional
    public List<RespuestaEncuestaBean> listarRespestas(Integer idEncuesta) {
//        List<RespuestaEncuesta> respuestaEncuestaList = respuestaEncuestaRepository
//                .findByEncuestaIdEncuesta(idEncuesta);
//        return new RespuestaEncuestaConverter().convertList(respuestaEncuestaList);
        return null;
    }
}
