define(['backbone', 'model/ReporteEncuestaRespuesta'], function (Backbone, ReporteEncuestaRespuesta) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/reporteEncuestaRespuestas',
        model: ReporteEncuestaRespuesta
    });
});
