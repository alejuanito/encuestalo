package com.encuestas.service.converter;

import com.encuestas.data.bean.PersonaBean;
import com.encuestas.data.model.Persona;

public class PersonaBeanToModelConverter extends AbstractDataConverter<PersonaBean, Persona> {

    @Override
    public Persona convert(PersonaBean personaBean) {
        if (personaBean == null) {
            return null;
        }
        Persona persona = new Persona();

        persona.setAmPersona(personaBean.getAmPersona());
        persona.setApPersona(personaBean.getApPersona());
        persona.setCoSexo(personaBean.getCoSexo());
        persona.setDeEmail(personaBean.getDeEmail());
        persona.setEsPersona(personaBean.getEsPersona());
        persona.setFeNacimiento(personaBean.getFeNacimiento());
        persona.setIdPersona(personaBean.getIdPersona());
        persona.setNoPersona(personaBean.getNoPersona());
        persona.setNoTelefonoCelular(personaBean.getNoTelefonoCelular());
        persona.setNuDocumento(personaBean.getNuDocumento());
        persona.setNuTelefonoFijo(personaBean.getNuTelefonoFijo());
        persona.setTipoDocumento(new TipoDocumentoBeanConverter().convert(personaBean.getTipoDocumento()));
        
        return persona;
    }

}
