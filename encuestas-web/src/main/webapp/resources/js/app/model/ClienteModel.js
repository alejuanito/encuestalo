define(['underscore', 'backbone', 'validate'], function (_, Backbone, validate) {
	return Backbone.Model.extend({
		idAttribute: 'idCliente',
		urlRoot: rootUrl+'/api/cliente',
		defaults: {
			idCliente:null,
                        inPromocion:'',
			persona:{
				idPersona:''
			},
			empresa:{
				idEmpresa:''
			}
		},
	

	});
	
	
});
