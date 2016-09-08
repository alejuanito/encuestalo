define(['backbone', 'model/Usuario'], function (Backbone, Usuario) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/usuarios',
        model: Usuario
    });
});
