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
public class PersonaConverter implements DataConverter<Persona, PersonaBean> {

    @Override
    public List<PersonaBean> convertList(List<Persona> dataList) {
        List<PersonaBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (Persona persona : dataList) {
            data.add(convert(persona));
        }
        return data;
    }

    @Override
    public PersonaBean convert(Persona persona) {
        if (persona == null) {
            return null;
        }
        PersonaBean personaBean = new PersonaBean();
        personaBean.setAmPersona(persona.getAmPersona());
        personaBean.setApPersona(persona.getApPersona());
        personaBean.setCoSexo(persona.getCoSexo());
        personaBean.setDeEmail(persona.getDeEmail());
        if(persona.getFeNacimiento()!=null){
            personaBean.setFeNacimientoString(persona.getFeNacimiento().toString());
        }
        
        personaBean.setEsPersona(persona.getEsPersona());
        personaBean.setFeNacimiento(persona.getFeNacimiento());
        personaBean.setIdPersona(persona.getIdPersona());
        personaBean.setNoPersona(persona.getNoPersona());
        personaBean.setNoTelefonoCelular(persona.getNoTelefonoCelular());
        personaBean.setNuDocumento(persona.getNuDocumento());
        personaBean.setNuTelefonoFijo(persona.getNuTelefonoFijo());
        personaBean.setTipoDocumento(new TipoDocumentoConverter().convert(persona.getTipoDocumento()));
        
        
   
        return personaBean;
    }
    
}
