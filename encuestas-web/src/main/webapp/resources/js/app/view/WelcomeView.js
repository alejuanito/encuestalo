define(['marionette',
        'tpl!templates/html/welcome.tpl'], 
        function (Marionette,
        		welcomeTemplate) {
	return Marionette.ItemView.extend({
		template: welcomeTemplate
	});
});