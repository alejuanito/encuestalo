define(['backbone', 'validate', 'underscore'], function (Backbone, validate, _) {
    return Backbone.Model.extend({
        idAttribute: 'idTipoPromocion',
        defaults: {
        	idTipoPromocion: '',
            deTipo: ''
        }
    });
});