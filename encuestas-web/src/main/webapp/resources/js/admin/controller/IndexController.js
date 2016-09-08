define([ 'model/PlantillaEncuesta','model/PromocionModel','model/LocalModel','model/PromocionEnviadaModel', 
                'collection/PlantillaEncuestaCollection','collection/PromocionEnviadaCollection',
		'collection/PlantillaEncuestaPreguntaCollection','collection/PromocionCollection', 'collection/MotivoPromocionCollection',
		'collection/TipoPromocionCollection','collection/LocalCollection',
		'collection/ReporteRespuestaCollection', 
		'view/EncuestaListView', 'view/EncuestaFormView',
		'view/PromocionListView','view/PromocionFormView',
		'view/IndexView','view/PromocionEnviadaListView','view/BlankView',
		'app', 'backbone',
		'underscore' ], function(PlantillaEncuesta,PromocionModel,LocalModel,LocalEnviadaModel,
		PlantillaEncuestaCollection, PromocionEnviadaCollection,
                PlantillaEncuestaPreguntaCollection,PromocionCollection,MotivoPromocionCollection,
		TipoPromocionCollection,LocalCollection,
		ReporteRespuestaCollection,
		EncuestaListView, EncuestaFormView,
		PromocionListView,PromocionFormView, 
		IndexView, PromocionEnviadaListView,BlankView,
		app, Backbone, _) {
	var plantillaEncuestaCollection = new PlantillaEncuestaCollection([]);
	var plantillaEncuestaPreguntaCollection = new PlantillaEncuestaPreguntaCollection();
	var reporteRespuestaCollection = new ReporteRespuestaCollection([]);
	var localCollection = new LocalCollection([]);
	
	var promocionCollection = new PromocionCollection([]);
        var promocionEnviadaCollection = new PromocionEnviadaCollection([]);
	return {
        index : function() {
        	var view = new BlankView();
        	app.rootView.showChildView('main', view);
        },
        showEncuestaList : function() {
                var view, me;
                me = this;
                view = new EncuestaListView({
                        collection : plantillaEncuestaCollection
                });
                view.on('goto:nuevaEncuesta', function() {
                        me.showEncuestaFormNew();
                        Backbone.history.navigate('encuestas/new')
                });
                view.on('goto:editarEncuesta', function(id) {
                        me.showEncuestaFormEdit(id);
                        Backbone.history.navigate('encuestas/edit/' + id)
                });
                plantillaEncuestaCollection.fetch({
                        success : function() {
                                app.rootView.showChildView('main', view);
                        }
                });
        },
        showEncuestaFormNew : function() {
            var view, me, plantillaEncuesta;
            me = this;
            plantillaEncuesta = new PlantillaEncuesta;
            plantillaEncuestaCollection.add(plantillaEncuesta);
            plantillaEncuestaPreguntaCollection.reset();
            view = new EncuestaFormView({
                model : plantillaEncuesta,
                collection: plantillaEncuestaPreguntaCollection,
                localCollection: localCollection
            });
            view.on('goto:listarEncuesta', function() {
                 me.showEncuestaList();
                 Backbone.history.navigate('encuestas/')
            });
            localCollection.fetch({
            	reset: true,
            	success: function () {
            		app.rootView.showChildView('main', view);
            	}
            });
        },
        showEncuestaFormEdit : function(id) {
                var plantillaEncuesta, view, me;
                me = this;
                plantillaEncuesta = plantillaEncuestaCollection.get(id);
                if (_.isUndefined(plantillaEncuesta)) {
                        plantillaEncuesta = new PlantillaEncuesta({
                                idPlantillaEncuesta : id
                        })
                        plantillaEncuestaCollection.add(plantillaEncuesta);
                }
                view = new EncuestaFormView({
                        model : plantillaEncuesta,
                        collection: plantillaEncuestaPreguntaCollection,
                        localCollection: localCollection
                });
                view.on('goto:listarEncuesta', function() {
                        me.showEncuestaList();
                        Backbone.history.navigate('encuestas/')
                });
                plantillaEncuesta.fetch({
                        success : function() {
                                plantillaEncuestaPreguntaCollection.fetch({
                                        reset: true,
                                        data: {
                                                idPlantillaEncuesta: plantillaEncuesta.id
                                        },
                                        success: function () {
                                        	localCollection.fetch({
                                        		success: function () {
                                        			app.rootView.showChildView('main', view);
                                        		}
                                        	}); 
                                        }
                                });
                        }
                });
        },

        showPromocionList : function() {
                var view, me;
                me = this;
                view = new PromocionListView({
                        collection : promocionCollection
                });
                view.on('goto:nuevaPromocion', function() {
                        me.showPromocionFormNew();
                        
                        Backbone.history.navigate('promociones/new')
                });
                view.on('goto:editarPromocion', function(id) {
                        me.showPromocionFormEdit(id);
                        Backbone.history.navigate('promociones/edit/' + id)
                });
                promocionCollection.fetch({
                        success : function() {
                                app.rootView.showChildView('main', view);
                        }
                });
        },
        showPromocionFormNew : function() {
            console.log("mostrando nueva promocion");
                var view, me, promocionModel;
                me = this;
                promocionModel = new PromocionModel;
                //promocionCollection.add(promocionModel);
                //plantillaEncuestaPreguntaCollection.reset();
                var motivoPromocionCollection = new MotivoPromocionCollection;
                motivoPromocionCollection.fetch({
                        success: function () {	
                                var tipoPromocionCollection = new TipoPromocionCollection;
                                tipoPromocionCollection.fetch({
                                        success: function () {	
                                                var localCollection = new LocalCollection;
                                                localCollection.fetch({
                                                        success: function () {										
                                                                view = new PromocionFormView({
                                                                        motivoPromocionCollection:motivoPromocionCollection,
                                                                        tipoPromocionCollection:tipoPromocionCollection,
                                                                        localCollection:localCollection,
                                                                        model : promocionModel,
                                                                        collection: promocionCollection,
                                                                        mode:  1	
                                                                });
                                                                view.on('goto:listarPromocion', function() {
                                                                        me.showPromocionList();
                                                                        Backbone.history.navigate('promociones/')
                                                                });
                                                                app.rootView.showChildView('main', view);	
                                                        }							
                                                });		
                                }					
                                });

                        }

                });

        },
        showPromocionFormEdit : function(id) {
                var promocionModel, view, me;
                me = this;
                promocionModel = promocionCollection.get(id);
                if (_.isUndefined(promocionModel)) {
                        promocionModel = new PromocionModel({
                                idPromocion : id
                        })
                }                
                var motivoPromocionCollection = new MotivoPromocionCollection;
                motivoPromocionCollection.fetch({
                        success: function () {	
                                var tipoPromocionCollection = new TipoPromocionCollection;
                                tipoPromocionCollection.fetch({
                                        success: function () {	
                                                var localCollection = new LocalCollection;
                                                localCollection.fetch({
                                                        success: function () {                                                            
                                                        promocionModel.fetch({
                                                            success: function () {
                                                                 view = new PromocionFormView({
                                                                            motivoPromocionCollection:motivoPromocionCollection,
                                                                            tipoPromocionCollection:tipoPromocionCollection,
                                                                            localCollection:localCollection,
                                                                            model : promocionModel,
                                                                            //collection: promocionCollection,
                                                                            mode:  1	
                                                                    });
                                                                    view.on('goto:listarPromocion', function() {
                                                                            me.showPromocionList();
                                                                            Backbone.history.navigate('promociones/')
                                                                    });
                                                                    app.rootView.showChildView('main', view);
                                                                 }							
                                                            });	
                                                      
                                                               	
                                                        }							
                                                });		
                                }					
                                });
                        }});
		},
        showPromocionEnviadaList : function(id) {
            var view, me;
            me = this;
            view = new PromocionEnviadaListView({
                    idPromocion:id,
                    collection : promocionEnviadaCollection
            });
            app.rootView.showChildView('main', view);

            view.on('goto:listarPromocion', function() {
                    me.showPromocionList();
                    Backbone.history.navigate('promociones/')
            });
//            promocionEnviadaCollection.fetch({
//                    reset: true,
//                    data: {
//                            idPromocion: id
//                    },
//                    success : function() {
//                            app.rootView.showChildView('main', view);
//                    }
//            });
        },
                
                
	}
});
