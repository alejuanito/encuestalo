define(['backbone', 'validate', 'underscore'], function (Backbone, validate, _) {
    return Backbone.Model.extend({
        idAttribute: 'idPlantillaEncuesta',
        defaults: {
            //empresa: {},
            local: {},
            deEncuestaLargo: '',
            deEncuestaCorto: '',
            coTipoEncuesta: '',
            esPlantillaEncuesta: ''
        },
        validate: function (attributes, options) {
            var constraints = {
                    deEncuestaCorto: {
                        presence: {
                            message: function () {
                                return 'El campo descripción corta es requerido';
                            }
                        }
                    },
                    deEncuestaLargo: {
                        presence: {
                            message: function () {
                                return 'El campo descripción larga es requerido';
                            }
                        }
                    }
            };
            
            var errors = validate (attributes, constraints, { format: 'detailed', fullMessages: false });
            
            if (!_.isUndefined(errors) && !_.isNull(errors) && !_.isEmpty(errors)) {
            	return errors;
            }
        }
    });
});