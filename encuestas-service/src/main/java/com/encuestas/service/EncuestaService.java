/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.encuestas.data.bean.EncuestaBean;

public interface EncuestaService {
    
    public EncuestaBean createEncuesta (EncuestaBean encuestaBean);
    
    public List<EncuestaBean> consultaEncuesta (Date feDesde, Date feHasta, Integer idPlantillaEncuesta, PageRequest pageRequest);
    
    public EncuestaBean cargarEncuesta (Integer idEncuesta);
    
    public Integer getCorrelativoEncuesta(String username);
}
