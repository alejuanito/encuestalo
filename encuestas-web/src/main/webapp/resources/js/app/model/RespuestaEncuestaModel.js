define(['underscore', 'backbone', 'validate'], function (_, Backbone, validate) {
	return Backbone.Model.extend({
		idAttribute: 'idEncuestaRespuesta',
		defaults: {
			idEncuestaRespuesta:null,
			deRespuesta:'',
			encuesta:{
				idEncuesta:'',
				atencion:{
					idAtencion:''
				}
			},
			plantillaEncuestaRespuesta:{
				idRespuesta:''
			},
			
			plantillaEncuestaPregunta:{
				idPlantillaEncuestaDetalle:'',
				coTipoPregunta:''
			},
		},
		validate: function (attributes, options) {
			console.log("attributes", attributes);
			var reglas, errors;
			errors = [];
			errorsEspecial = [];
			reglas = {
					
			};
			errors = validate(attributes, reglas, {fullMessages: false, format: 'detailed'});
			if (attributes.plantillaEncuestaPregunta.coTipoPregunta == 'ABIE') {
//				if(attributes.deRespuesta.length==0){
//					errorsEspecial.push({attribute: 'deRespuesta', error: 'Ingrese respuesta.'});   
//				}
				         
	        }
			errors = _.union(errors, errorsEspecial);
			if (!_.isEmpty(errors)) {
				return errors;
			}
		}
	});
});