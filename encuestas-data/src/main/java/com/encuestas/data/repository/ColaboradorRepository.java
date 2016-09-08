/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuestas.data.model.Colaborador;


public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{

  List<Colaborador> findByLocalIdLocal(Integer idLocal);
  
  List<Colaborador> findByLocalIdLocalAndUsuarioInAdmin(Integer idLocal, Boolean inAdmin);
  
  List<Colaborador> findByLocalIdLocalAndCargoColaboradorCoCargoColaboradorOrderByPersonaNoPersonaAsc (Integer idLocal, String coCargoColaborador);
	
	List<Colaborador> findByUsuarioUsernameOrderByPersonaNoPersonaAsc(String username);
	
	
}
