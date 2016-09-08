define(['marionette', 'jquery', 'underscore', 'tpl!templates/me/CambiaContraseniaForm.html'], 
	function (Marionette, $, _, cambiaContraseniaFormTemplate) {
		return Marionette.ItemView.extend({
			template: cambiaContraseniaFormTemplate,
			events: {
				'click .btn-change-password': 'cambiarContrasenia',
				'click .btn-cancel': 'cancelar'
			},
			cambiarContrasenia: function (evt) {
				evt.preventDefault();
				var data, repeatPassword;
				repeatPassword = this.$('#repeatPassword').val();
				var data = {
						oldPassword: this.$('#oldPassword').val(),
						newPassword: this.$('#newPassword').val()
				};
				
				if (_.isEmpty(data.newPassword) || data.newPassword != repeatPassword) {
					alert('Las contraseñas no coinciden.');
					return;
				}
				console.log(data);
				$.post(rootUrl+'/api/me/password', data, function () {
					alert('Contraseña actualizada');
					window.location = rootUrl+"/logout";
				});
			},
			cancelar: function (evt) {
				evt.preventDefault();
				this.trigger('goto:inicio');
			}
		});
});