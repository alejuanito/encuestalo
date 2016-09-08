define(['marionette', 'moment',
        'tpl!templates/PromocionForm.html', 
        'underscore'], function (Marionette,moment, promocionFormTemplate, _) {
	
    return Marionette.ItemView.extend({
            initialize: function (options) {
                    var options = options || {}, me=this;
                    if (typeof options.motivoPromocionCollection != 'undefined') {
                            this.motivoPromocionCollection = options.motivoPromocionCollection;
                    }
                    if (typeof options.tipoPromocionCollection != 'undefined') {
                            this.tipoPromocionCollection = options.tipoPromocionCollection;
                    }if (typeof options.localCollection != 'undefined') {
                            this.localCollection = options.localCollection;
                    }
                    if (typeof options.collection != 'undefined') {
                            this.collection = options.collection;
                    }
                    if (typeof options.model != 'undefined') {
                            this.model = options.model;
                    }
                    if (typeof options.mode != 'undefined') {
                            this.mode = options.mode;
                    }			
                    this.listenTo(this.model, 'change', this.render);
                    this.listenTo(this.model, 'invalid', this.render);


            },

            events: {
                    'click #btn-cancelar': 'cancelar',
                    'click #btn-guardar': 'guardar',
            },
            modelEvents: {
                    'invalid': 'onInvalidModel'
            },

            className: 'col-sm-12',

            onInvalidModel: function (model, errors) {
                    var me = this;
                    _.each(errors, function (val) {
                            me.$('#'+val.attribute).parent().parent().addClass('has-warning');
                    me.$('#'+val.attribute).parent().find('.help-block').text(val.error);
                    });
            },
            serializeData: function () {
                   
                    return _.extend({model:this.model.toJSON(), 'motivoPromocionCollection': this.motivoPromocionCollection,'tipoPromocionCollection': this.tipoPromocionCollection,
                            'localCollection': this.localCollection,'moment':moment});			
            },
            template: promocionFormTemplate,
            cancelar: function (evt) {
                    evt.preventDefault();
                    this.trigger('goto:listarPromocion');			
            },
    guardar: function (evt) {
            evt.preventDefault();			
            var obj;
            var me=this;
            obj = {
                        motivoPromocion: {idMotivoPromocion:this.$('#idMotivoPromocion').val()},
                        tipoPromocion: {idTipoPromocion:this.$('#idTipoPromocion').val()},
                        local: {idLocal:this.$('#idLocal').val()},
                        coPromocion: this.$('#coPromocion').val(),
                        deTitulo: this.$('#deTitulo').val(),
                        deDescripcion: this.$('#deDescripcion').val(),
                        feInicio: moment(this.$('#feInicio').val(),'YYYY-MM-DD').toDate().getTime(),
                        feFin: moment(this.$('#feFin').val(),'YYYY-MM-DD').toDate().getTime(),
                        hrEnvio: this.$('#hrEnvio').val(),
                        
                        noImagen: this.$('#image').val().replace(/C:\\fakepath\\/i, '')
            };
            console.log("inicio: ", this.$('#feInicio').val(), moment(this.$('#feInicio').val()).format('YYYY-MM-DD'));
            console.log("fin: ", this.$('#feFin').val(), moment(this.$('#feFin').val()).format('YYYY-MM-DD'));
            var errores = this.model.validate(obj);
            if (_.isEmpty(errores)) {
               // if (this.mode === 1) { // Creacion
                var formData = new FormData();
                var files = $("#image").prop('files');
                if (!files.length) {
                        return $.Deferred().resolve('');
                }
                formData.append("image", $("#image").prop('files')[0]);   
                if($("#image").prop('files')[0].size>1000000){
                    alert("Tamaño de la imagen supera al máximo 1MB");
                    return;
                }
                me.model.set(obj);
                $.ajax({
                url: rootUrl+'/api/promocion/image',
                type: 'POST',
                data:  formData,
                cache: false,
                contentType: false,
                processData: false
                }).fail(function(xhr, status, error) {
                     var err = eval("(" + xhr.responseText + ")");
                     alert(err.Message);
                }).error(function(xhr, status, error) {
                      var err = eval("(" + xhr.responseText + ")");
                      alert(err.Message);
                }).
                done(function(xhr, status, error){
                    console.log("imagen grabada", xhr, status );  
                    
                   
                    
                    me.model.save({att1 : "value"}, 
                    {success : function () {
                                alert('El registro fue realizado correctamente');
                                console.log("success");
                                 me.trigger('goto:listarPromocion');
                     }, error: function () {
                                console.log("error");
                                alert('Ocurrió un problema al realizar el registro');
                     },});
                    
//                            success: function () {
//                                    alert('El registro fue realizado correctamente');
//                                    console.log("success");
//                                    Backbone.history.navigate('listarPromocion', {trigger: true});
//                            },
//                            error: function () {
//                                console.log("error");
//                                alert('Ocurrió un problema al realizar el registro');
//                            },
//                            done: function(){
//                                console.log("done");
//                                alert('Ocurrió un problema al realizar el registro');
//                            },
//                            
//                    }); 
                   
                   // Backbone.history.navigate('listarPromocion', {trigger: true});
               }); 

            }else{
                this.onInvalidModel(null, errores);
            }


    }
    });
});