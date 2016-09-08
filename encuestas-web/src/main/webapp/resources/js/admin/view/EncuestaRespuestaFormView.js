define(['underscore', 'marionette', 'tpl!templates/EncuestaRespuestaForm.html', 'tpl!templates/EncuestaRespuestaFormRespuestaItem.html'],
    function (_, Marionette, encuestaRespuestaFormTemplate, encuestaRespuestaFormRespuestaItemTemplate) {
        var rowView = Marionette.ItemView.extend({
            className: 'form-group',
            template: encuestaRespuestaFormRespuestaItemTemplate,
            events: {}
        });

        return Marionette.CompositeView.extend({
            template: encuestaRespuestaFormTemplate,
            childViewContainer: 'form',
            childView: rowView
        });
    });
