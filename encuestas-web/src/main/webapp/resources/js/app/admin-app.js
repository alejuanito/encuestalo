define(['marionette'], function (Marionette) {
	var app = new Marionette.Application ();
	
	app.addRegions({
		main: '#admin-main',
		menu: '#admin-menu',
		//topbar: '#top-bar'
	});
	
	return window.adminApp = app;
});