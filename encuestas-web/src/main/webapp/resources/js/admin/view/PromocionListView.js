define(['underscore', 'marionette', 'moment', 'tpl!templates/PromocionList.html','tpl!templates/PromocionItemList.html'],
        function (_, Marionette, moment, promocionListTemplate,promocionItemListTemplate) {
            var rowView = Marionette.ItemView.extend({
                initialize: function(options){
	        
                    this.moment = options.moment;
                    this.model = options.model;
                   
                },
                tagName: 'tr',
                template: promocionItemListTemplate,
                
                events: {
                    'click #desactivar': 'desactivarPromocion'
                },
                serializeData: function () {
			
			return _.extend({'moment': this.moment, 'model':this.model.toJSON()});
			
		},
                desactivarPromocion: function () {
                    console.log("modelo", this.model.get('idPromocion'));
                    //var url, data;
                    //url = rootUrl+'/api/promocion/desactivar/'+this.model.get('idPromocion');
                   // data = {idPromocion:this.model.idPromocion};
                    
                    $.ajax({
                        url: rootUrl+'/api/promocion/desactivar/'+this.model.get('idPromocion'),
                        type: 'PUT',
                        success: function(result) {
                            console.log("actualizado");
                            // Do something with the result
                        }
                    });
                }
            });

            return Marionette.CompositeView.extend({
                initialize: function (options) {
                    console.log("coleccion recibida", this.collection.length)
                },
                template: promocionListTemplate,
                childViewContainer: 'tbody',
                childView: rowView,
                
                
                events: {
                    'click #nueva-promocion': 'nuevaPromocion'
                },
                collectionEvents: {
                    'goto:editarPromocion': 'editarPromocion'
                },
                nuevaPromocion: function () {
                    
                    this.trigger('goto:nuevaPromocion');
                },
                editarPromocion: function (id) {
                    this.trigger('goto:editarPromocion', id);
                },               
                childViewOptions: function(){	 	
                    return{
                            moment: moment
                    }
                }
            });
        });
