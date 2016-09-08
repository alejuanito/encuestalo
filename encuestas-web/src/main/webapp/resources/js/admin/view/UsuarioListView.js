define(['underscore', 'marionette', 'tpl!templates/UsuarioList.html', 
        'tpl!templates/UsuarioListItem.html'],
    function (_, Marionette, usuarioListTemplate, usuarioListItemTemplate) {
        var rowView = Marionette.ItemView.extend({
            tagName: 'tr',
            template: usuarioListItemTemplate,
            events: {
            	'click td.clickable': 'editarUsuario',
            	'click .cambia-password': 'gotoCambiarPassword'
            },
            editarUsuario: function () {
            	this.model.collection.trigger('goto:editarUsuario', this.model.id);
            },
            gotoCambiarPassword: function () {
            	this.model.collection.trigger('goto:cambiarPassword', this.model.id);
            }
        });

        return Marionette.CompositeView.extend({
            template: usuarioListTemplate,
            childViewContainer: 'tbody',
            childView: rowView,
            events: {
                'click #nuevo-usuario': 'nuevoUsuario'
            },
            collectionEvents: {
            	'goto:editarUsuario': 'editarUsuario',
            	'goto:cambiarPassword': 'gotoCambiarPassword'
            },
            nuevoUsuario: function () {
                this.trigger('goto:registrarUsuario');
            },
            editarUsuario: function (id) {
                this.trigger('goto:editarUsuario', id);
            },
            gotoCambiarPassword: function (id) {
            	this.trigger('goto:cambiarPassword', id);
            }
        });
    });
