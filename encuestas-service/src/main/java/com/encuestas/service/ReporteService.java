/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;


public interface ReporteService {
    
    public List<Map<String, Object>> reporteSatisfaccion (Integer idLocal, String feDesde, String feHasta, Integer idPregunta) 
            throws ParseException;
  
}
