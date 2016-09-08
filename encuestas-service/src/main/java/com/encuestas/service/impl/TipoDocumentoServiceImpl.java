/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encuestas.data.bean.TipoDocumentoBean;
import com.encuestas.data.repository.TipoDocumentoRepository;
import com.encuestas.service.TipoDocumentoService;
import com.encuestas.service.converter.TipoDocumentoConverter;


@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService{
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

	@Override
	public List<TipoDocumentoBean> listAll() {
		// TODO Auto-generated method stub
		return new TipoDocumentoConverter().convertList(tipoDocumentoRepository.findAll());
	}



	
    
}
