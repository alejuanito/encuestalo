define(['backbone', 'model/RespuestaModel'], function (Backbone, RespuestaModel) {
	var RespuestaCollection = Backbone.Collection.extend({
		url: rootUrl+'/api/respuestas',
		model: RespuestaModel
	});	
	return RespuestaCollection;
});