define(['backbone', 'model/ClienteModel'], function (Backbone, ClienteModel) {
	var ClienteCollection = Backbone.Collection.extend({
		url: rootUrl+'/api/cliente',
		model: ClienteModel
	});	
	return ClienteCollection;
});