define(['admin-app',
        'collection/AtencionCollection','collection/AreaCollection','collection/ColaboradorCollection',
        'collection/PreguntaCollection','collection/RespuestaCollection','collection/TipoDocumentoCollection',
        'model/AtencionModel', 'model/AreaModel','model/ColaboradorModel',
        'model/PreguntaModel','model/RespuestaModel','model/TipoDocumentoModel',
        'view/ConfiguracionAtencionFormView', 'view/PreguntaEncuestaFormView', 'view/ClienteFormView',
        'view/WelcomeView'],
        function (app,
        		AtencionCollection,AreaCollection,ColaboradorCollection,PreguntaCollection,RespuestaCollection,TipoDocumentoCollection,
        		AtencionModel,AreaModel,ColaboradorModel,PreguntaModel,RespuestaModel,TipoDocumentoModel,
        		ConfiguracionAtencionFormView, PreguntaEncuestaFormView, ClienteFormView, WelcomeView
        		) {
	
	var atencionCollection = new AtencionCollection;	
	var areaCollection = new AreaCollection;
	
	return {		
		
		showConfiguracionAtencion: function () {
			var me=this,view ;

			areaCollection.fetch({
				success: function () {
					var colaboradorCollection = new ColaboradorCollection;
					colaboradorCollection.fetch({
						success: function () {
							var url, data;
							url = rootUrl+'/api/encuestas/correlativo';
							$.get(url, data).success(function (response, opts) {
								console.log("correlativo", response);
								view = new ConfiguracionAtencionFormView({
									areaCollection: areaCollection,
									colaboradorCollection:colaboradorCollection,
									nuCorrelativoEncuesta:response
								});
								app.main.show(view);
								view.on('go:showpreguntaencuesta', function () {
									me.showPreguntaEncuesta();
									Backbone.history.navigate('#pregunta-encuesta');
								});	
							});					
						}
					});					
				}
			});

		},

		showPreguntaEncuesta: function () {
			
			var me=this;	
			var atencionModel = new AtencionModel();
                        //console.log("IdAtencion Controller: ", userData);
                        atencionModel.set({'idAtencion': localStorage.getItem("idAtencion")});
			var preguntaCollection = new PreguntaCollection;
			var respuestaCollection ;
                        atencionModel.fetch({
                            success: function () {
                                preguntaCollection.fetch({				
				success: function () {
					if(preguntaCollection.length>0){
						var url, data;
						url = rootUrl+'/api/respuestas';						
						data = {idPregunta:preguntaCollection.at(0).toJSON().idPlantillaEncuestaDetalle};
						$.get(url, data).success(function (response, opts) {
							respuestaCollection = new RespuestaCollection(response);
							var view = new PreguntaEncuestaFormView({
								preguntacollection: preguntaCollection,
								respuestaCollection: respuestaCollection,
                                                                atencionModel : atencionModel
							});					
							view.on('go:showdatosencuestado', function () {
								me.showDatosEncuestado();
								Backbone.history.navigate('#datos-encuestado');
							});
							view.on('go:showconfiguracionatencion', function () {
								me.showConfiguracionAtencion();
								Backbone.history.navigate('#configuracion-atencion');
							});
							app.main.show(view);
							
						});
					}else{
						alert("No se encontraron preguntas")
					}
					
				}
			
			});
                            }
                        })
			
			//app.main.show(view);
			
		},
		 showMenu: function () {
				app.main.show(view);
				
		},
		showDatosEncuestado: function () {
			var me=this;	
			var tipoDocumentoCollection = new TipoDocumentoCollection;
						tipoDocumentoCollection.fetch({
						success: function () {
							var view = new ClienteFormView({
								tipoDocumentoCollection: tipoDocumentoCollection,
							});					
							view.on('go:showconfiguracionatencion', function () {
								me.showConfiguracionAtencion();
								Backbone.history.navigate('#configuracion-atencion');
							});
							app.main.show(view);
						}
						
		});
			
			
	},
		showWelcome: function () {
			var me = this;
			var view = new WelcomeView();
			app.main.show(view);
			view.on('go:showEncuesta', function () {
				me.showConfiguracionAtencion();
				Backbone.history.navigate('#configuracion-atencion');
			});
		}
	};
});