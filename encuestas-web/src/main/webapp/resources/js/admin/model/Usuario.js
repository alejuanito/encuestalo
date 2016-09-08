define(['backbone', 'validate', 'underscore'], function (Backbone, validate, _) {
    return Backbone.Model.extend({
        idAttribute: 'idUsuario',
        defaults: {
            cargo: '',
        	username: '',
        	password: '',
        	estado: '',
        	inAdmin: false,
        	persona: {},
            empresa: {},
            colaborador: {
            	local: {}
            },
            usuarioRols: []
        },
        validate: function (attributes, options) {
            var constraints = {
            };
            
//            var errors = validate (attributes, constraints, { format: 'detailed', fullMessages: false });
            
//            if (!_.isUndefined(errors) && !_.isNull(errors) && !_.isEmpty(errors)) {
//            	return errors;
//            }
        }
    });
});