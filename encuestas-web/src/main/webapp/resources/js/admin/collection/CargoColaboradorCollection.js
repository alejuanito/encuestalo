define(['backbone', 'model/CargoColaborador'], function (Backbone, CargoColaborador) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/cargocolaborador',
        model: CargoColaborador
    });
});
