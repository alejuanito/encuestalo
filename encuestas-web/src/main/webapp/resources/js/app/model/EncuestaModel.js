define(['underscore', 'backbone'], function (_, Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idEncuesta',
		defaults: {
			idEncuesta:null,
			Atencion:{
				idAtencion:''
			},
                        Local:{
                            idLocal:''
                        }
		}
	});
});