define([ 'model/Usuario', 'model/Rol', 
         'collection/UsuarioCollection',
         'collection/RolCollection',
         'collection/OpcionCollection',
         'collection/CargoColaboradorCollection',
         'collection/LocalCollection',
		'view/UsuarioListView', 'view/RolListView',
		'view/RolFormView', 'view/UsuarioFormView',
		'view/UsuarioPasswordFormView',
		'app', 'backbone',
		'underscore'], function(Usuario, Rol,
		UsuarioCollection, RolCollection, OpcionCollection, CargoColaboradorCollection, LocalCollection,
		UsuarioListView, RolListView, RolFormView, UsuarioFormView, UsuarioPasswordFormView,
		app, Backbone, _) {
	var usuarioCollection = new UsuarioCollection([]);
	var rolCollection = new RolCollection([]);
	var opcionCollection = new OpcionCollection([]);
	var cargoColaboradorCollection = new CargoColaboradorCollection([]);
	var localCollection = new LocalCollection([]);
	return {
		showUsuarioList : function() {
			var view, me;
			me = this;
			view = new UsuarioListView({
				collection : usuarioCollection
			});
			view.on('goto:registrarUsuario', function() {
				me.showNewUserForm();
				Backbone.history.navigate('usuarios/new/')
			});
			view.on('goto:editarUsuario', function(id) {
				me.showEditUserForm(id);
				Backbone.history.navigate('usuarios/edit/' + id)
			});
			view.on('goto:cambiarPassword', function(id) {
				me.showChangeUserPasswordForm(id);
				Backbone.history.navigate('usuarios/password/' + id)
			});
			usuarioCollection.fetch({
				success : function() {
					app.rootView.showChildView('main', view);
				}
			});
		},
		showNewUserForm: function () {
			var view, me = this, usuario;
			usuario = new Usuario();
			usuarioCollection.add(usuario);
			view = new UsuarioFormView({
				model: usuario,
				collection: rolCollection,
				cargoColaboradorCollection: cargoColaboradorCollection,
				localCollection: localCollection
			});
			rolCollection.fetch({
				success: function () {
					cargoColaboradorCollection.fetch({
						success: function () {
							localCollection.fetch({
								success: function () {
									app.rootView.showChildView('main', view);
								}
							});
						}
					});
				}
			});
			view.on('goto:listarUsuario', function () {
				me.showUsuarioList();
				Backbone.history.navigate('usuarios/')
			});
		},
		showEditUserForm: function (id) {
			var view, me = this, usuario;
			usuario = usuarioCollection.get(id);
			if (_.isUndefined(usuario)) {
				usuario = new Usuario({
					idUsuario: id
				});
				usuarioCollection.add(usuario);				
			}
			view = new UsuarioFormView({
				model: usuario,
				collection: rolCollection,
				cargoColaboradorCollection: cargoColaboradorCollection,
				localCollection: localCollection
			});
			usuario.fetch({
				success: function () {
					rolCollection.fetch({
						success: function () {
							cargoColaboradorCollection.fetch({
								success: function () {
									localCollection.fetch({
										success: function () {
											app.rootView.showChildView('main', view);
										}
									});
								}
							});
						}
					});
				}
			});
			view.on('goto:listarUsuario', function () {
				me.showUsuarioList();
				Backbone.history.navigate('usuarios/')
			});
		},
		showChangeUserPasswordForm: function (id) {
			var view, me = this, usuario;
			usuario = usuarioCollection.get(id);
			if (_.isUndefined(usuario)) {
				usuario = new Usuario({
					idUsuario: id
				});
				usuarioCollection.add(usuario);				
			}
			view = new UsuarioPasswordFormView({
				model: usuario
			});
			usuario.fetch({
				success: function () {
					app.rootView.showChildView('main', view);
				}
			});
			view.on('goto:listarUsuario', function () {
				me.showUsuarioList();
				Backbone.history.navigate('usuarios/')
			});
		},
		
		
		showRolList: function () {
			var view, me = this;
			view = new RolListView({
				collection: rolCollection
			});
			rolCollection.fetch({
				success: function () {
					app.rootView.showChildView('main', view);
				}
			});
			
			view.on('goto:editarRol', function (id) {
				me.showEditRolForm(id);
				Backbone.history.navigate('roles/edit/' + id)
			});
			
			view.on('goto:registrarRol', function () {
				me.showNewRolForm();
				Backbone.history.navigate('roles/new/')
			});
		},
		showNewRolForm: function () {
			var view, me = this, rol;
			rol = new Rol;
			rolCollection.add(rol);
			view = new RolFormView({
				model: rol,
				collection: opcionCollection
			});
			opcionCollection.fetch({
				success: function () {
					app.rootView.showChildView('main', view);
				}
			});
			view.on('goto:listarRol', function () {
				me.showRolList();
				Backbone.history.navigate('roles/')
			});
		},
		showEditRolForm: function (id) {
			var view, me = this, rol;
			rol = rolCollection.get(id);
			if (_.isUndefined(rol)) {
				rol = new Rol({
					idRol: id
				});
				rolCollection.add(rol);				
			}
			view = new RolFormView({
				model: rol,
				collection: opcionCollection
			});
			rol.fetch({
				success: function () {
					opcionCollection.fetch({
						success: function () {
							app.rootView.showChildView('main', view);
						}
					});
				}
			});
			view.on('goto:listarRol', function () {
				me.showRolList();
				Backbone.history.navigate('roles/')
			});
		}
	}
});
