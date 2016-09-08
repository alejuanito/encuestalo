define(['underscore', 'backbone'], function (_, Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idPlantillaEncuestaDetalle',
		defaults: {
			idPlantillaEncuestaDetalle:null,
			noPregunta:'',
			ectcPlantillaEncuesta:{
				idPlantillaEncuesta:'',
				ectmEmpresa:{					
				},
				
		}
		}
	});
});