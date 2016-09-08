/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuestas.data.model.Local;


public interface LocalRepository extends JpaRepository<Local, Integer>{
    
	public List<Local> findByEmpresaIdEmpresaOrderByNoLocalAsc (Integer idEmpresa);
}
