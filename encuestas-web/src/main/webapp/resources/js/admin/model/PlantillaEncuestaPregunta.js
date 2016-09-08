define(['backbone'], function (Backbone) {
    return Backbone.Model.extend({
        idAttribute: 'idPlantillaEncuestaDetalle',
        defaults: {
            plantillaEncuesta: {},
            nuOrden: 0,
            dePregunta: '',
            coTipoPregunta: '',
            estado: '',
            inEsRptaCorta: false
        },
        validate: function () {
            console.log('Where validation occurs');
        }
    });
});