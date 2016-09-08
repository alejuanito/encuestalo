/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import com.encuestas.data.bean.PlantillaEncuestaPreguntaBean;
import com.encuestas.data.model.PlantillaEncuesta;
import com.encuestas.data.model.PlantillaEncuestaPregunta;
import com.encuestas.data.model.PlantillaEncuestaRespuesta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e00309
 */
public class PlantillaEncuestaPreguntaConverter
		implements DataConverter<PlantillaEncuestaPregunta, PlantillaEncuestaPreguntaBean> {

	@Override
	public List<PlantillaEncuestaPreguntaBean> convertList(List<PlantillaEncuestaPregunta> dataList) {
		List<PlantillaEncuestaPreguntaBean> data = new ArrayList<>();
		if (dataList == null) {
			return data;
		}
		for (PlantillaEncuestaPregunta pregunta : dataList) {
			data.add(convert(pregunta));
		}
		return data;
	}

	@Override
	public PlantillaEncuestaPreguntaBean convert(PlantillaEncuestaPregunta pregunta) {
		if (pregunta == null) {
			return null;
		}
		PlantillaEncuestaRespuestaConverter converter = new PlantillaEncuestaRespuestaConverter();
		PlantillaEncuestaPreguntaBean preguntaBean = new PlantillaEncuestaPreguntaBean();
		preguntaBean.setCoTipoPregunta(pregunta.getCoTipoPregunta());
		preguntaBean.setDePregunta(pregunta.getDePregunta());
		preguntaBean.setEstado(pregunta.getEstado());
		preguntaBean.setFeCreaRegistro(pregunta.getFeCreaRegistro());
		preguntaBean.setFeModRegistro(pregunta.getFeModRegistro());
		preguntaBean.setIdCreaRegistro(pregunta.getIdCreaRegistro());
		preguntaBean.setIdModRegistro(pregunta.getIdModRegistro());
		preguntaBean.setIdPlantillaEncuestaDetalle(pregunta.getIdPlantillaEncuestaDetalle());
		preguntaBean.setNuOrden(pregunta.getNuOrden());
		preguntaBean.setInEsRptaCorta(pregunta.getInEsRptaCorta());
		preguntaBean.setPlantillaEncuesta(new PlantillaEncuestaConverter().convert(pregunta.getPlantillaEncuesta()));
		
		for (PlantillaEncuestaRespuesta rpta : pregunta.getPlantillaEncuestaRespuestas()) {
		    preguntaBean.getPlantillaEncuestaRespuestas().add(converter.convert(rpta));
		}

		return preguntaBean;
	}

}
