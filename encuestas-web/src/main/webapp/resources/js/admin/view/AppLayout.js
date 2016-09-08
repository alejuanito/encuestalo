define(['marionette'], function (Marionette) {
    return Marionette.LayoutView.extend({
        el: 'body',
        regions: {
            menu: '#menu',
            top: '#top',
            main: '#content'
        }
    });
});
