define(['backbone', 'validate', 'underscore'], function (Backbone, validate, _) {
    return Backbone.Model.extend({
        idAttribute: 'idMotivoPromocion',
        defaults: {
        	idMotivoPromocion: '',
            deMotivo: ''
        }
    });
});