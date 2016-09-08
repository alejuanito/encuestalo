/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import com.encuestas.data.model.PromocionEnviada;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;


/**
 *
 * @author Alejandro
 */
public interface PromocionEnviadaRepository extends JpaRepository<PromocionEnviada, Integer>{
    
    public List<PromocionEnviada> findByPromocionIdPromocion (Integer idPromocion);
    
    @Query("select p from PromocionEnviada p "
            + " inner join p.promocion pr "
            + "where pr.idPromocion = :idPromocion "
            + "and ( p.feEnvio BETWEEN  :feInicio and :feFin ) "
            + "and (:nuDocumento is null or p.cliente.persona.nuDocumento = :nuDocumento) ")
    Page<PromocionEnviada> findByPromocionEnviadaFiltros (@Param("idPromocion") Integer idPromocion,
                                                          @Param("feInicio") Date feInicio,
                                                          @Param("feFin") Date feFin,
                                                          @Param("nuDocumento") String nuDocumento,
                                                          Pageable pageable);
}
