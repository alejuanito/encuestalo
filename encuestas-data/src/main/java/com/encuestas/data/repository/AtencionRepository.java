/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import com.encuestas.data.model.Atencion;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AtencionRepository extends JpaRepository<Atencion, Integer>{
    
	
}
