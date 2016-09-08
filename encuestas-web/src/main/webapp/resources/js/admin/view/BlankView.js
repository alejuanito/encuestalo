define(['underscore', 'marionette', 'tpl!templates/Blank.html'],
    function (_, Marionette, blankTemplate) {

        return Marionette.ItemView.extend({
            template: blankTemplate
        });
    });
