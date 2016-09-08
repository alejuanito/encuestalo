/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.bean.EncuestaBean;
import com.encuestas.data.model.Encuesta;

/**
 *
 * @author e00309
 */
public class EncuestaConverter implements DataConverter<Encuesta, EncuestaBean> {

	@Override
	public List<EncuestaBean> convertList(List<Encuesta> dataList) {
		List<EncuestaBean> data = new ArrayList<>();
		if (dataList == null) {
			return data;
		}
		for (Encuesta encuesta : dataList) {
			data.add(convert(encuesta));
		}
		return data;
	}

	@Override
	public EncuestaBean convert(Encuesta encuesta) {
		if (encuesta == null) {
			return null;
		}
		EncuestaBean encuestaBean = new EncuestaBean();
		encuestaBean.setAtencion(new AtencionConverter().convert(encuesta.getAtencion()));
		encuestaBean.setIdEncuesta(encuesta.getIdEncuesta());
		encuestaBean.setFeEncuesta(encuesta.getFeEncuesta());
                encuestaBean.setCliente(new ClienteConverter().convert(encuesta.getCliente()));
                encuestaBean.setLocal(new LocalConverter().convert(encuesta.getLocal()));
                encuestaBean.setNuEncuesta(encuesta.getNuEncuesta());
                encuestaBean.setNuCorrelativo(encuesta.getNuCorrelativo());
		return encuestaBean;
	}

}
