define(['underscore', 'backbone', 'validate'], function (_, Backbone, validate) {
	return Backbone.Model.extend({
		idAttribute: 'idAtencion',
                urlRoot: rootUrl+'/api/atencion',
		defaults: {
			idAtencion:null,
			nuMesa:'',
                        nuPreguntaRespondida:'',
                        nuTotal:'',
			colaborador:{
				idColaborador:'',
				persona:{
					idPersona:'',
					amPersona:'',
					noPersona:'',
					apPersona:'',
					noCompleto:''
				},
				
			},
			area:{
				idArea:'',
				deArea:''
			},
		},
		validate: function (attributes, options) {
			console.log("attributes", attributes);
			var reglas, errors;
			errors = [];
			errorsEspecial = [];
			reglas = {
					nuMesa:{
						presence: { message: 'Ingrese número de mesa.' },
						numericality: {
						      onlyInteger: true,
						      greaterThan: 0,
						      lessThanOrEqualTo: 100,
						      message: 'Número de mesa inválido.'
						}
						
					},
					colaborador:{
						presence: { message: 'Seleccione mozo.' },
					},
					area:{
						presence: { message: 'Seleccione zona.' },
					}
			};
			errors = validate(attributes, reglas, {fullMessages: false, format: 'detailed'});
			
			if (!_.isEmpty(errors)) {
				return errors;
			}
		}
	
	});
});