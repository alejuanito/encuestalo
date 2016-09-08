define(['backbone', 'validate', 'underscore','moment'], function (Backbone, moment) {
    return Backbone.Model.extend({
        idAttribute: 'idPromocionEnviada',
        defaults: {
            cliente: {},
            promocion: {},
            feEnvio: ''
        },
    
    });
});