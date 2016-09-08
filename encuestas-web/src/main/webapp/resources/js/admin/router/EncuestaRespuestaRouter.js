define(['marionette'], function (Marionette) {
    return Marionette.AppRouter.extend({
        appRoutes: {
            'respuestas/': 'showEncuestaRespuestaList'//,
//            'respuestas/edit/:id': 'showEncuestaRespuestaForm'
        }
    });
});