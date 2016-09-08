define(['backbone', 'model/PromocionModel'], function (Backbone, PromocionModel) {
    return Backbone.Collection.extend({
        
        url: rootUrl+'/api/promocion',
        model: PromocionModel
    });
});
