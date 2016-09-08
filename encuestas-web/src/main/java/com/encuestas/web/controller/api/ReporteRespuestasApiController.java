package com.encuestas.web.controller.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encuestas.data.bean.RespuestaEncuestaReporteBean;
import com.encuestas.service.ReporteService;
import com.encuestas.service.RespuestaEncuestaReporteService;
import java.text.ParseException;

@RestController
public class ReporteRespuestasApiController {
  private static final Logger LOGGER = LogManager.getLogger(ReporteRespuestasApiController.class);
    @Autowired
    private RespuestaEncuestaReporteService respuestaEncuestaReporteService;
    @Autowired
    private ReporteService reporteService;

    @RequestMapping(value = "/api/reporteRespuesta")
    public List<RespuestaEncuestaReporteBean> list() {
        return respuestaEncuestaReporteService.consultarReporte();
    }
    
    @RequestMapping(value = "/api/reporteEncuestaRespuestas", method = RequestMethod.GET)
    public List<Map<String, ?>> reporteEncuestaRespuestas (@RequestParam Integer idEncuesta,
        @RequestParam(required=false) String coTipoPregunta, @RequestParam Date desde, @RequestParam Date hasta) {
      return respuestaEncuestaReporteService.consultaResultados(idEncuesta, coTipoPregunta, desde, hasta);
    }
    
    @RequestMapping(value = "/api/reporteSatisfaccion", method = RequestMethod.GET)
    public List<Map<String, Object>> reporteSatisfaccion (@RequestParam Integer idLocal,
             @RequestParam String desde, @RequestParam String hasta, @RequestParam Integer idPregunta) throws ParseException{
      return reporteService.reporteSatisfaccion(idLocal, desde, hasta, idPregunta);
    }
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
