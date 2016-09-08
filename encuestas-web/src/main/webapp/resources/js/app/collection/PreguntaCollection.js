define(['backbone', 'model/PreguntaModel'], function (Backbone, PreguntaModel) {
	var PreguntaCollection = Backbone.Collection.extend({
		url: rootUrl+'/api/preguntas',
		model: PreguntaModel
	});	
	return PreguntaCollection;
});