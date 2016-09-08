/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.encuestas.data.model.RespuestaEncuesta;


public interface RespuestaEncuestaRepository extends JpaRepository<RespuestaEncuesta, Integer>{
    
    public List<RespuestaEncuesta> findByEncuestaIdEncuesta(Integer idEncuesta);
     
    @Query("select distinct (e.idEncuesta) "
            + "from RespuestaEncuesta rpta "
            + "left join rpta.encuesta e "
            + "left join rpta.plantillaEncuestaPregunta pep "
            + "left join pep.plantillaEncuesta pe "
            + "where pe.idPlantillaEncuesta = ?1")
    public List<Integer> buscarDistinctIdEncuesta (Integer idPlantillaEncuesta, Pageable pageable);
    
    @Query(value = "select encuesta.nu_encuesta id_encuesta, encuesta.fe_encuesta, encuesta_detalle.nu_orden, coalesce(respuesta_detalle.de_pregunta ,'') de_pregunta, "
        + "coalesce(respuesta_detalle.de_respuesta_corta,'') de_respuesta_corta , respuesta_detalle.de_respuesta de_respuesta_larga, "
        + "persona.ap_persona, persona.am_persona, persona.no_persona, tipo_documento.de_corto tipo_documento, "
        + "persona.nu_documento, date_part('year', age(persona.fe_nacimiento)) edad, "
        + "persona.co_sexo, "
        + "atencion.nu_mesa, persona_colaborador.no_persona no_colaborador, persona_colaborador.ap_persona ap_colaborador, "
        + "persona_colaborador.am_persona am_colaborador, local_piombino.nu_local, persona_colaborador.nu_documento nu_documento_colaborador, "
        + "cliente.in_promocion, persona.nu_telefono_fijo, persona.nu_telefono_celular, persona.de_email,usu.no_usuario  "
        + "from ectd_encuesta_respuesta respuesta_detalle "
        + "left join ectd_plantilla_encuesta encuesta_detalle on (encuesta_detalle.id_plantilla_encuesta_detalle = respuesta_detalle.id_plantilla_encuesta_detalle) "
        + "left join ectd_plantilla_encuesta_respuesta encuesta_respuesta_corta on (encuesta_respuesta_corta.id_respuesta = respuesta_detalle.id_respuesta) "
        + "left join ectc_encuesta encuesta on (encuesta.id_encuesta = respuesta_detalle.id_encuesta) "
        + "left join ectm_cliente cliente on (cliente.id_cliente = encuesta.id_cliente) "
        + "left join ectm_persona persona on (persona.id_persona = cliente.id_persona) "
        + "left join ectm_tipo_documento tipo_documento on (tipo_documento.co_tipo_documento = persona.co_tipo_documento) "
        + "left join ectm_atencion atencion on (atencion.id_atencion = encuesta.id_atencion) "
        + "left join ectm_colaborador colaborador on (colaborador.id_colaborador = atencion.id_colaborador) "
        + "left join ectm_persona persona_colaborador on (persona_colaborador.id_persona = colaborador.id_persona) "
        + "left join ectm_area area on (area.id_area = atencion.id_area) "
        + "left join ectm_local local_piombino on (local_piombino.id_local = area.id_local) "
        + "left join ectc_plantilla_encuesta cpl on cpl.id_plantilla_encuesta= encuesta_detalle.id_plantilla_encuesta "
        + "left join ectm_usuario usu on usu.id_usuario = cpl.id_usuario_registro "
        + "where encuesta_detalle.id_plantilla_encuesta = ?1 "
        + "and (?2 = '' or ?2 = encuesta_detalle.co_tipo_pregunta) "
        + "and (encuesta.fe_encuesta >= cast(coalesce(?3, '1970-01-01 00:00:00') as timestamp)) "
        + "and (encuesta.fe_encuesta <= cast(coalesce(?4, '1970-01-01 00:00:00') as timestamp)) "
        + "order by encuesta.fe_encuesta, id_encuesta, encuesta_detalle.nu_orden"
        //+ "and (?4 is null or encuesta.fe_encuesta <= ?4)"
        , nativeQuery = true)
    public List<Object[]> reporteEncuestaRespuesta (Integer idEncuesta, String coTipoPregunta, Date desde, Date hasta);
}
