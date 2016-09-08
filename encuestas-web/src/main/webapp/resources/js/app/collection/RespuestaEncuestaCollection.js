define(['backbone', 'model/RespuestaEncuestaModel'], function (Backbone, RespuestaEncuestaModel) {
	var RespuestaEncuestaCollection = Backbone.Collection.extend({
		url: rootUrl+'/api/respuestaEncuesta',
		model: RespuestaEncuestaModel
	});	
	return RespuestaEncuestaCollection;
});