/**
 * Created by JaxKodex on 04/04/2016.
 */
define(['backbone'], function (Backbone) {
    return Backbone.Model.extend({
        idAttribute: 'idCliente',
        defaults: {
            persona: {
                tipoDocumento: {}
            }
        }
    });
});