define(['marionette'], function (Marionette) {
    return Marionette.AppRouter.extend({
        appRoutes: {
            'me/contrasenia/': 'showCambiarContraseniaFormView'
        }
    });
});