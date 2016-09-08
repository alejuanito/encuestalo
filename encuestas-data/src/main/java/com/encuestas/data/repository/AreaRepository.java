/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import java.util.List;

import com.encuestas.data.model.Area;
import com.encuestas.data.model.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AreaRepository extends JpaRepository<Area, Integer>{
    
	List<Area> findByLocalIdLocal(Integer idLocal);
}
