define(['backbone', 'model/Encuesta'], function (Backbone, Encuesta) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/encuestas',
        model: Encuesta
    });
});
