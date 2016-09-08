define(['marionette', 
        'tpl!templates/EncuestaForm.html', 
        'tpl!templates/EncuestaPreguntaElement.html',
        'underscore'], function (Marionette, encuestaFormTemplate, encuestaPreguntaElement, _) {
	var PreguntaView = Marionette.ItemView.extend({
		className: 'row encuesta-edit-pregunta',
        template: encuestaPreguntaElement,
        onRender: function () {
        	if (this.model.isNew()) {
        		this.$el.addClass('edit');
        	}
        	if (this.options.childIndex % 2) {
        		this.$el.addClass('background-par-lista');
        	}
        },
        onDomRefresh: function () {
        	this.$('.dePregunta').focus();
        },
        events: {
        	'click .btn-editar': 'editar',
        	'click .btn-guardar': 'guardar',
        	'click .btn-cancelar': 'cancelar',
        	'click .btn-eliminar': 'eliminar'
        },
        templateHelpers: function () {
        	var helpers = {
        			muymalo: false,
        			malo: false,
        			regular: false,
        			bueno: false,
        			muybueno: false
        	};
        	_.each(this.model.get('plantillaEncuestaRespuestas'), function (obj) {
        		if (obj.esPlantillaEncuestaRespuesta == 'A') {
        			helpers[obj.noImg.substr(0, obj.noImg.length-4)] = true;
        		}
        	});
        	return helpers;
        },
        buildDataObject: function () {
        	var obj = {
        			dePregunta: this.$('.dePregunta').val(),
        			nuOrden: this.$('.nuOrden').val(),
        			inEsRptaCorta: this.$('.inEsRptaCorta').prop('checked'),
        			plantillaEncuesta: this.options.plantillaEncuesta.toJSON(),
        			estado: this.$('.estado').prop('checked') ? 'A' : 'I',
        			plantillaEncuestaRespuestas: []
        	};
        	if (obj.inEsRptaCorta) {
        		if (this.$('.muymalo').prop('checked')) {
        			obj.plantillaEncuestaRespuestas.push({
        				noImg: 'muymalo.png',
        				nuOrden: 1,
        				deRespuesta: 'MUY MALO'
        			});
        		}
        		if (this.$('.malo').prop('checked')) {
        			obj.plantillaEncuestaRespuestas.push({
        				noImg: 'malo.png',
        				nuOrden: 2,
        				deRespuesta: 'MALO'
        			});
        		}
        		if (this.$('.regular').prop('checked')) {
        			obj.plantillaEncuestaRespuestas.push({
        				noImg: 'regular.png',
        				nuOrden: 3,
        				deRespuesta: 'REGULAR'
        			});
        		}
        		if (this.$('.bueno').prop('checked')) {
        			obj.plantillaEncuestaRespuestas.push({
        				noImg: 'bueno.png',
        				nuOrden: 4,
        				deRespuesta: 'BUENO'
        			});
        		}
        		if (this.$('.muybueno').prop('checked')) {
        			obj.plantillaEncuestaRespuestas.push({
        				noImg: 'muybueno.png',
        				nuOrden: 5,
        				deRespuesta: 'MUY BUENO'
        			});
        		}
        	}
        	return obj;
        },
        editar: function (evt) {
        	evt.preventDefault();
        	this.$el.addClass('edit');
        },
        guardar: function (evt) {
        	evt.preventDefault();
        	var me = this;
        	if (this.options.plantillaEncuesta.isNew()) {
        		alert('Guardar primero la encuesta!!');
        		return;
        	}
        	this.model.save(this.buildDataObject(), {
        		success: function () {
        			me.$el.removeClass('edit');
        			me.render();
        		}
        	});
        },
        cancelar: function (evt) {
        	evt.preventDefault();
        	var me = this;
        	if (this.model.isNew()) {
        		this.model.destroy();
        	} else {
        		this.$el.removeClass('edit');
        		this.model.fetch({
        			success: function () {
        				me.render();
        			}
        		});
        	}
        },
        eliminar: function (evt) {
        	evt.preventDefault();
        	this.model.destroy({
        		wait: true
        	});
        }
	});
	
	var SinPreguntasView = Marionette.ItemView.extend({
		className: 'text-center text-muted',
		template: _.template('<i>No hay preguntas.</i>')
	});
	
    return Marionette.CompositeView.extend({
        template: encuestaFormTemplate,
        childViewContainer: '#preguntas-container',
        childView: PreguntaView,
        emptyView: SinPreguntasView,
        childViewOptions: function (model, index) {
        	return {
        		childIndex: index,
        		plantillaEncuesta: this.model
        	};
        },
        templateHelpers: function () {
        	return {
    			localCollection: this.options.localCollection
        	};
        },
        onRender: function () {
        	var me = this;
        	if (this.model.isNew()) {
        		this.$el.addClass('new');
        	}
        	_.defer(function () {
        		me.$('#de-encuesta-corta').focus();
        	});
        },
        events: {
            submit: 'evitarSubmit',
            'click #btn-guardar': 'guardar',
            'click #btn-cancelar': 'cancelar',
            'click #btn-agregar-pregunta': 'agregarPregunta'
        },
        modelEvents: {
        	'invalid': 'onInvalidModel'
        },
        onInvalidModel: function (model, error, options) {
        	var me = this;
        	_.each(error, function (v) {
        		console.log(me.$('.'+v.attribute));
        		me.$('.'+v.attribute).parent().parent().addClass('has-warning');
        		me.$('.'+v.attribute).parent().find('.help-block').text(v.error);
        	});
        },
        evitarSubmit: function (evt) {
        	evt.preventDefault();
        },
        cancelar: function () {
        	this.trigger('goto:listarEncuesta');
        },
        guardar: function (evt) {
            evt.preventDefault();
            var obj, me;
            me = this;
            obj = {
                deEncuestaCorto: this.$('#de-encuesta-corta').val(),
                deEncuestaLargo: this.$('#de-encuesta-largo').val(),
                esPlantillaEncuesta: this.$('#esPlantillaEncuesta').prop('checked') ? 'A' : 'I',
                local: {
                    idLocal: this.$('#id-local').val()
                }
            };
            
            // clear error styles
            this.$('.form-group').removeClass('has-warning');
            this.$('.form-group .help-block').text('');
            
            this.model.save(obj, {
            	success: function () {
            		me.$el.removeClass('new');
            		me.render();
            		alert('Registro exitoso.');
            		me.trigger('goto:listarEncuesta');
            	}
            });
        },
        agregarPregunta: function (evt) {
        	evt.preventDefault();
        	this.collection.add({});
        }
    });
});