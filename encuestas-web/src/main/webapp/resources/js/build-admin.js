({
	baseUrl : 'admin',
	name : 'config',
	out : 'admin.min.js',

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
		moment: '../lib/moment-with-locales'
	}
});