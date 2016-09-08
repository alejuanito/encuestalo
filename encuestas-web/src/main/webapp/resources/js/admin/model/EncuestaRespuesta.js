define(['backbone', 'validate', 'underscore'], function (Backbone, validate, _) {
    return Backbone.Model.extend({
        idAttribute: 'idEncuestaRespuesta',
        defaults: {
        	encuesta: {},
        	plantillaEncuestaRespuesta: {},
        	plantillaEncuestaPregunta: {},
        	deRespuesta: ''
        }
    });
});