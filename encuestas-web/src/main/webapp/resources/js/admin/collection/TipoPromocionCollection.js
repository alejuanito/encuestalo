define(['backbone', 'model/TipoPromocionModel'], function (Backbone, TipoPromocionModel) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/tipo-promocion',
        model: TipoPromocionModel
    });
});
