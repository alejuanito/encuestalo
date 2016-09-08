/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import com.encuestas.data.bean.AreaBean;
import com.encuestas.data.bean.EmpresaBean;
import com.encuestas.data.bean.PersonaBean;
import com.encuestas.data.bean.TipoDocumentoBean;
import com.encuestas.data.model.Area;
import com.encuestas.data.model.Empresa;
import com.encuestas.data.model.Persona;
import com.encuestas.data.model.TipoDocumento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e00309
 */
public class PersonaBeanConverter implements DataConverter<PersonaBean, Persona> {

    @Override
    public List<Persona> convertList(List<PersonaBean> dataList) {
        List<Persona> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (PersonaBean persona : dataList) {
            data.add(convert(persona));
        }
        return data;
    }

    @Override
    public Persona convert(PersonaBean persona) {
        if (persona == null) {
            return null;
        }
        Persona personaBean = new Persona();
        personaBean.setAmPersona(persona.getAmPersona());
        personaBean.setApPersona(persona.getApPersona());
        personaBean.setCoSexo(persona.getCoSexo());
        personaBean.setDeEmail(persona.getDeEmail());
        personaBean.setEsPersona(persona.getEsPersona());
        personaBean.setFeNacimiento(persona.getFeNacimiento());
        personaBean.setIdPersona(persona.getIdPersona());
        personaBean.setNoPersona(persona.getNoPersona());
        personaBean.setNoTelefonoCelular(persona.getNoTelefonoCelular());
        personaBean.setNuDocumento(persona.getNuDocumento());
        personaBean.setNuTelefonoFijo(persona.getNuTelefonoFijo());
        personaBean.setTipoDocumento(new TipoDocumentoBeanConverter().convert(persona.getTipoDocumento()));
        
        
   
        return personaBean;
    }
    
}
