/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuestas.data.model.Persona;
import com.encuestas.data.model.PlantillaEncuestaPregunta;


public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    
	
	List<Persona> findByNuDocumentoAndTipoDocumentoCoTipoDocumento(String nuDocumento, String coTipoDocumento);

}
