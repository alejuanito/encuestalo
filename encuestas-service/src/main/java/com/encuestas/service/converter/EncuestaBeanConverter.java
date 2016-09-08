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
public class EncuestaBeanConverter implements DataConverter<EncuestaBean, Encuesta> {

	@Override
	public List<Encuesta> convertList(List<EncuestaBean> dataList) {
		List<Encuesta> data = new ArrayList<>();
		if (dataList == null) {
			return data;
		}
		for (EncuestaBean encuesta : dataList) {
			data.add(convert(encuesta));
		}
		return data;
	}

	@Override
	public Encuesta convert(EncuestaBean encuesta) {
		if (encuesta == null) {
			return null;
		}
		Encuesta encuestaBean = new Encuesta();
		encuestaBean.setAtencion(new AtencionBeanConverter().convert(encuesta.getAtencion()));
		encuestaBean.setIdEncuesta(encuesta.getIdEncuesta());
		encuestaBean.setFeEncuesta(encuesta.getFeEncuesta());
                encuestaBean.setCliente(new ClienteBeanConverter().convert(encuesta.getCliente()));
                encuestaBean.setLocal(new LocalBeanConverter().convert(encuesta.getLocal()));
                encuestaBean.setNuEncuesta(encuesta.getNuEncuesta());
                encuestaBean.setNuCorrelativo(encuesta.getNuCorrelativo());
		return encuestaBean;
	}

}
