/**
 * Created by JaxKodex on 04/04/2016.
 */
define(['collection/ClienteCollection', 'collection/LocalCollection',
        'view/clientes/DirectorioClientesView', 'app'],
    function (ClienteCollection, LocalCollection, DirectorioClienteView, app) {
        var clienteCollection = new ClienteCollection([]);
        var localCollection = new LocalCollection([]);
        return {
            showDirectorioClientes: function (filters) {
                var filtersObject = {};
                // from http://stackoverflow.com/questions/15795090/handling-view-options-via-backbone-routes
                if (filters) {
                    _.each(filters.split('/'), function(element, index, list){
                        if(element){
                            var param = element.split(':');
                            var key = param[0];
                            var val = param[1];
                            filtersObject[key] = val;
                        }
                    });
                }

                var view = new DirectorioClienteView({
                    collection: clienteCollection,
                    localCollection: localCollection,
                    filters: filtersObject
                });
                // clienteCollection.fetch({
                    // data: filtersObject,
                    // success: function () {
                        localCollection.fetch({
                            success: function () {
                                app.rootView.showChildView('main', view);
                            }
                        });
                    // }
                // });
            }
        };
    });
