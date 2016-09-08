/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import com.encuestas.data.model.RespuestaEncuesta;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Alejandro
 */
public interface ReporteRepository extends JpaRepository<RespuestaEncuesta, Integer>{
 
    
    @Query(value = "select coalesce(re.de_pregunta,'') de_pregunta,coalesce(re.de_respuesta_corta,'') de_respuesta_corta,"
            + " coalesce(count(*),0) cant,coalesce(lo.no_local,'') no_local from ectd_encuesta_respuesta re"
             + " inner join ectc_encuesta en on en.id_encuesta = re.id_encuesta "
             + " inner join ectd_plantilla_encuesta pl on pl.id_plantilla_encuesta_detalle=re.id_plantilla_encuesta_detalle"
             + " inner join ectm_local lo on lo.id_local = en.id_local"
             + " where "
            + "((?1) = 0 or en.id_local = cast((?1) as integer)) "
             + " and in_es_rpta_corta = true "
             + " and fe_encuesta between cast(coalesce(?2, '1970-01-01 00:00:00') as timestamp) "
            + " and cast(coalesce(?3, '1970-01-01 00:00:00') as timestamp) "
            + "  and ((?4) = 0 or re.id_plantilla_encuesta_detalle = cast((?4) as integer)) "
             + " group by re.de_pregunta,re.id_plantilla_encuesta_detalle,re.de_respuesta_corta, lo.no_local"
             + " order by re.de_pregunta asc", 
    nativeQuery = true)
    public List<Object[]> reporteSatisfaccion (Integer idLocal, Date feDesde, Date feHasta, Integer idPregunta);
}
