define(['backbone', 'model/AreaModel'], function (Backbone, AreaModel) {
	var AreaCollection = Backbone.Collection.extend({
		url: rootUrl+'/api/area',
		model: AreaModel
	});	
	return AreaCollection;
});