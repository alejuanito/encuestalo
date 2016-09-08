package com.encuestas.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encuestas.data.bean.RespuestaEncuestaReporteBean;
import com.encuestas.data.bean.RespuestaEncuestaReporteBean.Respuesta;
import com.encuestas.data.model.PlantillaEncuesta;
import com.encuestas.data.model.PlantillaEncuestaPregunta;
import com.encuestas.data.model.PlantillaEncuestaRespuesta;
import com.encuestas.data.repository.PlantillaEncuestaPreguntaRepository;
import com.encuestas.data.repository.PlantillaEncuestaRespuestaRepository;
import com.encuestas.data.repository.RespuestaEncuestaRepository;
import com.encuestas.service.RespuestaEncuestaReporteService;
import com.encuestas.service.converter.PlantillaEncuestaPreguntaConverter;
import com.encuestas.service.converter.PlantillaEncuestaRespuestaConverter;
import com.encuestas.util.DateUtils;

@Service
public class RespuestaEncuestaReporteServiceImpl implements RespuestaEncuestaReporteService {
  private static final Logger LOGGER = LogManager.getLogger(RespuestaEncuestaReporteServiceImpl.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PlantillaEncuestaPreguntaRepository plantillaEncuestaPreguntaRepository;
    @Autowired
    private PlantillaEncuestaRespuestaRepository plantillaEncuestaRespuestaRepository;
    @Autowired
    private RespuestaEncuestaRepository respuestaEncuestaRepository;

    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_ID_ENCUESTA = "id_encuesta";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_FE_ENCUESTA = "fe_encuesta";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NU_ORDEN = "nu_orden";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_DE_PREGUNTA = "de_pregunta";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_DE_RESPUESTA_CORTA = "de_respuesta_corta";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_DE_RESPUESTA_LARGA = "de_respuesta_larga";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_AP_PERSONA = "ap_persona";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_AM_PERSONA = "am_persona";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NO_PERSONA = "no_persona";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_TIPO_DOCUMENTO = "tipo_documento";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NU_DOCUMENTO = "nu_documento";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_EDAD = "edad";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_CO_SEXO = "co_sexo";

    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NU_MESA = "nu_mesa";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NO_COLABORADOR = "no_colaborador";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_AP_COLABORADOR = "ap_colaborador";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_AM_COLABORADOR = "am_colaborador";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NO_LOCAL = "no_local";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NU_DOCUMENTO_COLABORADOR = "nu_documento_colaborador";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_IN_PROMOCION = "in_promocion";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_TL_CELULAR = "tl_celular";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_TL_FIJO = "tl_fijo";
    private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_DE_EMAIL = "de_email";
     private static final String REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NO_USUARIO = "no_usuario";

    @Override
    public List<RespuestaEncuestaReporteBean> consultarReporte() {
        String sql = "select r.id_plantilla_encuesta_detalle, id_respuesta, count(*) cuenta "
                + "from ectd_encuesta_respuesta r "
                + "left join ectd_plantilla_encuesta p on (r.id_plantilla_encuesta_detalle = p.id_plantilla_encuesta_detalle) "
                + "where p.in_es_rpta_corta "
                + "group by r.id_plantilla_encuesta_detalle, id_respuesta "
                + "order by r.id_plantilla_encuesta_detalle, id_respuesta";
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> result = query.getResultList();
        Set<Integer> idPlantillaEncuestaDetalleList = new HashSet<>();
        Set<Integer> idRespuestaList = new HashSet<>();
        for (Object[] o : result) {
            idPlantillaEncuestaDetalleList.add((Integer) o[0]);
            idRespuestaList.add((Integer) o[1]);
        }
//        List<PlantillaEncuestaPregunta> plantillaEncuestaPreguntaList = plantillaEncuestaPreguntaRepository.findByIdPlantillaEncuestaDetalleIn(idPlantillaEncuestaDetalleList);
//        List<PlantillaEncuestaRespuesta> plantillaEncuestaRespuestaList = plantillaEncuestaRespuestaRepository.findByIdRespuestaIn(idRespuestaList);

         List<PlantillaEncuestaPregunta> plantillaEncuestaPreguntaList ;
         List<PlantillaEncuestaRespuesta> plantillaEncuestaRespuestaList ;

        
        Map<Integer, PlantillaEncuestaPregunta> plantillaEncuestaPreguntaMap = new HashMap<>();
        Map<Integer, PlantillaEncuestaRespuesta> plantillaEncuestaRespuestaMap = new HashMap<>();
        
//        for (PlantillaEncuestaPregunta plantillaEncuestaPregunta : plantillaEncuestaPreguntaList) {
//            plantillaEncuestaPreguntaMap.put(plantillaEncuestaPregunta.getIdPlantillaEncuestaDetalle(), plantillaEncuestaPregunta);
//        }
//        
//        for (PlantillaEncuestaRespuesta plantillaEncuestaRespuesta : plantillaEncuestaRespuestaList) {
//            plantillaEncuestaRespuestaMap.put(plantillaEncuestaRespuesta.getIdRespuesta(), plantillaEncuestaRespuesta);
//        }
        
        Map<Integer, RespuestaEncuestaReporteBean> report = new HashMap<>();

        PlantillaEncuestaPreguntaConverter converter = new PlantillaEncuestaPreguntaConverter();
        PlantillaEncuestaRespuestaConverter converter2 = new PlantillaEncuestaRespuestaConverter();
        for (Object[] o : result) {
            Integer idPlantillaEncuestaDetalle = (Integer) o[0];
            Integer idRespuesta = (Integer) o[1];
            BigInteger cuenta = (BigInteger) o[2];
            
            RespuestaEncuestaReporteBean respuestaEncuestaReporteBean = report.get(idPlantillaEncuestaDetalle);
            if (respuestaEncuestaReporteBean == null) {
                respuestaEncuestaReporteBean = new RespuestaEncuestaReporteBean();
                PlantillaEncuestaPregunta preg = plantillaEncuestaPreguntaMap.get(idPlantillaEncuestaDetalle);
                respuestaEncuestaReporteBean.setPlantillaEncuestaPregunta(converter.convert(preg));
                respuestaEncuestaReporteBean.setId(preg.getIdPlantillaEncuestaDetalle());
                report.put(idPlantillaEncuestaDetalle, respuestaEncuestaReporteBean);
            }
            RespuestaEncuestaReporteBean.Respuesta rpta = new Respuesta();
            rpta.setCuenta(cuenta);
            rpta.setPlantillaEncuestaRespuestaBean(converter2.convert(plantillaEncuestaRespuestaMap.get(idRespuesta)));
            respuestaEncuestaReporteBean.getRespuestas().add(rpta);
        }
        return new ArrayList<>(report.values());
    }

    @Override
    public List<Map<String, ?>> consultaResultados(Integer idEncuesta, String coTipoPregunta, Date desde, Date hasta) {
      List<Map<String, ?>> data = new ArrayList<>();
      hasta = DateUtils.sumarDias(hasta, 1);
      List<Object[]> queryResult = respuestaEncuestaRepository.reporteEncuestaRespuesta(idEncuesta, coTipoPregunta, desde, hasta);
      
      for (Object[] array : queryResult) {
        DateFormat df = new SimpleDateFormat("yy-M-d HH:mm:ss z");
//        df.setTimeZone(TimeZone.getTimeZone("America/Lima"));
        Date d = (Date) array[1];
        LOGGER.debug(d.getTime());
        LOGGER.debug(df.format(array[1]));
        
        Map<String, Object> obj = new HashMap<>();
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_ID_ENCUESTA, array[0]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_FE_ENCUESTA, array[1]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NU_ORDEN, Integer.parseInt(array[2].toString()));
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_DE_PREGUNTA, array[3].toString());
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_DE_RESPUESTA_CORTA, array[4] == null ? "" : array[4].toString());
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_DE_RESPUESTA_LARGA, array[5] == null ? "" : array[5].toString());
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_AP_PERSONA, array[6] == null ? "" : array[6]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_AM_PERSONA, array[7] == null ? "" : array[7]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NO_PERSONA, array[8] == null ? "" : array[8]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_TIPO_DOCUMENTO, array[9] == null ? "" : array[9]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NU_DOCUMENTO, array[10] == null ? "" : array[10]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_EDAD, new BigDecimal(array[11] == null ? "0" : array[11].toString()).intValue());
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_CO_SEXO, array[12] == null ? "" : array[12]);

        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NU_MESA, array[13]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NO_COLABORADOR, array[14]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_AP_COLABORADOR, array[15]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_AM_COLABORADOR, array[16]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NO_LOCAL, String.format("%03d", Integer.parseInt(array[17].toString())));
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NU_DOCUMENTO_COLABORADOR, array[18]);

        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_IN_PROMOCION, array[19]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_TL_CELULAR, array[20]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_TL_FIJO, array[21]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_DE_EMAIL, array[22]);
        obj.put(REPORTE_ENCUESTA_RESPUESTAS_CAMPO_NO_USUARIO, array[23]);
        data.add(obj);
      }
      
      return data;
    }

}
