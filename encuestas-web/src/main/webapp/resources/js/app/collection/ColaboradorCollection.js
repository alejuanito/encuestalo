define(['backbone', 'model/ColaboradorModel'], function (Backbone, ColaboradorModel) {
	var ColaboradorCollection = Backbone.Collection.extend({
		url: rootUrl+'/api/colaborador',
		model: ColaboradorModel
	});	
	return ColaboradorCollection;
});