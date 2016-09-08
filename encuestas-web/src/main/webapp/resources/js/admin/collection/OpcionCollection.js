define(['backbone', 'model/Opcion'], function (Backbone, Opcion) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/opcion',
        model: Opcion
    });
});
