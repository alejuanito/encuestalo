define(['underscore', 'backbone'], function (_, Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idArea',
		defaults: {
			idArea:null,
			deArea:'',
			local:{
				idLocal:''
				
			}
		}
	});
});