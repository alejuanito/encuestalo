define(['backbone', 'model/PlantillaEncuestaPregunta'], function (Backbone, PlantillaEncuestaPregunta) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/preguntas',
        model: PlantillaEncuestaPregunta,
        comparator: 'nuOrden'
    });
});
