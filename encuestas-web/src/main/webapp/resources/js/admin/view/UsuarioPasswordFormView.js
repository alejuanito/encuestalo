define(['marionette', 'tpl!templates/UsuarioPasswordForm.tpl', 'underscore'], function (Marionette, usuarioPasswordFormTemplate, _) {
	return Marionette.ItemView.extend({
		template: usuarioPasswordFormTemplate,
		events: {
			'click #cambiarcontra': 'cambiarContrasenia',
			'click #cancel': 'goToLista'
		},
		cambiarContrasenia: function (evt) {
			evt.preventDefault();
//			var oldPassword = this.$('#oldPassword').val();
			var me = this;
			var newPassword = this.$('#newPassword').val();
			var newPassword2 = this.$('#newPassword2').val();
			
			if (newPassword != newPassword2) {
				alert('Las contraseñas deben coincidir.');
				return;
			}
			
			if (_.isEmpty(newPassword)) {
				alert('Ingrese una contraseña');
				return;
			}
			
			this.model.save({password: newPassword}, {
				headers: {
					coCargoColaborador: '',
					changePassword: true
				},
				success: function () {
					alert('Contraseña actualizada.');
					me.trigger('goto:listarUsuario');
				}
			});
		},
		goToLista: function () {
			this.trigger('goto:listarUsuario');
		}
	});
});