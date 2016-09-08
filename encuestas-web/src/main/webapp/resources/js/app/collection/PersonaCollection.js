define(['backbone', 'model/PersonaModel'], function (Backbone, PersonaModel) {
	var PersonaCollection = Backbone.Collection.extend({
		url: rootUrl+'/api/persona',
		model: PersonaModel
	});	
	return PersonaCollection;
});