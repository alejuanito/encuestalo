define(['marionette', 'templates/app-templates'], function (Marionette, templates) {
	return Marionette.LayoutView.extend({
		template: templates.menuTemplate,
		events: {
			'click ul': 'onClickMenuItem'
		},
		onClickMenuItem: function (evt) {
			var target = evt.target.tagName.toLowerCase() == 'li' ? $(evt.target) : $(evt.target).parent();
			if (target.hasClass('title')) return;
			this.$('li').removeClass('active');
			target.addClass('active');
		}
	});
});