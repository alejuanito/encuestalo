package com.encuestas.service.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.encuestas.data.bean.UsuarioBean;

public class UsuarioValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UsuarioBean.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "username", "campo.requerido", new String[] {"nombre de usuario"});
        ValidationUtils.rejectIfEmpty(errors, "estado", "campo.requerido", new String[] {"estado"});

        ValidationUtils.rejectIfEmpty(errors, "persona", "campo.requerido", new String[] {"persona"});
        ValidationUtils.rejectIfEmpty(errors, "persona.noPersona", "campo.requerido", new String[] {"nombre de la persona"});
        ValidationUtils.rejectIfEmpty(errors, "persona.apPersona", "campo.requerido", new String[] {"apellido paterno de la persona"});
        ValidationUtils.rejectIfEmpty(errors, "persona.amPersona", "campo.requerido", new String[] {"apellido materno de la persona"});
        
        UsuarioBean usuario = (UsuarioBean) obj;
        if (usuario.getIdUsuario() == null) {

            ValidationUtils.rejectIfEmpty(errors, "password", "campo.requerido", new String[] {"contraseña"});

        }
    }

}
