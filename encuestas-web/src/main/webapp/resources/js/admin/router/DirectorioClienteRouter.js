/**
 * Created by JaxKodex on 04/04/2016.
 */
define(['marionette'], function (Marionette) {
    return Marionette.AppRouter.extend({
        appRoutes: {
            'clientes/*filters': 'showDirectorioClientes'
        }
    });
});
