define(['backbone'], function (Backbone) {
    return Backbone.Model.extend({
        idAttribute: 'idRol',
        defaults: {
        	nombre: '',
        	estado: '',
        	rolOpciones: []
        }
    });
});