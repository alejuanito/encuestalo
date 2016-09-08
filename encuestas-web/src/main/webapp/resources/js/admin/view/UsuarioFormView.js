define(['underscore', 'marionette', 'tpl!templates/UsuarioForm.html'],
    function (_, Marionette, usuarioFormTemplate) {
	    var itemView = Marionette.ItemView.extend({
	        template: _.template('<label><input id="rol-<%=idRol%>" type="checkbox" /> <%=nombre%></label>'),
	        className: 'col-sm-6'
	    });

        return Marionette.CompositeView.extend({
            template: usuarioFormTemplate,
            events: {
            	'click #btn-cancelar': 'goBackToUsuarioList',
            	'click #btn-guardar': 'save'
            },
            childViewContainer: '#rol-container',
            childView: itemView,
            goBackToUsuarioList: function () {
            	this.trigger('goto:listarUsuario');
            },
            templateHelpers: function () {
            	return {
            		isNew: this.model.isNew(),
            		tipoDocumentoData: tipoDocumentoData,
            		cargoColaboradorData: this.options.cargoColaboradorCollection.toJSON(),
            		localCollection: this.options.localCollection
            	};
            },
            onRender: function () {
            	var me = this;
            	var roles = this.model.get('usuarioRols');
            	_.each(roles, function (val) {
            		me.$('#rol-'+val.rol.idRol).prop('checked', true);
            	});
            	_.defer(function () {
            		me.$('#nombre').focus();
            	});
            },
            save: function () {
            	var persona = {}, me = this, usuarioRols = [];
            	persona.noPersona = this.$('#nombre').val();
            	persona.amPersona = this.$('#amPersona').val();
            	persona.apPersona = this.$('#apPersona').val();
            	persona.tipoDocumento = {
            			coTipoDocumento: this.$('#tipoDocumento').val()
            	};
            	persona.esPersona = 'A';
            	persona.nuDocumento = this.$('#nuDocumento').val();

            	this.model.set('estado', this.$('#esUsuario').prop('checked') ? 'A' : 'I');
//            	this.model.set('inAdmin', this.$('#esAdmin').prop('checked'));
            	this.model.set('inAdmin', true);
            	this.model.set('username', this.$('#noUsuario').val());
            	
            	this.model.set('persona', persona);
            	
            	this.model.set('colaborador', {
            		local: {
            			idLocal: this.$('#idLocal').val()
            		}
            	});
            	
            	this.collection.each(function (val) {
            		if (me.$('#rol-'+val.get('idRol')).prop('checked')) {
            			usuarioRols.push({
            				usuario: me.model.toJSON(),
            				rol: val.toJSON(),
            				idRol: val.get('idRol'),
            				idUsuario: me.model.get('idUsuario')
            			});
            		}
            	});
            	
            	this.model.set('usuarioRols', usuarioRols);
            	
            	if (this.model.isNew() && this.$('#password').val().trim() == this.$('#repassword').val().trim()
            			&& !_.isEmpty(this.$('#password').val().trim())) {
            		this.model.set('password', this.$('#password').val());
            	} else if (this.model.isNew()) {
            		alert('Las contraseñas deben coincidir.');
            		return;
            	}
            	this.model.save({}, {
            		success: function () {
            			alert('Registro exitoso.');
            			me.goBackToUsuarioList();
            		},
					error: function (model, response, options) {
						var r = response.responseJSON;
						if (_.has(r, 'error')) {
							alert(r.error);
						} else if (_.has(r, 'errors')) {
							var msj = 'Por favor verifique los siguientes campos.';
							_.each(r.errors, function (error) {
								msj += error.error+'\n';
							});
							alert(msj);
						}
					},
            		headers: {
            			coCargoColaborador: this.$('#cargoColaborador').val()
            		}
            	});
            }
        });
    });
