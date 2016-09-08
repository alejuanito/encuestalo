define(['underscore', 'marionette', 'tpl!templates/RolForm.html'],
    function (_, Marionette, rolFormTemplate) {
	    var itemView = Marionette.ItemView.extend({
	        template: _.template('<label><input id="opcion-<%=codigo%>" type="checkbox" /> <%=nombre%></label>'),
	        className: 'col-sm-6'
	    });

        return Marionette.CompositeView.extend({
            template: rolFormTemplate,
            events: {
            	'click #btn-cancelar': 'goBackToRolList',
            	'click #btn-guardar': 'save'
            },
            childViewContainer: '#opcion-container',
            childView: itemView,
            goBackToRolList: function () {
            	this.trigger('goto:listarRol');
            },
            onRender: function () {
            	var me = this;
            	var opciones = this.model.get('rolOpciones');
            	_.each(opciones, function (val) {
            		me.$('#opcion-'+val.opcion.codigo).prop('checked', true);
            	});;
            	_.defer(function () {
            		me.$('#nombre').focus();
            	});
            },
            save: function () {
            	var opciones, me, nuevasOpciones, rolOpciones;
            	me = this;
            	this.model.set('nombre', this.$('#nombre').val());
            	this.model.set('estado', this.$('#estado').prop('checked') ? 'A' : 'I');
            	opciones = this.model.get('rolOpciones');
            	nuevasOpciones = {};
//            	_.each(opciones, function (val) {
//            		if (me.$('#opcion-'+val.opcion.codigo).prop('checked')) {
//            			nuevasOpciones[val.opcion.codigo] = val;
//            		}
//            	});
            	this.collection.each(function (val) {
            		console.log(me.$('#opcion-'+val.get('codigo')).prop('checked'));
            		if (me.$('#opcion-'+val.get('codigo')).prop('checked')) {
//            			if (_.isUndefined(nuevasOpciones[val.codigo])) {
            				nuevasOpciones[val.get('codigo')] = {
            						coOpcion: val.get('codigo'),
            						idRol: me.model.get('idRol'),
            						rol: { idRol: me.model.get('idRol') },
            						opcion: val.toJSON()
            				};
//            			}
            		}
            	});
            	rolOpciones = [];
            	for (var o in nuevasOpciones) {
            		rolOpciones.push(nuevasOpciones[o]);
            	}
            	console.log(rolOpciones);
            	this.model.set('rolOpciones', rolOpciones);
            	console.log(this.model.toJSON());
            	this.model.save({}, {
            		success: function () {
            			alert('Rol registrado.');
            			me.trigger('goto:listarRol');
            		}
            	});
            }
        });
    });
