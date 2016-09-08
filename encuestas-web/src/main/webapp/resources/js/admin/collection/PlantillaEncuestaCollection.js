define(['backbone', 'model/PlantillaEncuesta'], function (Backbone, PlantillaEncuesta) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/plantillaEncuesta',
        model: PlantillaEncuesta,
        comparator: 'idPlantillaEncuesta'
    });
});
