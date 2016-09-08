/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuestas.data.model.ClienteLocal;
import java.util.List;


public interface ClienteLocalRepository extends JpaRepository<ClienteLocal, Integer>{
   
    List<ClienteLocal> findByLocalIdLocalAndClienteIdCliente(Integer idLocal, Integer idCliente);

    List<ClienteLocal> findByClienteIdClienteOrderByFeCreaRegistroDesc (Integer idCliente);
   
}
