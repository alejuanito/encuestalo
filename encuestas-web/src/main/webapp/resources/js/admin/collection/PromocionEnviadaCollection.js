define(['backbone', 'model/PromocionEnviadaModel'], function (Backbone, PromocionEnviadaModel) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/promocionEnviada',
        model: PromocionEnviadaModel,
        parse: function (response) {
            this.page = response;
            return response.content;
        }
    });
});
