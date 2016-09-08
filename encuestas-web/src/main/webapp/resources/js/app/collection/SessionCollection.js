define(['backbone', 'model/SessionModel'], function (Backbone, SessionModel) {
	var SessionCollection = Backbone.Collection.extend({
		url: baseUrl+'/session',
		model: SessionModel
	});	
	return SessionCollection;
});