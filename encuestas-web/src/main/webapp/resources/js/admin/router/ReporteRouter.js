define(['marionette'], function (Marionette) {
    return Marionette.AppRouter.extend({
        appRoutes: {
            'reporte-satisfaccion/': 'showReporteSatisfaccionList',
        }
    });
});