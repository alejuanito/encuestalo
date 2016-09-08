define(['backbone', 'model/EncuestaRespuesta'], function (Backbone, EncuestaRespuesta) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/respuestaEncuesta',
        model: EncuestaRespuesta
    });
});
