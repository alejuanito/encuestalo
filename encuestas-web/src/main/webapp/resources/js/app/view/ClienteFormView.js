define(['marionette', 'moment',
        'tpl!templates/html/cliente-form.tpl',
        'collection/ClienteCollection',
        'collection/PersonaCollection',
        'model/ClienteModel',
        'model/PersonaModel'], function (Marionette, moment,
        		clienteFormTemplate,
        		ClienteCollection,
        		PersonaCollection,
        		ClienteModel,
        		PersonaModel
        		) {
	
	return Marionette.LayoutView.extend({
		
		initialize: function (options) {

			var options = options || {}, me=this;
			
			if (typeof options.collection != 'undefined') {
				this.collection = options.collection;
			}
			if (typeof options.tipoDocumentoCollection != 'undefined') {
				this.tipoDocumentoCollection = options.tipoDocumentoCollection;
			}
                        //console.log("fecha",moment(new Date()).format("DD/MM/YYYY HH:mm"));
				
		},
		
		template: clienteFormTemplate,
		events: {
			'click #finEncuesta': 'grabarDatos',
			'click #cancelar': 'cancelarEncuesta',
                        'change #feNacimiento': 'obtenerEdad'
		},
		modelEvents: {
			'invalid': 'onInvalidModel'
		},
		serializeData: function () {			
			return _.extend({ 'tipoDocumentoCollection': this.tipoDocumentoCollection, 'moment':moment});			
		},
		onInvalidModel: function (model, errors) {
			var me = this;
			me.$('.form-group').parent().parent().removeClass('has-warning');
    		me.$('.form-group').parent().find('.help-block').text("");
			_.each(errors, function (val) {
				me.$('#'+val.attribute).parent().parent().addClass('has-warning');
        		me.$('#'+val.attribute).parent().find('.help-block').text(val.error);
//				var parentEl = this.$('#'+val.attribute).parent();
//				parentEl.addClass('has-warning');
//				parentEl.append($('<div>').addClass('help-block').text(val.error));
			});
		},
		cancelarEncuesta: function (evt) {
			evt.preventDefault();
			var me=this;
			window.location.reload();
			me.trigger('go:showconfiguracionatencion');
		},
                obtenerEdad: function (evt) {
			evt.preventDefault();
                        console.log("Nacimiento:", this.$('#feNacimiento').val());
                        var edad = this.getDate(new Date(this.$('#feNacimiento').val()));
                        if(edad >= 0 && edad <= 100 && moment(this.$('#feNacimiento').val()).isBefore(new Date())){
                            this.$('#nuEdad').val(edad)
                        }
                        else{this.$('#nuEdad').val(0)}
                        
			//console.log("edad seleccionada", this.getDate(this.$('#feNacimiento').val()));
		},
                
                getDate:function(birthday){
                  console.log("cumpleaños: ", birthday)
                  var ageDifMs = Date.now() - birthday.getTime();
                  var ageDate = new Date(ageDifMs); // miliseconds from epoch
                  console.log("edad: ", Math.abs(ageDate.getUTCFullYear() - 1970))
                  return Math.abs(ageDate.getUTCFullYear() - 1970);
                },
		grabarDatos: function (evt) {
			evt.preventDefault();
			var me=this;
			var clienteModel = new ClienteModel();
			var personaModel = new PersonaModel();
			obj ={
					persona:{
						amPersona:me.$('#amPersona').val(),
						noPersona:me.$('#noPersona').val(),
						apPersona:me.$('#apPersona').val(),
						feNacimiento:me.$('#feNacimiento').val(),
						nuTelefonoFijo:me.$('#nuTelefonoFijo').val(),
						noTelefonoCelular:me.$('#nuTelefonoCelular').val(),
						deEmail:me.$('#deEmail').val(),
						nuDocumento:me.$('#nuDocumento').val(),
						tipoDocumento:{
							coTipoDocumento:me.$('#coTipoDocumento').val(),
						},
						coSexo:me.$('#coSexo').val()
                                                
					},
                                        inPromocion:me.$('#inPromocion').prop('checked'),
                                        idEncuesta:localStorage.getItem("idEncuesta")
										
			}
			//personaModel.set(obj);
			var errors = personaModel.validate(obj.persona);
			console.log("errors:", errors);
			if (_.isEmpty(errors)) {
				clienteModel.set(obj);			
				clienteModel.save(obj, {
					
					success: function () {
						alert("Encuesta "+ ('000' + userData.nuLocal).slice(-3) + '-'+('000000' + localStorage.getItem('nuCorrelativoEncuesta')).slice(-6) + " finalizada corréctamente.");
                                                //localStorage.setItem("nuCorrelativoEncuesta",localStorage.getItem("nuCorrelativoEncuesta")+1);
						me.trigger('go:showconfiguracionatencion');
					}
				});
			}else{
				this.onInvalidModel(null, errors);
			}
			
		},

	});
	
});