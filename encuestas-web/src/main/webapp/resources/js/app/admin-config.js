require.config({
    shim: {
        underscore: {
            exports: '_'
        },
        backbone: {
            deps: ['underscore', 'jquery'],
            exports: 'Backbone'
        },
        bootstrap: {
            deps: ['jquery'],
            exports: '$.fn.popover'
        },
        marionette: {
            deps: ['jquery', 'underscore', 'backbone'],
            exports: 'Marionette'
        },
        moment:{
                deps: ['jquery', 'bootstrap','momentlocale'],
                exports: 'moment'
        }
    },
    paths: {
        jquery: '../jquery-1.11.3.min',
        underscore: '../underscore-min',
        backbone: '../backbone-min',
        bootstrap: '../bootstrap.min',
        marionette: '../backbone.marionette.min',
        tpl: '../tpl',
        moment: '../moment',
        momentlocale: '../moment-with-locales',
        validate: '../validate.min',
    },
   
    urlArgs: "bust=" + (new Date()).getTime(),
    waitSeconds: 0,
});

require(['admin-app', 'backbone',
    'view/menu', 'view/topbar',
    'router/AdminSeguridadRouter', 'router/EncuestaRouter',
    'controller/EncuestaController',
    'model/SessionModel',
    'collection/SessionCollection','moment'],
        function (app, Backbone,
                menuView, topbarView,
                AdminSeguridadRouter, EncuestaRouter,
                encuestaController,
                SessionModel,
                SessionCollection,Moment
                ) {
            var sessionCollection = new SessionCollection;
            app.on('start', function() {
                app.addInitializer(function () {
                    $('#loading-placeholder').animate({
                        'opacity': '0'
                    }, {
                        complete: function () {
                            $('#loading-placeholder').addClass('hidden');
                            $('#workspace').removeClass('hidden').animate({
                                'opacity': '1'
                            }, {});
                        }
                    });
                    //Initialize all routers here
                    new EncuestaRouter({controller: encuestaController});
                    $('.loading-holder').fadeOut(500);
                    Backbone.history.start();
                    $('.glyphicon-user').text(userData.username);
                    $('.glyphicon-shopping-cart').text(userData.local);
                    $('#fecha').text(Moment().format('MMMM Do YYYY'));               
                });
            });
            app.start();
            $(document).ajaxStart(function () {
		 $('.loading-holder').stop().fadeIn(300);
            }).ajaxStop(function () {
                    $('.loading-holder').stop().fadeOut(500);
            });
        });