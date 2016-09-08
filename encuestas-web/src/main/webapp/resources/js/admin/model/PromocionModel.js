define(['backbone', 'validate', 'underscore','moment'], function (Backbone, validate, _, moment) {
    return Backbone.Model.extend({
        idAttribute: 'idPromocion',
        urlRoot: rootUrl+'/api/promocion',
        defaults: {
            motivoPromocion: {},
            tipoPromocion: {},
            local: {},
            coPromocion: '',
            deTitulo: '',
            deDescripcion: '',
            feInicio: '',
            feFin: '',
            noImagen: '',
            hrEnvio: '',
            
        },
        
        validate: function (attributes, options) {
			var reglas, errors;
			errors = [];
			errorsEspecial = [];
			reglas = {
                                deTitulo:{
                                        presence: { message: 'Este dato es obligatorio.' },
                                        length: {
                                                maximum: 100,
                                                message: 'El título no debe ser mayor a 100 caracteres'
                                        }						
                                },
                                coPromocion:{
                                        presence: { message: 'Este dato es obligatorio.' },
                                        length: {
                                                maximum: 10,
                                                message: 'El código no deben ser mayor a 50 caracteres'
                                        }						
                                },
                                deDescripcion:{
                                        presence: { message: 'Este dato es obligatorio, ingrese una descripci+on.' },
                                        length: {
                                                maximum: 300,
                                                message: 'La descripción no debe ser mayor a 300 caracteres'
                                        }						
                                }
			};
			errors = validate(attributes, reglas, {fullMessages: false, format: 'detailed'});
			
                        if (moment(attributes.feInicio).isAfter(attributes.feFin) || moment(attributes.feInicio).isBefore(moment(new Date()).format('YYYY/MM/DD'))) {
                            errorsEspecial.push({attribute: 'feInicio', error: 'Fecha fuera de rango'});       
                            errorsEspecial.push({attribute: 'feFin', error: 'Fecha fuera de rango'});       

			}
                        if(attributes.noImagen === null){
                            errorsEspecial.push({attribute: 'image', error: 'Seleccione imagen'});   
                        }else if (attributes.noImagen.length === 0){
                            errorsEspecial.push({attribute: 'image', error: 'Seleccione imagen'});   
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