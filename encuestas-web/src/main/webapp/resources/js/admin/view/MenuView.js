define(['marionette', 'tpl!templates/Menu.html', 
        'jquery', 'underscore'], function (Marionette, menuTemplate, $, _) {
	var COMPRESSED_MENU_WIDTH = 60;
	var FULL_MENU_WIDTH = 250;
	
	var itemView = Marionette.ItemView.extend({
		tagName: 'li',
		template: _.template('<a href="<%=url%>"><span class="<%=noIcon%>"></span> <%=nombre%></a>')
	});
	
    return Marionette.CompositeView.extend({
        template: menuTemplate,
        childViewContainer: '#menuholder',
        childView: itemView,
        // events: {
        // 	'click #hide-menu': 'toggleHideMenu'
        // },
        // toggleHideMenu: function (evt) {
        // 	evt.preventDefault();
        // 	var mo = $('.menu-overlay');
        // 	var menu = $('#menu');
        // 	var main = $('#main');
        // 	var w = mo.width();
        // 	var nw = w > COMPRESSED_MENU_WIDTH ? COMPRESSED_MENU_WIDTH : FULL_MENU_WIDTH;
        // 	if (w > COMPRESSED_MENU_WIDTH) {
        // 		menu.addClass('compressed-menu');
        // 	}
        // 	mo.animate({ width : nw+'px' });
        // 	main.animate({ 'margin-left': nw+'px' });
        // 	menu.animate({ width : nw+'px' }, {
        // 		complete: function () {
        //         	if (w < FULL_MENU_WIDTH) {
        //         		menu.removeClass('compressed-menu');
        //         	}
        // 		}
        // 	});
        // },
        onRender: function () {
        	// var mo = $('.menu-overlay');
        	// var menu = $('#menu');
        	// var w = mo.width();
        	// if (w <= COMPRESSED_MENU_WIDTH) {
        	// 	menu.addClass('compressed-menu');
        	// }
        }
    });
});