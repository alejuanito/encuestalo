define(['underscore', 'backbone'], function (_, Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idColaborador',
		defaults: {
			idColaborador:null,			
			persona:{
				idPersona:'',
                                noCompleto:''
			},
			local:{
				idLocal:''
			}
		}
	});
});