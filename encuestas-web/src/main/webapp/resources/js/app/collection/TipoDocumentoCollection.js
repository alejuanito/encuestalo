define(['backbone', 'model/TipoDocumentoModel'], function (Backbone, TipoDocumento) {
	var TipoDocumentoCollection = Backbone.Collection.extend({
		url: rootUrl+'/api/tipoDocumento',
		model: TipoDocumento
	});	
	return TipoDocumentoCollection;
});