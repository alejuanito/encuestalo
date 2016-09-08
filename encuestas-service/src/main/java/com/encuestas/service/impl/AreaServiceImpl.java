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

import com.encuestas.data.bean.AreaBean;
import com.encuestas.data.model.Area;
import com.encuestas.data.model.Colaborador;
import com.encuestas.data.model.Usuario;
import com.encuestas.data.repository.AreaRepository;
import com.encuestas.data.repository.ColaboradorRepository;
import com.encuestas.data.repository.UsuarioRepository;
import com.encuestas.service.AreaService;
import com.encuestas.service.converter.AreaConverter;


@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ColaboradorRepository colaboradorRepository;


	@Override
	public List<AreaBean> listAreaLocal(String username) {
		List<Area> areaList = new ArrayList<Area>() ;
		//Usuario usuario = usuarioRepository.findByUsername(username);
		List<Colaborador> colaboradorList = colaboradorRepository.findByUsuarioUsernameOrderByPersonaNoPersonaAsc(username);
		
		if(!colaboradorList.isEmpty()){
			areaList = areaRepository.findByLocalIdLocal(colaboradorList.get(0).getLocal().getIdLocal());
		}
		return new AreaConverter().convertList(areaList);
	}
    
}
