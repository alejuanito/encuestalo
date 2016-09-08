/**
 * Created by JaxKodex on 04/04/2016.
 */
define(['backbone', 'model/Cliente'], function (Backbone, Cliente) {
    return Backbone.Collection.extend({
        url: rootUrl+'/api/cliente',
        model: Cliente,
        parse: function (response) {
            this.page = response;
            return response.content;
        }
    });
});
