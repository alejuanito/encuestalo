package com.encuestas.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.encuestas.data.bean.RespuestaEncuestaReporteBean;

public interface RespuestaEncuestaReporteService {
    
    public List<RespuestaEncuestaReporteBean> consultarReporte ();
    
    public List<Map<String, ?>> consultaResultados(Integer idEncuesta, String coTipoPregunta, Date desde, Date hasta);

}
