define(['underscore', 'marionette', 'tpl!templates/Index.html', 'highcharts','exporting','exportcsv'],
    function (_, Marionette, indexTemplate) {
        var rowView = Marionette.ItemView.extend({
        	className: 'col-sm-6',
            template: _.template('<div class="chart-container"></div>'),
            onRender: function () {
            	var categories = [];
            	var data = [];
            	
            	_.each(this.model.get('respuestas'), function (v) {
            		categories.push(v.plantillaEncuestaRespuestaBean.deRespuesta);
            		data.push(v.cuenta);
            	});
            	this.$('.chart-container').highcharts({
            		chart: {
            			type: 'column'
            		},
            		title: {
            			text: this.model.get('plantillaEncuestaPregunta').dePregunta
            		},
                        
            		xAxis: {
            			categories: categories
            		},
            		yAxis: {
            			min: 0,
            			title: {
            				text: 'Respuestas'
            			}
            		},
            		series: [{
            			name: 'Resultados encuesta',
            			data: data
            		}]
            	});
            }
        });

        return Marionette.CompositeView.extend({
            template: indexTemplate,
            childViewContainer: '.cuadros',
            childView: rowView
        });
    });
