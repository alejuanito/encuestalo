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

/**
 *
 * @author e00309
 */
public class RespuestaEncuestaConverter implements DataConverter<RespuestaEncuesta, RespuestaEncuestaBean> {

	@Override
	public List<RespuestaEncuestaBean> convertList(List<RespuestaEncuesta> dataList) {
		List<RespuestaEncuestaBean> data = new ArrayList<>();
		if (dataList == null) {
			return data;
		}
		for (RespuestaEncuesta encuesta : dataList) {
			data.add(convert(encuesta));
		}
		return data;
	}

	@Override
	public RespuestaEncuestaBean convert(RespuestaEncuesta encuesta) {
		if (encuesta == null) {
			return null;
		}
		RespuestaEncuestaBean respuestaEncuestaBean = new RespuestaEncuestaBean();
		respuestaEncuestaBean.setEncuesta(new EncuestaConverter().convert(encuesta.getEncuesta()));
		respuestaEncuestaBean.setIdEncuestaRespuesta(encuesta.getIdEncuestaRespuesta());
		respuestaEncuestaBean.setPlantillaEncuestaPregunta(new PlantillaEncuestaPreguntaConverter().convert(encuesta.getPlantillaEncuestaPregunta()));
		respuestaEncuestaBean.setIdRespuesta(encuesta.getIdRespuesta());
		respuestaEncuestaBean.setDeRespuesta(encuesta.getDeRespuesta());
		return respuestaEncuestaBean;
	}

}
