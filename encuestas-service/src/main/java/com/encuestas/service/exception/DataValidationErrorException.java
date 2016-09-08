package com.encuestas.service.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class DataValidationErrorException extends Exception {
	private static final Logger LOGGER = Logger.getLogger(DataValidationErrorException.class);
	private static final long serialVersionUID = 1L;

	private static final String ATTRIBUTE_CODE = "attribute";
	private static final String ERROR_CODE = "error";
	
	private final BindingResult bindingResult;
	
	private MessageSource messageSource;

	public DataValidationErrorException (BindingResult bindingResult, MessageSource messageSource) {
		this.bindingResult = bindingResult;
		this.messageSource = messageSource;
	}
	
	public List<Map<String, String>> getErrors () {
		List<Map<String, String>> errors = new ArrayList<>();
		
		for (Object object : bindingResult.getAllErrors()) {
			if (object instanceof FieldError) {
				Map<String, String> errorDetail = new HashMap<>();
				FieldError fieldError = (FieldError) object;
				LOGGER.debug(fieldError.getDefaultMessage());
				String field = fieldError.getField();
				String message = messageSource.getMessage(fieldError, null);
				errorDetail.put(ATTRIBUTE_CODE, field);
				errorDetail.put(ERROR_CODE, message);
				
				errors.add(errorDetail);
			}
		}
		
		return errors;
	}
}
