define(['underscore', 'marionette', 'tpl!templates/EncuestaRespuestaList.html', 'tpl!templates/EncuestaRespuestaListItem.html', 'moment'],
    function (_, Marionette, encuestaRespuestaListTemplate, encuestaRespuestaListItemTemplate, moment) {
        var rowView = Marionette.ItemView.extend({
            tagName: 'tr',
            template: encuestaRespuestaListItemTemplate,
            templateHelpers: {
            	moment: moment
            }
//            events: {
//            	'click': 'gotoForm'
//            },
//            gotoForm: function (evt) {
//            	evt.preventDefault();
//            	this.model.collection.trigger('goto:formview', this.model.id);
//            }
        });
        
    	var SinRespuestasView = Marionette.ItemView.extend({
            tagName: 'tr',
    		template: _.template('<td colspan="18" class="text-center"><i>No existen encuestas.</i></td>')
    	});

        return Marionette.CompositeView.extend({
        	initialize: function () {
        		this.request = {
        			desde: $.datepicker.formatDate( "dd/mm/yy", new Date() ),
        			hasta: $.datepicker.formatDate( "dd/mm/yy", new Date() ),
					idLocal: 0
        		};
        	},
            template: encuestaRespuestaListTemplate,
            childViewContainer: 'tbody',
            childView: rowView,
            emptyView: SinRespuestasView,
            templateHelpers: function () {
            	return {
            		encuestaOptions: this.options.plantillaEncuestaCollection.toJSON(),
					localCollection: this.options.localCollection,
            		request: this.request,
            		totalRegistros: this.collection.size()
            	}
            },
            events: {
            	'click #btn-consultar-encuestas': 'consultarEncuestas',
            	'click #btn-export-excel': 'exportExcel',
            	'change input': 'emptyTable',
				'change select': 'emptyTable',
				'change #select_local': 'onChangeSelectLocal'
            },
            emptyTable: function () {
            	this.collection.reset();
            },
			onChangeSelectLocal: function (evt) {
				var me = this;
                this.request.idLocal = this.$('#select_local').val();
				this.options.plantillaEncuestaCollection.fetch({
					data: {
						idLocal: this.request.idLocal
					},
					success: function () {
						me.render();
					}
				});
			},
//            collectionEvents: {
//            	'goto:formview': 'gotoForm'
//            },
            onRender: function () {
            	this.$('.datepicker').datepicker();
            },

            exportExcel: function (evt) {
            	evt.preventDefault();
            	var idPlantillaEncuesta = this.$('#select_encuesta_plantilla').val();
            	var tipoPregunta = this.$('#select_tipo_pregunta').val();
    			var desde = this.$('#fe-desde').val();
    			var hasta = this.$('#fe-hasta').val();
            	this.request = {
            		idEncuesta: idPlantillaEncuesta,
            		coTipoPregunta: tipoPregunta,
            		desde: desde,
            		hasta: hasta,
                    idLocal: this.$('#select_local').val()
            	};
            	window.open(rootUrl+'/reports/export/reportReporteEncuestaResultados?idEncuesta='+idPlantillaEncuesta+'&coTipoPregunta='+tipoPregunta+'&desde='+desde+'&hasta='+hasta+'&type=XLS');
            },

            consultarEncuestas: function (evt) {
            	evt.preventDefault();
            	var idPlantillaEncuesta = this.$('#select_encuesta_plantilla').val();
            	var tipoPregunta = this.$('#select_tipo_pregunta').val();
            	this.request = {
            		idEncuesta: idPlantillaEncuesta,
            		coTipoPregunta: tipoPregunta,
            		desde: this.$('#fe-desde').val(),
            		hasta: this.$('#fe-hasta').val(),
                    idLocal: this.$('#select_local').val()
            	};
            	var me = this;
            	this.collection.fetch({
            		reset: true,
            		silent: true,
            		data: this.request,
            		success: function () {
            			me.render();
            		}
            	});
            },
//            gotoForm: function (id) {
//            	this.trigger('goto:formview', id);
//            }
        });
    });
