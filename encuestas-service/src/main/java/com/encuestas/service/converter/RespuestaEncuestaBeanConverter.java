/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.bean.EncuestaBean;
import com.encuestas.data.bean.RespuestaEncuestaBean;
import com.encuestas.data.model.Encuesta;
import com.encuestas.data.model.RespuestaEncuesta;


public class RespuestaEncuestaBeanConverter implements DataConverter<RespuestaEncuestaBean, RespuestaEncuesta> {

	@Override
	public List<RespuestaEncuesta> convertList(List<RespuestaEncuestaBean> dataList) {
		List<RespuestaEncuesta> data = new ArrayList<>();
		if (dataList == null) {
			return data;
		}
		for (RespuestaEncuestaBean encuesta : dataList) {
			data.add(convert(encuesta));
		}
		return data;
	}

	@Override
	public RespuestaEncuesta convert(RespuestaEncuestaBean encuesta) {
		if (encuesta == null) {
			return null;
		}
		RespuestaEncuesta respuestaEncuestaBean = new RespuestaEncuesta();
		respuestaEncuestaBean.setEncuesta(new EncuestaBeanConverter().convert(encuesta.getEncuesta()));
		respuestaEncuestaBean.setIdEncuestaRespuesta(encuesta.getIdEncuestaRespuesta());
		respuestaEncuestaBean.setPlantillaEncuestaPregunta(new PlantillaEncuestaPreguntaBeanConverter().convert(encuesta.getPlantillaEncuestaPregunta()));
		respuestaEncuestaBean.setIdRespuesta(encuesta.getIdRespuesta());
		respuestaEncuestaBean.setDeRespuesta(encuesta.getDeRespuesta()!= null ? encuesta.getDeRespuesta().toUpperCase():encuesta.getDeRespuesta());
		respuestaEncuestaBean.setDePregunta(encuesta.getDePregunta());
                respuestaEncuestaBean.setDeRespuestaCorta(encuesta.getDeRespuestaCorta());
                return respuestaEncuestaBean;
	}

}
