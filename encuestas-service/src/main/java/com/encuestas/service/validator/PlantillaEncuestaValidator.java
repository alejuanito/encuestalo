package com.encuestas.service.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.encuestas.data.bean.PlantillaEncuestaBean;

public class PlantillaEncuestaValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PlantillaEncuestaBean.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "deEncuestaCorto", "campo.requerido", new String[]{"descripción corta"});
        ValidationUtils.rejectIfEmpty(errors, "deEncuestaLargo", "campo.requerido", new String[]{"descripción larga"});
    }

}
