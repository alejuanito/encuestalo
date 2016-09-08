package com.encuestas.service.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.encuestas.data.bean.PlantillaEncuestaBean;
import com.encuestas.data.bean.PromocionBean;

public class PromocionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PromocionBean.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "deTitulo", "campo.requerido", new String[] {"título"});
		ValidationUtils.rejectIfEmpty(errors, "deDescripcion", "campo.requerido", new String[] {"descripción"});
		
	}

}
