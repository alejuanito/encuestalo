define([ 'model/Encuesta',
         'collection/EncuestaCollection', 
         'collection/PlantillaEncuestaCollection', 
         'collection/ReporteEncuestaRespuestaCollection',
         'collection/LocalCollection', 
         'view/EncuestaRespuestaListView', 
         'app', 'backbone',
		'underscore'], function(Encuesta,
		EncuestaCollection, PlantillaEncuestaCollection,
		ReporteEncuestaRespuestaCollection,
		LocalCollection,
		EncuestaRespuestaListView,
		app, Backbone, _) {
	var encuestaCollection, plantillaEncuestaCollection, 
		reporteEncuestaRespuestaCollection, localCollection;
	encuestaCollection = new EncuestaCollection([]);
	plantillaEncuestaCollection = new PlantillaEncuestaCollection ([]);
	reporteEncuestaRespuestaCollection = new ReporteEncuestaRespuestaCollection([]);
	localCollection = new LocalCollection([]);
	return {
		showEncuestaRespuestaList : function() {
			var me = this;
			var view = new EncuestaRespuestaListView({
				collection: reporteEncuestaRespuestaCollection,
				plantillaEncuestaCollection: plantillaEncuestaCollection,
                localCollection: localCollection
			});
			localCollection.fetch({
				success: function () {
                    var plantillaEncuestaDataQuery = {};
                    if (localCollection.size() > 0) {
                        plantillaEncuestaDataQuery = {
                            idLocal: localCollection.at(0).id
                        };
                    }
                    plantillaEncuestaCollection.fetch({
                        reset: true,
                        data: plantillaEncuestaDataQuery,
                        success: function () {
                            app.rootView.showChildView('main', view);
                        },
                        error: function () {
                            alert('Un error ocurrió mientras se consultaba con el servidor.');
                        }
                    });
				}
			});
			view.on('goto:formview', function (id) {
				me.showEncuestaRespuestaForm(id);
				Backbone.history.navigate('respuestas/edit/'+id);
			});
		},
//		showEncuestaRespuestaForm: function (id) {
//			var me = this;
//			var encuesta = encuestaCollection.get(id);
//			var view;
//			if (_.isUndefined(encuesta)) {
//				encuesta = new Encuesta({ idEncuesta: id });
//				encuestaCollection.add(encuesta);
//			}
//			view = new EncuestaRespuestaFormView({
//				model: encuesta,
//				collection: encuestaRespuestaCollection
//			});
//			encuesta.fetch({
//				success: function () {
//					encuestaRespuestaCollection.fetch({
//						reset: true,
//						data: {
//							idEncuesta: id
//						},
//						success: function () {
//							app.rootView.showChildView('main', view);
//						}
//					});
//				}
//			});
//		}
	}
});
