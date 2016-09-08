/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import com.encuestas.data.bean.PlantillaEncuestaPreguntaBean;
import com.encuestas.data.bean.PlantillaEncuestaRespuestaBean;
import com.encuestas.data.model.*;
import com.encuestas.data.repository.*;
import com.encuestas.service.PlantillaEncuestaPreguntaService;
import com.encuestas.service.converter.PlantillaEncuestaBeanConverter;
import com.encuestas.service.converter.PlantillaEncuestaPreguntaBeanConverter;
import com.encuestas.service.converter.PlantillaEncuestaPreguntaConverter;
import com.encuestas.util.Constantes;
import com.encuestas.util.enums.EstadoEnum;
import com.encuestas.util.enums.TipoEncuestaEnum;
import com.encuestas.util.enums.TipoPreguntaEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlantillaEncuestaPreguntaServiceImpl implements PlantillaEncuestaPreguntaService {
    @Autowired
    private PlantillaEncuestaRepository plantillaEncuestaRepository;
    @Autowired
    private PlantillaEncuestaPreguntaRepository plantillaEncuestaPreguntaRepository;
    @Autowired
    private PlantillaEncuestaRespuestaRepository plantillaEncuestaRespuestaRepository;
    private Logger LOGGER = LogManager.getLogger(PlantillaEncuestaPreguntaServiceImpl.class);
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Override
    @Transactional
    public List<PlantillaEncuestaPreguntaBean> listPreguntaAtencion(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        // List<PlantillaEncuestaPregunta> listPreguntas = plantillaEncuestaPreguntaRepository
        // .findByPlantillaEncuestaEmpresaIdEmpresaAndPlantillaEncuestaCoTipoEncuestaAndEstadoOrderByCoTipoPreguntaDescNuOrdenAsc
        // (usuario.getEmpresa().getIdEmpresa(), TipoEncuestaEnum.ATENCION.getCodigo(),
        // Constantes.ESTADO_ACTIVO);
        List<Colaborador> colaboradores = colaboradorRepository.findByUsuarioUsernameOrderByPersonaNoPersonaAsc(username);
        Colaborador colaborador = null;
        if (!colaboradores.isEmpty()) {
            colaborador = colaboradores.get(0);
        } else {
            return new ArrayList<>();
        }
        List<PlantillaEncuesta> plantillas = plantillaEncuestaRepository.findEncuestaPreguntaRespuestaByLocalAndTipoEncuesta(colaborador.getLocal().getIdLocal(), TipoEncuestaEnum.ATENCION.getCodigo(), EstadoEnum.ACTIVO.getCodigo());
        if(!plantillas.isEmpty()){
            PlantillaEncuesta plantillaEncuesta = plantillas.get(0);
        //List<PlantillaEncuestaPregunta> listPreguntas = plantillaEncuestaPreguntaRepository
        //        .findByPlantillaEncuestaLocalIdLocalAndPlantillaEncuestaCoTipoEncuestaAndEstadoOrderByCoTipoPreguntaDescNuOrdenAsc(
        //                colaborador.getLocal().getIdLocal(), TipoEncuestaEnum.ATENCION.getCodigo(),
        //                Constantes.ESTADO_ACTIVO);
            List<PlantillaEncuestaPregunta> listPreguntas = plantillaEncuestaPreguntaRepository.findByPlantillaEncuestaIdPlantillaEncuestaAndEstadoOrderByCoTipoPreguntaDescNuOrdenAsc(plantillaEncuesta.getIdPlantillaEncuesta(), EstadoEnum.ACTIVO.getCodigo());
            return new PlantillaEncuestaPreguntaConverter().convertList(listPreguntas);
        }else{
            return new ArrayList<>();
        }
                
    }

    @Override
    @Transactional
    public List<PlantillaEncuestaPreguntaBean> listPreguntaAtencionByIdPlantillaEncuesta(Integer idPlantillaEncuesta) {
        List<PlantillaEncuestaPregunta> listPreguntas = plantillaEncuestaPreguntaRepository
                .findByPlantillaEncuestaIdPlantillaEncuestaAndPlantillaEncuestaCoTipoEncuesta(idPlantillaEncuesta, TipoEncuestaEnum.ATENCION.getCodigo());
        return new PlantillaEncuestaPreguntaConverter().convertList(listPreguntas);
    }
    
    @Override
    @Transactional
    public List<PlantillaEncuestaPreguntaBean> listPreguntaParaReporte(Integer idLocal) {
        List<PlantillaEncuestaPregunta> listPreguntas = plantillaEncuestaPreguntaRepository.listPreguntasReporte(idLocal, Constantes.ESTADO_ACTIVO);
        return new PlantillaEncuestaPreguntaConverter().convertList(listPreguntas);
    }

    @Override
    @Transactional
    public PlantillaEncuestaPreguntaBean load(Integer idPlantillaEncuestaPregunta) {
        PlantillaEncuestaPregunta plantillaEncuestaPregunta = plantillaEncuestaPreguntaRepository.findOne(idPlantillaEncuestaPregunta);
        return new PlantillaEncuestaPreguntaConverter().convert(plantillaEncuestaPregunta);
    }

    
    
    
    @Override
    public PlantillaEncuestaPreguntaBean crear(PlantillaEncuestaPreguntaBean plantillaEncuestaPreguntaBean) {
        PlantillaEncuestaBeanConverter plantillaEncuestaBeanConverter = new PlantillaEncuestaBeanConverter();
        PlantillaEncuestaPreguntaBeanConverter plantillaEncuestaPreguntaBeanConverter = new PlantillaEncuestaPreguntaBeanConverter();
        if (plantillaEncuestaPreguntaBean.getInEsRptaCorta()) {
            plantillaEncuestaPreguntaBean.setCoTipoPregunta(TipoPreguntaEnum.CERRADA.getCodigo());
        } else {
            plantillaEncuestaPreguntaBean.setCoTipoPregunta(TipoPreguntaEnum.ABIERTA.getCodigo());
        }

        PlantillaEncuestaPregunta plantillaEncuestaPregunta = plantillaEncuestaPreguntaBeanConverter.convert(plantillaEncuestaPreguntaBean);
        plantillaEncuestaPregunta.setPlantillaEncuesta(plantillaEncuestaBeanConverter.convert(plantillaEncuestaPreguntaBean.getPlantillaEncuesta()));
        plantillaEncuestaPregunta.setEstado(EstadoEnum.ACTIVO.getCodigo());
        plantillaEncuestaPreguntaRepository.save(plantillaEncuestaPregunta);

        Map<String, PlantillaEncuestaRespuesta> opciones = new HashMap<>();

        for (PlantillaEncuestaRespuestaBean rpta : plantillaEncuestaPreguntaBean.getPlantillaEncuestaRespuestas()) {
            PlantillaEncuestaRespuesta rpta2 = opciones.get(rpta.getNoImg());
            if (rpta2 != null) {
                opciones.get(rpta.getNoImg()).setEsPlantillaEncuestaRespuesta("A");
            } else {
                rpta2 = new PlantillaEncuestaRespuesta();
                rpta2.setNoImg(rpta.getNoImg());
                rpta2.setDeRespuesta(rpta.getDeRespuesta());
                rpta2.setNuOrden(rpta.getNuOrden());
                rpta2.setEsPlantillaEncuestaRespuesta("A");
                rpta2.setPlantillaEncuestaPregunta(plantillaEncuestaPregunta);
                opciones.put(rpta.getNoImg(), rpta2);
            }
        }

        plantillaEncuestaRespuestaRepository.save(opciones.values());
        plantillaEncuestaPregunta.setPlantillaEncuestaRespuestas(new ArrayList<>(opciones.values()));

        return new PlantillaEncuestaPreguntaConverter().convert(plantillaEncuestaPregunta);
    }

    @Override
    public PlantillaEncuestaPreguntaBean actualizar(PlantillaEncuestaPreguntaBean plantillaEncuestaPreguntaBean) {
        PlantillaEncuestaBeanConverter plantillaEncuestaBeanConverter = new PlantillaEncuestaBeanConverter();
        PlantillaEncuestaPreguntaBeanConverter plantillaEncuestaPreguntaBeanConverter = new PlantillaEncuestaPreguntaBeanConverter();
        if (plantillaEncuestaPreguntaBean.getInEsRptaCorta()) {
            plantillaEncuestaPreguntaBean.setCoTipoPregunta(TipoPreguntaEnum.CERRADA.getCodigo());
        } else {
            plantillaEncuestaPreguntaBean.setCoTipoPregunta(TipoPreguntaEnum.ABIERTA.getCodigo());
        }
        PlantillaEncuestaPregunta plantillaEncuestaPregunta = plantillaEncuestaPreguntaBeanConverter.convert(plantillaEncuestaPreguntaBean);
        plantillaEncuestaPregunta.setPlantillaEncuesta(plantillaEncuestaBeanConverter.convert(plantillaEncuestaPreguntaBean.getPlantillaEncuesta()));
        plantillaEncuestaPreguntaRepository.save(plantillaEncuestaPregunta);

        Map<String, PlantillaEncuestaRespuesta> opciones = new HashMap<>();

        for (PlantillaEncuestaRespuesta rpta : plantillaEncuestaRespuestaRepository.findByPlantillaEncuestaPreguntaIdPlantillaEncuestaDetalleOrderByNuOrdenAsc(plantillaEncuestaPregunta.getIdPlantillaEncuestaDetalle())) {
            rpta.setEsPlantillaEncuestaRespuesta("I");
            opciones.put(rpta.getNoImg(), rpta);
        }

        for (PlantillaEncuestaRespuestaBean rpta : plantillaEncuestaPreguntaBean.getPlantillaEncuestaRespuestas()) {
            PlantillaEncuestaRespuesta rpta2 = opciones.get(rpta.getNoImg());
            if (rpta2 != null) {
                opciones.get(rpta.getNoImg()).setEsPlantillaEncuestaRespuesta("A");
            } else {
                rpta2 = new PlantillaEncuestaRespuesta();
                rpta2.setNoImg(rpta.getNoImg());
                rpta2.setDeRespuesta(rpta.getDeRespuesta());
                rpta2.setNuOrden(rpta.getNuOrden());
                rpta2.setEsPlantillaEncuestaRespuesta("A");
                rpta2.setPlantillaEncuestaPregunta(plantillaEncuestaPregunta);
                opciones.put(rpta.getNoImg(), rpta2);
            }
        }

        plantillaEncuestaRespuestaRepository.save(opciones.values());
        plantillaEncuestaPregunta.setPlantillaEncuestaRespuestas(new ArrayList<>(opciones.values()));
        return new PlantillaEncuestaPreguntaConverter().convert(plantillaEncuestaPregunta);
    }

    @Override
    @Transactional
    public void eliminar(Integer idPlantillaEncuestaPregunta) {
        PlantillaEncuestaPregunta plantillaEncuestaPregunta = plantillaEncuestaPreguntaRepository.findOne(idPlantillaEncuestaPregunta);
        LOGGER.info("Eliminando " + idPlantillaEncuestaPregunta);
        if (plantillaEncuestaPregunta != null) {
//			if (plantillaEncuestaPregunta.getPlantillaEncuestaRespuestas() == null ||
//					plantillaEncuestaPregunta.getPlantillaEncuestaRespuestas().isEmpty()) {
//				plantillaEncuestaPreguntaRepository.delete(idPlantillaEncuestaPregunta);
//			} else {
            plantillaEncuestaPregunta.setEstado(EstadoEnum.INACTIVO.getCodigo());
            plantillaEncuestaPreguntaRepository.save(plantillaEncuestaPregunta);
//			}
        }
    }

}
