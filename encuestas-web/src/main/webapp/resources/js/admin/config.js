require.config({
	shim: {
		underscore : {
			exports : '_'
		},
		backbone : {
			deps : [ 'underscore', 'jquery' ],
			exports : 'Backbone'
		},
		bootstrap : {
			deps : [ 'jquery' ],
			exports : '$.fn.popover'
		},
		marionette : {
			deps : [ 'jquery', 'underscore', 'backbone' ],
			exports : 'Marionette'
		},		
		highcharts: {
			deps: ['jquery']
		},
                exporting:{
			deps: ['jquery','highcharts']
		},
                exportcsv:{
			deps: ['jquery','highcharts','exporting']
		},
		jqueryui: {
			deps: ['jquery']
		}
	},
	paths: {
		jquery: '../lib/jquery-1.12.2',
		jqueryui: '../lib/jquery-ui',
		underscore : '../lib/underscore',
		backbone : '../lib/backbone',
		bootstrap : '../lib/bootstrap',
		marionette : '../lib/backbone.marionette',
		tpl : '../lib/tpl',
		validate : '../lib/validate',
		highcharts : '../lib/highcharts',
                exporting:'../lib/exporting',
                exportcsv : '../lib/export-csv',
		moment: '../lib/moment-with-locales'
	}
});

require(['app', 'backbone', 'view/AppLayout', 'view/MenuView', 'view/core/TopView',
		'router/IndexRouter', 'router/UsuarioRouter',
		'router/EncuestaRespuestaRouter', 'router/MeRouter','router/ReporteRouter',
	'router/DirectorioClienteRouter',
		'controller/IndexController', 'controller/UsuarioController',
		'controller/EncuestaRespuestaController', 'controller/MeController', 'controller/ReporteController',
	'controller/DirectorioClienteController',
		'moment', 
		'collection/OpcionCollection', 'underscore', 'jqueryui', 'bootstrap'], function(app, Backbone,
		AppLayout, MenuView, TopView, IndexRouter, UsuarioRouter,
		EncuestaRespuestaRouter, MeRouter,ReporteRouter, DirectorioClienteRouter,
		IndexController, UsuarioController,
		EncuestaRespuestaController, meController,ReporteController, directorioClienteController,
		moment, OpcionCollection, _) {
	app.on('start', function() {
		app.rootView = new AppLayout;
		var opciones = new OpcionCollection();
		_.each(usuarioData.usuarioRols, function (value) {
			_.each(value.rol.rolOpciones, function (v) {
				opciones.add(v.opcion);
			})
		});
		app.rootView.showChildView('menu', new MenuView({
			collection: opciones
		}));
		app.rootView.showChildView('top', new TopView({
			model: new Backbone.Model
		}));

		new IndexRouter({
			controller : IndexController
		});
		new UsuarioRouter({
			controller : UsuarioController
		});
		new EncuestaRespuestaRouter({
			controller : EncuestaRespuestaController
		});
		new MeRouter({
			controller: meController
		});
        new ReporteRouter({
			controller: ReporteController
		});
        new DirectorioClienteRouter ({
            controller: directorioClienteController
        });
		$.datepicker.setDefaults({
			closeText: "Cerrar",
			prevText: "&#x3C;Ant",
			nextText: "Sig&#x3E;",
			currentText: "Hoy",
			monthNames: [ "enero","febrero","marzo","abril","mayo","junio",
			"julio","agosto","septiembre","octubre","noviembre","diciembre" ],
			monthNamesShort: [ "ene","feb","mar","abr","may","jun",
			"jul","ago","sep","oct","nov","dic" ],
			dayNames: [ "domingo","lunes","martes","miércoles","jueves","viernes","sábado" ],
			dayNamesShort: [ "dom","lun","mar","mié","jue","vie","sáb" ],
			dayNamesMin: [ "D","L","M","X","J","V","S" ],
			weekHeader: "Sm",
			dateFormat: "dd/mm/yy",
			firstDay: 1,
			isRTL: false,
			showMonthAfterYear: false,
			yearSuffix: ""
		});
		$('.loading-holder').fadeOut(500);
		Backbone.history.start();
	});
	app.start();
	 $(document).ajaxStart(function () {
		 $('.loading-holder').stop().fadeIn(300);
	 }).ajaxStop(function () {
		 $('.loading-holder').stop().fadeOut(500);
	 });
});