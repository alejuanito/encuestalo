define(['underscore', 'marionette', 'tpl!templates/EncuestaList.html'],
    function (_, Marionette, encuestaListTemplate) {
        var rowView = Marionette.ItemView.extend({
            tagName: 'tr',
            template: _.template('<td><%=deEncuestaCorto%></td><td><%=local.noLocal%></td><td><%=esPlantillaEncuesta == \'A\' ? \'HABILITADA\' : \'DESHABILITADA\'%></td>'),
            events: {
            	'click td': 'editarEncuesta'
            },
            editarEncuesta: function () {
            	this.model.collection.trigger('goto:editarEncuesta', this.model.id);
            }
        });

        return Marionette.CompositeView.extend({
            template: encuestaListTemplate,
            childViewContainer: 'tbody',
            childView: rowView,
            events: {
                'click #nueva-encuesta': 'nuevaEncuesta'
            },
            collectionEvents: {
            	'goto:editarEncuesta': 'editarEncuesta'
            },
            nuevaEncuesta: function () {
                this.trigger('goto:nuevaEncuesta');
            },
            editarEncuesta: function (id) {
                this.trigger('goto:editarEncuesta', id);
            }
        });
    });
