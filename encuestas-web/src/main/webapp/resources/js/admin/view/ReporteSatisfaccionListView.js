define(['underscore', 'marionette', 'moment', 'tpl!templates/ReporteSatisfaccionList.html',
    'tpl!templates/ReporteSatisfaccionItemList.html'],
        function (_, Marionette, moment, reporteSatisfaccionListTemplate,
        reporteSatisfaccionItemListTemplate) {
        
        var rowView = Marionette.ItemView.extend({
            initialize: function(options){
                console.log("Model: ", this.model);
	        this.request = {
                           localCollection: options.localCollection,
                           model:this.model,
                           
                           
                };
                           
                console.log("template ida: ", this.request);
	    },
            tagName: 'div',
            template: reporteSatisfaccionItemListTemplate,
            templateHelpers: function () {
                console.log("esto trae: ", this.request);
                    return {
                            request: this.request
                    }
            },
           
            events: {
            	
            },
             
            dibujar:function(dataReporte){
                console.log("Data para reporte", dataReporte.toJSON())
                
                
		
		var me=this,classImagen='.img-reporte-'+dataReporte.toJSON().NU_PREGUNTA;
                console.log("classImagen", classImagen);
                console.log("div", $(classImagen));
                $(classImagen).highcharts({
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: dataReporte.toJSON().DE_PREGUNTA 
                    },
                    subtitle: {
                        text: dataReporte.toJSON().NO_LOCAL + " Del " + dataReporte.toJSON().FE_DESDE + " hasta " + dataReporte.toJSON().FE_HASTA  
                    },
                    xAxis: {
                        type: 'category',
                        labels: {
                            rotation: -45,
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif'
                            }
                        }
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Encuestas'
                        }
                    },
                    legend: {
                        enabled: false
                    },
                    tooltip: {
                        pointFormat: 'Opiniones: <b>{point.y:.0f} </b>'
                    },			        
                    series: [{
                        name: 'Brands',
                        colorByPoint: true,
                        data:[{
                                name: 'Muy Malo',
                                y: dataReporte.toJSON().MUY_MALO,
                                color:'#d9534f',
                                drilldown: 'Muy Malo'
                            }, {
                                name: 'Malo',
                                y: dataReporte.toJSON().MALO,
                                color:'#f0ad4e',
                                drilldown: 'Malo'
                            }, {
                                name: 'Regular',
                                y: dataReporte.toJSON().REGULAR,
                                color:'#777',
                                drilldown: 'Regular'
                            }, {
                                name: 'Bueno',
                                y: dataReporte.toJSON().BUENO,
                                color:'#337ab7',
                                drilldown: 'Bueno'
                            }, {
                                name: 'Muy Buena',
                                y: dataReporte.toJSON().MUY_BUENO,
                                color:'#5cb85c',
                                drilldown: 'Muy Buena'
                            }],
                        dataLabels: {
                            enabled: true,
                            rotation: 0,
                            color: '#FFFFFF',
                            align: 'right',
                            x: 4,
                            y: 10,
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif',
                                textShadow: '0 0 3px black'
                            } }
                    }]
                       });
		
		
		
            },
           
            onShow:function(){
                this.dibujar(this.model);
            }
                    
        });
        
        
        return Marionette.CompositeView.extend({
            template: reporteSatisfaccionListTemplate,
            childViewContainer: '#detalle-repo',
            childView: rowView,
            initialize: function (options) {
                
                this.request = {
                    localCollection: options.localCollection ,
                    moment:moment
                    
                };
            },
            childViewOptions: function(){	 	
	        return{
	        	localCollection: this.request.localCollection,
                        
	        }
            },
             serializeData: function () {			
			return _.extend({'moment': moment, 'localCollection': this.request.localCollection});			
		},
            events: {
                'click #btn-consultar': 'buscarReporte',
                'change #idLocal': 'buscarPregunta'
            },
             buscarPregunta: function (evt){
                evt.preventDefault();	
                $('#idPregunta').empty();
                // $('#idPregunta').append('<option value=-1>Seleccione</option>');
                var url = rootUrl+'/api/preguntasReporte', data, preguntas;
                data = {idLocal: $('#idLocal').val()};
                    $.get(url, data).success(function (response, opts) {
                        console.log("Preguntas", response);
                        preguntas=response;
                        if(preguntas.length>0){
                            $('#idPregunta').append('<option selected value=0>TODOS</option>');
                        }
                        
                        _.each(preguntas, function (value, key) {
                            $('#idPregunta').append($('<option>', { 
                                value: value.idPlantillaEncuestaDetalle,
                                text : ($('#idLocal').val()*1===0)?  value.dePregunta + " - ("+value.plantillaEncuesta.local.coLocal+")" : value.dePregunta
                            }));
                        });
                    
                });	
                },
            buscarReporte: function (evt){
                evt.preventDefault();	
                var url = rootUrl+'/api/reporteSatisfaccion', data, me=this, filtro;
                data = {idLocal: $('#idLocal').val(),idPregunta: $('#idPregunta').val(),
                    desde: $('#feDesde').val(),hasta: $('#feHasta').val()};
                $.get(url, data).success(function (response, opts) {
                        console.log("Data consultada", response);
                        me.collection= new Backbone.Collection(response);
                        
                        filtro = "Local: ".concat($('#idLocal option:selected').text()).concat(", Pregunta: ").
                                concat($('#idPregunta option:selected').text()).
                                concat(", Desde: ").concat($('#feDesde').val()).
                                concat(", Hasta: ").concat($('#feHasta').val());
                        
                        me.render();
                        $('#text-filtro').text(filtro);
                });	
            },
            collectionEvents: {
            	//'goto:editarUsuario': 'editarUsuario'
            },
        });

        });
