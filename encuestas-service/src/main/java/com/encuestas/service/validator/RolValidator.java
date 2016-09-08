package com.encuestas.service.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.encuestas.data.bean.RolBean;

public class RolValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RolBean.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "nombre", "campo.requerido", new String[] {"nombre"});
        ValidationUtils.rejectIfEmpty(errors, "estado", "campo.requerido", new String[] {"estado"});
    }

}
