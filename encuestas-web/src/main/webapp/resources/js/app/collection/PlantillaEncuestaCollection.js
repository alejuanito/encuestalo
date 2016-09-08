define(['backbone', 'model/PlantillaEncuestaModel'], function (Backbone, PlantillaEncuestaModel) {
	var PlantillaEncuestaCollection = Backbone.Collection.extend({
		url: baseUrl+'/plantilla',
		model: PlantillaEncuestaModel
	});	
	return PlantillaEncuestaCollection;
});