/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import java.util.List;

import org.aspectj.runtime.internal.PerObjectMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encuestas.data.bean.PersonaBean;
import com.encuestas.data.model.Persona;
import com.encuestas.data.repository.PersonaRepository;
import com.encuestas.service.PersonaService;
import com.encuestas.service.converter.PersonaBeanConverter;
import com.encuestas.service.converter.PersonaConverter;
import com.encuestas.util.Constantes;


@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;


    @Transactional
	@Override
	public PersonaBean createPersona(PersonaBean personaBean) {
		// TODO Auto-generated method stub
		List<Persona> listPerson = findPersona(personaBean.getNuDocumento(),
				personaBean.getTipoDocumento().getCoTipoDocumento());
		Persona persona = new Persona();
		if(listPerson.isEmpty()){
			persona = new PersonaBeanConverter().convert(personaBean);
			persona.setEsPersona(Constantes.ESTADO_ACTIVO);
			personaRepository.save(persona);	
			personaRepository.flush();
		}else{
			persona = listPerson.get(0);
			
		}
		return new PersonaConverter().convert(persona);
		
	}



	@Override
	@Transactional
	public List<Persona> findPersona(String nuDocumento, String coTipoDocumento) {
		// TODO Auto-generated method stub
		return personaRepository.findByNuDocumentoAndTipoDocumentoCoTipoDocumento(nuDocumento,
				coTipoDocumento);
	}
    
}
