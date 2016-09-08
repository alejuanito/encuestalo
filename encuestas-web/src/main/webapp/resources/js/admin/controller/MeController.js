define(['app', 'backbone', 'view/me/CambiarContraseniaFormView', 'controller/IndexController'], function (app, Backbone, CambiarContraseniaFormView, IndexController) {
	return {
		showCambiarContraseniaFormView : function() {
			var view, me;
			me = this;
			view = new CambiarContraseniaFormView({
				model: new Backbone.Model
			});
			app.rootView.showChildView('main', view);
			view.on('goto:inicio', function() {
				IndexController.index();
				Backbone.history.navigate('')
			});
		}
	}
});
