define(['underscore', 'marionette', 'moment', 'tpl!templates/PromocionEnviadaList.html'],
        function (_, Marionette, moment, promocionEnviadaListTemplate) {
            var rowView = Marionette.ItemView.extend({
                initialize: function(options){
	        
                    this.moment = options.moment;
                    this.model = options.model;
                    
                },
                tagName: 'tr',
                template: _.template('<td><%=model.promocion.deTitulo%></td>\
                <td><%=model.cliente.persona.nuDocumento%></td>\
                <td><%=model.cliente.persona.noPersona + " " +  model.cliente.persona.apPersona%></td>\
                        <td><%=model.cliente.persona.deEmail%></td>\
                        <td><%=moment(model.feEnvio).format("DD/MM/YYYY hh:mm:ss a")%></td>\
                        <td><%=_.isNull(model.usuario) ? "" : model.usuario.username %></td>'),
                
                serializeData: function () {
			
			return _.extend({'moment': this.moment, 'model':this.model.toJSON()});
			
		},
            });

            return Marionette.CompositeView.extend({
                initialize: function (options) {
                    if (!this.options.filters) {
                        this.options.filters = {
                            page: 0,
                            size: 30,
                            feInicio: moment(new Date()).format('YYYY-MM-DD'),
                            feFin: moment(new Date()).format('YYYY-MM-DD'),
                            nuDocumento: ''
                        };
                    }
                    if (!this.collection.page) {
                        this.collection.page = {
                            totalPages: 0
                        };
                    }
                    this.idPromocion = options.idPromocion;
                },                
                template: promocionEnviadaListTemplate,
                templateHelpers: function () {
                    var pages, from, to;
                    from = 0;
                    to = this.collection.page.totalPages;
                    if (this.options.filters.page -3 > 0) {
                        from = this.options.filters.page -3;
                    }
                    if (this.options.filters.page +3 < this.collection.page.totalPages) {
                        to = this.options.filters.page +3;
                    }
                    pages = _.range(from, to);
                    return {
                        page: _.extend({}, this.collection.page),
                        filters: this.options.filters,
                        pages: pages
                    };
                },
                childViewContainer: 'tbody',
                childView: rowView,
                events: {
                    'click #regresar': 'regresar',
                    'click #btn-consultar': 'onBuscarClick',
                    'click #navigation-prev': 'onClickNavigationPrev',
                    'click #navigation-next': 'onClickNavigationNext',
                    'click .navigation-page': 'onClickNavigationPage',
                },
                onClickNavigationPrev: function (evt) {
                    evt.preventDefault();
                    if (!this.collection.page.first) {
                        this.options.filters.page = this.options.filters.page - 1;
                        this.buscar();
                    }
                },
                onClickNavigationNext: function (evt) {
                    evt.preventDefault();
                    if (!this.collection.page.last) {
                        this.options.filters.page = this.options.filters.page + 1;
                        this.buscar();
                    }
                },
                onClickNavigationPage: function (evt) {
                    evt.preventDefault();
                    var t = $(evt.target);
                    this.options.filters.page = t.data('page');
                    this.buscar();
                },
                regresar: function () {
                     this.collection.reset();
                     this.trigger('goto:listarPromocion');
                },
                onBuscarClick: function () {
                    this.options.filters.page = 0;
                    this.buscar();
                },
                buscar: function (){
                    var me = this;
                    this.options.filters = _.extend(this.options.filters, {
                        idPromocion: this.idPromocion,
                        feInicio: $('#feDesde').val(),
                        feFin: $('#feHasta').val(),
                        nuDocumento: this.$('#nuDocumento').val()
                    });
                    this.collection.fetch({
                        reset: true,
                        data: this.options.filters,
                        success : function() {
                            me.render();
                        }
                    });
                },
                serializeData: function () {
                    return _.extend({
                        moment: moment
                    });
			    },
                childViewOptions: function(){	 	
                    return{
                            moment: moment
                    }
                }
               
            });
        });
