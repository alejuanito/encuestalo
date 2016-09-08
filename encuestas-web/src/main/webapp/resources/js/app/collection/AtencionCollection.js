define(['backbone', 'model/AtencionModel'], function (Backbone, AtencionModel) {
	var AtencionCollection = Backbone.Collection.extend({
		url: rootUrl+'/api/atencion',
		model: AtencionModel
	});	
	return AtencionCollection;
});