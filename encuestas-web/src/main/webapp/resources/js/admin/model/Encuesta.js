define(['backbone', 'validate', 'underscore'], function (Backbone, validate, _) {
    return Backbone.Model.extend({
        idAttribute: 'idEncuesta',
        defaults: {
        	atencion: {}
        },
        validate: function (attributes, options) {
            var constraints = {
            };
        }
    });
});