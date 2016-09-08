/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service;

import java.util.List;

import com.encuestas.data.bean.PersonaBean;
import com.encuestas.data.model.Persona;

public interface PersonaService {
    
    public PersonaBean createPersona (PersonaBean persona);
    
    public List<Persona> findPersona (String nuDocumento, String coTipoDocumento);
}
