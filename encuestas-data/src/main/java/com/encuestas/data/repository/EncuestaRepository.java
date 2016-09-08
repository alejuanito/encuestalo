/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuestas.data.model.Encuesta;
import org.springframework.data.jpa.repository.Query;


public interface EncuestaRepository extends JpaRepository<Encuesta, Integer>{
    
    public List<Encuesta> findByIdEncuestaIn (List<Integer> idEncuesta);
    
    @Query("select coalesce(max(en.nuCorrelativo), '0') "
        + " from Encuesta  en "
        + " left join en.local lo "		
        + " where lo.idLocal = ?1 ") 
    Integer findCorrelativo(Integer idLocal);
    
   
    
}
