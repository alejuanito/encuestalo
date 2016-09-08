define(['underscore', 'backbone'], function (_, Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idPlantillaEncuestaDetalle',
		defaults: {
			idPlantillaEncuestaDetalle:null,
			plantillaEncuesta:{
				idPlantillaEncuesta:''
			},
			dePregunta:'',
			coTipoPregunta:'',
			nuOrden:'',
			estado:'',
			isVisible:1
		}
	});
});