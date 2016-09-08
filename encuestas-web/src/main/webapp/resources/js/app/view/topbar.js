define(['marionette', 'tpl!templates/html/topbar.tpl'], function (Marionette, topbarTemplate) {
	return Marionette.ItemView.extend({
		initialize: function () {
			this.menuShown = true;
		},
		events: {
			'click #menu-button': 'onMenuButtonClick'
		},
		template: topbarTemplate,
		onMenuButtonClick: function (evt) {
			evt.preventDefault();
			if (this.menuShown) {
				// hideMenu
				this.menuShown = false;
				$('.contents').animate({ 'margin-left': '0px' });
			} else {
				// showMenu
				this.menuShown = true;
				$('.contents').animate({ 'margin-left': '290px' });
			}
		}
	});
});