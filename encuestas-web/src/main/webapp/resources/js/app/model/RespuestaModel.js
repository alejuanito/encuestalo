define(['underscore', 'backbone'], function (_, Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idRespuesta',
		defaults: {
			idRespuesta:null,
			plantillaEncuestaPregunta:{
				idPlantillaEncuestaDetalle:''
			},
			deRespuesta:'',			
			nuOrden:''			
		}
	});
});