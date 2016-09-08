define(['marionette', 'moment',
        'tpl!templates/html/configuracion-atencion-form.tpl',
        'collection/AtencionCollection',
        'model/AtencionModel'], function (Marionette, moment,
        		ConfiguraciontencionFormTemplate,
        		AtencionCollection,
        		AtencionModel
        		) {
	var atenciones = new AtencionCollection();
	var atencionModel = new AtencionModel();
	return Marionette.LayoutView.extend({
		className: 'container-fluid',
		initialize: function (options) {
			var options = options || {}, me=this;
			
			if (typeof options.areaCollection != 'undefined') {
				this.areaCollection = options.areaCollection;
			}
			if (typeof options.colaboradorCollection != 'undefined') {
				this.colaboradorCollection = options.colaboradorCollection;
			}
                        if (typeof options.nuCorrelativoEncuesta != 'undefined') {
                            this.nuCorrelativoEncuesta = options.nuCorrelativoEncuesta;
                            localStorage.setItem("nuCorrelativoEncuesta",options.nuCorrelativoEncuesta);
                        }
                        
		},
		
		template: ConfiguraciontencionFormTemplate,
		
                onRender:function(){
			$("select:first").focus();
			moment.locale('es');
                        moment().format('LLLL');
			console.log(moment(new Date()).format("DD/MM/YYYY HH:mm"));
		    
		},
                
		serializeData: function () {
			
			return _.extend({ 'areaCollection': this.areaCollection,'colaboradorCollection': this.colaboradorCollection, 
                            'moment': moment,'nuCorrelativoEncuesta':this.nuCorrelativoEncuesta});
			
		},
		events: {
			'click #verMesa': 'comenzarEncuesta',
			'click .inicio': 'configurarEncuesta',
			'click #continuar': 'mostrarPreguntas'
		},
		modelEvents: {
			'invalid': 'onInvalidModel',
			 'change': 'render'
		},
		configurarEncuesta:function(evt){
			evt.preventDefault();
			this.$('#config-encuesta-form').removeClass('hidden');
			this.$('#atencion-form').addClass('hidden');
		},
		
		mostrarPreguntas:function(evt){
			evt.preventDefault();
			var me=this;
			
			if(!_.isUndefined(atenciones.at(0))){
                            
				atenciones.at(0).save(obj, {
					success: function () {
						
						localStorage.setItem("idAtencion", atenciones.at(0).toJSON().idAtencion)
                                                //userData['idAtencion']=atenciones.at(0).toJSON().idAtencion;
                                                console.log("IdAtencion: ", userData.idAtencion);
                                               
						me.trigger('go:showpreguntaencuesta');
					},
					error:function(){
						console.log("no se pudo graba");
					}
				});
			}


			
			
			
		},

		comenzarEncuesta: function (evt) {
			evt.preventDefault();
			
			var me=this;
			atencionModel.clear();
			atenciones.reset();
			obj ={
					nuMesa :  me.$('#nuMesa').val(),
					colaborador:{
						idColaborador :me.$('#idColaborador-config').val(),
						persona:{					
							idPersona: me.$('#idColaborador-config').val(),
							noCompleto: me.$('#idColaborador-config option:selected').text(),
							amPersona:'',
							noPersona:me.$('#idColaborador-config option:selected').text(),
							apPersona:''
							}
					},
					area:{
						idArea:me.$('#idArea-config').val(),
                                                deArea:me.$('#idArea-config option:selected').text()
					}
			}
			var errores = atencionModel.validate(obj);
			if (_.isEmpty(errores)) {
				
				atencionModel.set(obj);
				atenciones.add(atencionModel);
				
				this.mostrarPreguntas(evt);
//				me.render();
//				me.$('#config-encuesta-form').addClass('hidden');
//				me.$('#atencion-form').removeClass('hidden');
				
				//me.trigger('go:showatencionencuesta');
			}else{
				this.onInvalidModel(null, errores);
			}
			//
			
		},

		onInvalidModel: function (model, errors) {
			var me = this;
//			this.$('.form-group').removeClass('has-warning');
//			this.$('.help-block').remove();
			_.each(errors, function (val) {
				me.$('#'+val.attribute).parent().parent().addClass('has-warning');
        		me.$('#'+val.attribute).parent().find('.help-block').text(val.error);
//				var parentEl = this.$('#'+val.attribute).parent();
//				parentEl.addClass('has-warning');
//				parentEl.append($('<div>').addClass('help-block').text(val.error));
			});
		},

	});
	
});