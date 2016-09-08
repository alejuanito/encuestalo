/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encuestas.data.bean.TipoPromocionBean;
import com.encuestas.data.model.TipoPromocion;
import com.encuestas.data.repository.TipoPromocionRepository;
import com.encuestas.service.TipoPromocionService;
import com.encuestas.service.converter.TipoPromocionModelToBeanConverter;


@Service
public class TipoPromocionServiceImpl implements TipoPromocionService{

    @Autowired
    private TipoPromocionRepository tipoPromocionRepository;

	@Override
	public List<TipoPromocionBean> listAll() {
		// TODO Auto-generated method stub
			List<TipoPromocion> colaboradorList = tipoPromocionRepository.findAll();
		
		return new TipoPromocionModelToBeanConverter().convertList(colaboradorList);
	}
    
}
