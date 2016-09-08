/**
 * Created by JaxKodex on 04/04/2016.
 */
define(['jquery', 'underscore', 'backbone', 'marionette', 'tpl!templates/clientes/DirectorioCliente.html',
        'tpl!templates/clientes/DirectorioClienteChild.html', 'moment'],
    function ($, _, Backbone, Marionette, directorioClienteTemplate, directorioClienteChildTemplate, moment) {
        var childView = Marionette.ItemView.extend({
            tagName: 'tr',
            template: directorioClienteChildTemplate,
            templateHelpers: function () {
                return {
                    index: this.options.index,
                    moment: moment
                }
            },
            events: {
                'click .btn-promo': 'onClickBtnPromo'
            },
            onClickBtnPromo: function (evt) {
                evt.preventDefault();
                var me = this;
                this.model.save({
                    inPromocion: !this.model.get('inPromocion')
                }, {
                    success: function () {
                        me.render();
                    }
                });
            }
        });

        var emptyView = Marionette.ItemView.extend({
            tagName: 'td',
            className: 'text-center',
            template: _.template('<i>No hay resultados para su consulta.</i>'),
            onRender: function () {
                this.$el.prop('colspan', 16);
            }
        });

        return Marionette.CompositeView.extend({
            initialize: function () {
                if (!this.options.filters) {
                    this.options.filters = {
                        page: 0,
                        size: 30
                    };
                }
                if (!this.collection.page) {
                    this.collection.page = {
                        totalPages: 0
                    };
                }
            },
            childView: childView,
            childViewContainer: 'tbody',
            childViewOptions: function (model, index) {
                return {
                    index: index
                };
            },
            emptyView: emptyView,
            template: directorioClienteTemplate,
            templateHelpers: function () {
                var pages, from, to;
                pages = [];
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
                    localCollection: this.options.localCollection,
                    page: this.collection.page,
                    filters: this.options.filters,
                    pages: pages
                }
            },
            events: {
                'click .btn-search': 'onClickBtnSearch',
                'click #navigation-prev': 'onClickNavigationPrev',
                'click #navigation-next': 'onClickNavigationNext',
                'click .navigation-page': 'onClickNavigationPage',
                'click .btn-export': 'onClickBtnExport'
            },
            onClickBtnSearch: function (evt) {
                evt.preventDefault();
                var me = this;

                this.options.filters.page = 0;
                this.buildOptionFilters();

                this.search();
            },
            onClickBtnExport: function (evt) {
                evt.preventDefault()
                var t = $(evt.target);
                var type = t.data('type');
                var queryString = $.param(_.extend({ type: type }, this.options.filters));
                window.open(this.collection.url+'/export?'+queryString);
            },
            onClickNavigationPrev: function (evt) {
                evt.preventDefault();
                if (!this.collection.page.first) {
                    this.options.filters.page = this.options.filters.page -1;
                    this.search();
                }
            },
            onClickNavigationNext: function (evt) {
                evt.preventDefault();
                if (!this.collection.page.last) {
                    this.options.filters.page = this.options.filters.page +1;
                    this.search();
                }
            },
            onClickNavigationPage: function (evt) {
                evt.preventDefault();
                var t = $(evt.target);
                this.options.filters.page = t.data('page');
                this.search();
            },
            search: function () {
                var me = this;
                this.collection.fetch({
                    data: this.options.filters,
                    reset: true,
                    success: function () {
                        me.render();

                        var filterUrl = '';
                        _.each(me.options.filters, function (v, k) {
                            filterUrl += k+':'+v+'/';
                        });

                        Backbone.history.navigate('clientes/'+filterUrl);
                    }
                });
            },
            buildOptionFilters: function () {
                var page = _.has(this.options.filters, 'page') ? this.options.filters.page : 0;
                var size = _.has(this.options.filters, 'size') ? this.options.filters.size : 30;

                this.options.filters = {
                    page: page,
                    size: size
                };

                if (this.$('#nuDocumento').val() != '') {
                    this.options.filters['nuDocumento'] = this.$('#nuDocumento').val();
                }

                if (this.$('#apPersona').val() != '') {
                    this.options.filters['apPersona'] = this.$('#apPersona').val();
                }

                if (this.$('#amPersona').val() != '') {
                    this.options.filters['amPersona'] = this.$('#amPersona').val();
                }

                if (this.$('#noPersona').val() != '') {
                    this.options.filters['noPersona'] = this.$('#noPersona').val();
                }

                if (this.$('#idLocal').val() != 'Todos') {
                    this.options.filters['idLocal'] = this.$('#idLocal').val();
                }

                if (!isNaN(parseInt(this.$('#edadDesde').val()))) {
                    this.options.filters['edadMin'] = this.$('#edadDesde').val();
                }

                if (!isNaN(parseInt(this.$('#edadHasta').val()))) {
                    this.options.filters['edadMax'] = this.$('#edadHasta').val();
                }

                if (this.$('#recibeNoficaciones').val() == 'S') {
                    this.options.filters['inPromocional'] = true;
                } else if (this.$('#recibeNoficaciones').val() == 'N') {
                    this.options.filters['inPromocional'] = false;
                }
            }
        });
    });
