define(['backbone', 'model/ReporteRespuesta'], function (Backbone, ReporteRespuesta) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/reporteRespuesta',
        model: ReporteRespuesta
    });
});
