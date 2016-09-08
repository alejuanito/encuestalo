define(['underscore', 'marionette', 'tpl!templates/RolList.html'],
    function (_, Marionette, rolListTemplate) {
        var rowView = Marionette.ItemView.extend({
            tagName: 'tr',
            template: _.template('<td><%=nombre%></td>'),
            events: {
            	'click td' : 'onClickRow'
            },
            onClickRow: function () {
            	this.model.collection.trigger('goto:editarRol', this.model.id);
            }
        });

        return Marionette.CompositeView.extend({
            template: rolListTemplate,
            childViewContainer: 'tbody',
            childView: rowView,
            events: {
            	'click #nuevo-rol': 'nuevo'
            },
            collectionEvents: {
            	'goto:editarRol': 'goEdit'
            },
            goEdit: function (id) {
            	this.trigger('goto:editarRol', id);
            },
            nuevo: function () {
            	this.trigger('goto:registrarRol');
            }
        });
    });
