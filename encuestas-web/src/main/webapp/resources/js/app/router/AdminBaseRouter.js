define(['marionette', 'underscore'], function(Marionette, _) {
    return Marionette.AppRouter.extend({
        onRoute: function(name, hash, args) {
            var result = false;
//            _.some(opcionesData, function(permiso) {
//                if (hash.indexOf('direccion/:id') === 0)
//                    hash = 'direccion/' + args[0] + hash.slice(13);
//                
//                if (hash.indexOf(permiso.urlOpcion.slice(1)) === 0) {
//                    return result = true;
//                }
//            });
//            if (!result) {
//                alert('No tiene permiso para acceder a esta vista');
//                location.href = '';
//            }
            return result;
        }
    });
});