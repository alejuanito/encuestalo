define(['backbone', 'model/Rol'], function (Backbone, RolModel) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/rol',
        model: RolModel
    });
});
