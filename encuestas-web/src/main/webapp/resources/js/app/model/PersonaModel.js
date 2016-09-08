define(['underscore', 'backbone', 'validate','moment'], function (_, Backbone, validate, moment) {
	return Backbone.Model.extend({
		idAttribute: 'idPersona',
		defaults: {
			idPersona:null,
			amPersona:'',
			noPersona:'',
			apPersona:'',
			feNacimiento:'',
			nuTelefonoFijo:'',
			noTelefonoCelular:'',
			deEmail:'',
			nuDocumento:'',
			tipoDocumento:{
				coTipoDocumento:''
			},
			coSexo:'',
                        noCompleto:''
		},
		
		validate: function (attributes, options) {
			console.log("attributes", attributes);
			var reglas, errors;
			errors = [];
			errorsEspecial = [];
			reglas = {
					amPersona:{
						presence: { message: 'Este dato es obligatorio.' },
						length: {
							maximum: 50,
							message: 'El apellido no debe ser mayor a 50 caracteres'
						}						
					},
					noPersona:{
						presence: { message: 'Este dato es obligatorio.' },
						length: {
							maximum: 50,
							message: 'Los nombres no deben ser mayor a 50 caracteres'
						}						
					},
					apPersona:{
						presence: { message: 'Este dato es obligatorio.' },
						length: {
							maximum: 50,
							message: 'El apellido no debe ser mayor a 50 caracteres'
						}						
					},
					
					
					nuTelefonoFijo:{						
						length: {
							maximum: 10,
							message: 'El número de teléfono no debe ser mayor a 10 caracteres'
						},
						format: {
						      pattern: "^[0-9]+$",
						      //flags: "i",
						      message: "Solo se aceptan números"
						 },
					},
					noTelefonoCelular:{						
						length: {
							maximum: 10,
							message: 'El número de telefono no debe ser mayor a 10 caracteres'
						},
						format: {
						      pattern: "^[0-9]+$",
						      message: "Solo se aceptan números"
						 },
					},
					deEmail:{						
						
						    email: {
						      message: "Email invalido"
						    }
									
					},
					nuDocumento:{		
						presence: { message: 'Este dato es obligatorio.' },
						length: {
							maximum: 15,
							message: 'El número de documento no debe ser mayor a 15 caracteres'
						},
						format: {
						      pattern: "^[0-9]+$",
						      //flags: "i",
						      message: "Solo se aceptan números"
						 },
					},
					tipoDocumento:{
						presence: { message: 'Este dato es obligatorio.' }
					},
					coSexo:{
						presence: { message: 'Este dato es obligatorio.' }
					}
			};
			errors = validate(attributes, reglas, {fullMessages: false, format: 'detailed'});
			
                        if (moment(attributes.feNacimiento).isAfter(new Date()) || moment(attributes.feNacimiento).isBefore(new Date('01-01-1916'))) {
                            errorsEspecial.push({attribute: 'feNacimiento', error: 'Fecha fuera de rango'});        
                            console.log("Fecha incorrecta")
			}

                        errors = _.union(errors, errorsEspecial);
                        
			if (!_.isEmpty(errors)) {
				console.log("errores:",errors);
				return errors;
			}else{
				console.log("sin error");
			}
		}
	});
});


