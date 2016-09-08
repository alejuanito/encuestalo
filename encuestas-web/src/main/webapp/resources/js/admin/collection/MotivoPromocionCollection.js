define(['backbone', 'model/MotivoPromocionModel'], function (Backbone, MotivoPromocionModel) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/motivo-promocion',
        model: MotivoPromocionModel
    });
});
