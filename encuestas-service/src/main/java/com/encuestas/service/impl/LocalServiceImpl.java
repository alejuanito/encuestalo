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
import com.encuestas.data.bean.LocalBean;
import com.encuestas.data.model.Local;
import com.encuestas.data.model.Usuario;
import com.encuestas.data.repository.LocalRepository;
import com.encuestas.data.repository.UsuarioRepository;
import com.encuestas.service.ColaboradorService;
import com.encuestas.service.LocalService;
import com.encuestas.service.converter.LocalConverter;


@Service
public class LocalServiceImpl implements LocalService{
    @Autowired
    private LocalRepository localRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ColaboradorService colaboradorService;



	@Override	
	public List<LocalBean> listLocal(String username) {
		Usuario usuario = usuarioRepository.findByUsername(username);
		List<Local> listLocal = new ArrayList<Local>();
		if(usuario!=null){
			listLocal = localRepository.findByEmpresaIdEmpresaOrderByNoLocalAsc(usuario.getEmpresa().getIdEmpresa());
		}		
	    return new LocalConverter().convertList(listLocal);
	}
	
	@Override	
	public LocalBean getLocal(String username) {
		ColaboradorBean colaborador = colaboradorService.getColaborador(username);
		Local local = localRepository.findOne(colaborador.getLocal().getIdLocal());
			
	    return new LocalConverter().convert(local);
	}

	@Override
	public LocalBean consultaPorId(Integer idLocal) {
		return new LocalConverter().convert(localRepository.findOne(idLocal));
	}
}
