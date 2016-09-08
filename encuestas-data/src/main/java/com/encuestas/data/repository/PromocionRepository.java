/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuestas.data.model.Promocion;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


public interface PromocionRepository extends JpaRepository<Promocion, Integer>{
    	
    
    @Query("select pro "
            + "from Promocion pro "
            + "left join pro.local lo "
            + "left join lo.empresa em "
            + "where pro.feInicio  <= ?1 and pro.feFin  >=?1 ")
    public List<Promocion> findPromocionesActivas (Date feActual);
    
    public List<Promocion> findByLocalEmpresaIdEmpresa (Integer idEmpresa);
}
