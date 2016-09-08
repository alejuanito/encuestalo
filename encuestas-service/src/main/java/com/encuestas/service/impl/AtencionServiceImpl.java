/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import com.encuestas.data.bean.AreaBean;
import com.encuestas.data.bean.AtencionBean;
import com.encuestas.data.bean.EmpresaBean;
import com.encuestas.data.model.Area;
import com.encuestas.data.model.Atencion;
import com.encuestas.data.model.Empresa;
import com.encuestas.data.repository.AreaRepository;
import com.encuestas.data.repository.AtencionRepository;
import com.encuestas.data.repository.EmpresaRepository;
import com.encuestas.service.AreaService;
import com.encuestas.service.AtencionService;
import com.encuestas.service.EmpresaService;
import com.encuestas.service.converter.AreaConverter;
import com.encuestas.service.converter.AtencionBeanConverter;
import com.encuestas.service.converter.AtencionConverter;
import com.encuestas.service.converter.EmpresaConverter;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AtencionServiceImpl implements AtencionService{
    @Autowired
    private AtencionRepository atencionRepository;

    private final Logger LOGGER = Logger.getLogger(AtencionBeanConverter.class);

	@Override
	@Transactional
	public AtencionBean createAtencion(AtencionBean atencionBean) {
		LOGGER.debug("Atencion: "+ atencionBean.getColaborador());
		LOGGER.debug("Area: "+ atencionBean.getArea());
		LOGGER.debug("Mesa: "+ atencionBean.getNuMesa());
		Atencion atencion = atencionRepository.save(new AtencionBeanConverter().convert(atencionBean));
		return new AtencionConverter().convert(atencion);
	}
        
        @Override
	public AtencionBean getAtencion(Integer idAtencion) {
		
		Atencion atencion = atencionRepository.findOne(idAtencion);
		return new AtencionConverter().convert(atencion);
	}
    
}
