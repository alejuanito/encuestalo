define(['underscore', 'backbone'], function (_, Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'coTipoDocumento',
		defaults: {
			coTipoDocumento:null,
			deLarga:'',
			deCorta:''			
		}
	});
});