define(['backbone', 'validate', 'underscore'], function (Backbone, validate, _) {
    return Backbone.Model.extend({
        idAttribute: 'idLocal',
        defaults: {
        	empresa: {},
        	noLocal:''
        },
        validate: function (attributes, options) {
            var constraints = {
            };
        }
    });
});