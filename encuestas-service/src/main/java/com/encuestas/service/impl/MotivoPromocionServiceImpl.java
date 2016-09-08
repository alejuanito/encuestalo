/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encuestas.data.bean.MotivoPromocionBean;
import com.encuestas.data.model.MotivoPromocion;
import com.encuestas.data.repository.MotivoPromocionRepository;
import com.encuestas.service.MotivoPromocionService;
import com.encuestas.service.converter.MotivoPromocionModelToBeanConverter;


@Service
public class MotivoPromocionServiceImpl implements MotivoPromocionService{

    @Autowired
    private MotivoPromocionRepository motivoPromocionRepository;

	@Override
	public List<MotivoPromocionBean> listAll() {
		// TODO Auto-generated method stub
			List<MotivoPromocion> colaboradorList = motivoPromocionRepository.findAll();
		
		return new MotivoPromocionModelToBeanConverter().convertList(colaboradorList);
	}
    
}
