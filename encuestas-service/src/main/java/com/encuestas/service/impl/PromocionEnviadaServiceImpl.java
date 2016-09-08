/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import com.encuestas.data.bean.ClienteBean;
import com.encuestas.data.bean.PersonaBean;
import com.encuestas.data.bean.PromocionBean;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.encuestas.data.bean.PromocionEnviadaBean;
import com.encuestas.data.model.PromocionEnviada;
import com.encuestas.data.repository.PromocionEnviadaRepository;
import com.encuestas.service.PromocionEnviadaService;
import com.encuestas.service.converter.PromocionEnviadaConverter;
import com.encuestas.util.DateUtils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Service
public class PromocionEnviadaServiceImpl implements PromocionEnviadaService{
    @Autowired
    private PromocionEnviadaRepository promocionEnviadaRepository;
    private final Logger LOGGER = Logger.getLogger(PromocionEnviadaServiceImpl.class);

    
    @Override
    public List<PromocionEnviadaBean> listEnvios(Integer idPromocion) {
          return new PromocionEnviadaConverter().convertList(promocionEnviadaRepository.findByPromocionIdPromocion(idPromocion));
    }


    @Override
    @Transactional
    public Page<PromocionEnviadaBean> listEnviosFiltros(Integer idPromocion,
                                                        String feInicio, String feFin, String nuDocumento, Integer page, Integer pageSize) {
        Page<PromocionEnviada> listEnviada;
        Date dateIni = new Date(), dateFin = new Date();
        try {
            dateIni = new SimpleDateFormat("yyyy-MM-dd").parse(feInicio);
            dateFin = new SimpleDateFormat("yyyy-MM-dd").parse(feFin);
            dateFin = DateUtils.sumarDias(dateFin, 1);
        } catch (ParseException e) {
            LOGGER.error(e);
        }
        Pageable pageable = new PageRequest(page, pageSize);
        listEnviada = promocionEnviadaRepository.findByPromocionEnviadaFiltros(idPromocion, dateIni, dateFin, nuDocumento, pageable);

        return listEnviada.map(new PromocionEnviadaConverter());
    }

    
}
