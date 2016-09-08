/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encuestas.data.bean.ColaboradorBean;
import com.encuestas.data.model.Colaborador;
import com.encuestas.data.repository.ColaboradorRepository;
import com.encuestas.service.ColaboradorService;
import com.encuestas.service.converter.ColaboradorConverter;
import com.encuestas.util.enums.CargoColaboradorEnum;


@Service
public class ColaboradorServiceImpl implements ColaboradorService{
    @Autowired
    private ColaboradorRepository colaboradorRepository;



	@Override	
	public List<ColaboradorBean> listMozoLocal(String username) {
		List<Colaborador> mozosList = new ArrayList<Colaborador>();
		List<Colaborador> colaboradorList = colaboradorRepository.findByUsuarioUsernameOrderByPersonaNoPersonaAsc(username);
		if(!colaboradorList.isEmpty()){
//			mozosList = colaboradorRepository.findByLocalIdLocalAndUsuarioInAdmin(colaboradorList.get(0).getLocal().getIdLocal(), false);
			mozosList = colaboradorRepository.findByLocalIdLocalAndCargoColaboradorCoCargoColaboradorOrderByPersonaNoPersonaAsc(colaboradorList.get(0).getLocal().getIdLocal(), CargoColaboradorEnum.MOZO.getCodigo());
		}
	    return new ColaboradorConverter().convertList(mozosList);
	}
	
	@Override	
	public ColaboradorBean getColaborador(String username) {
		Colaborador colaborador = new Colaborador();
		List<Colaborador> colaboradorList = colaboradorRepository.findByUsuarioUsernameOrderByPersonaNoPersonaAsc(username);
		if(!colaboradorList.isEmpty()){
			colaborador = colaboradorList.get(0);
		}
	    return new ColaboradorConverter().convert(colaborador);
	}
    
}
