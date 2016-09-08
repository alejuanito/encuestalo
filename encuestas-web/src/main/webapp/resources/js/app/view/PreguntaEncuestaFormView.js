define(['marionette','moment',
    'tpl!templates/html/pregunta-encuesta-form.tpl',
    'collection/PreguntaCollection', 'collection/RespuestaCollection', 'collection/RespuestaEncuestaCollection',
    'model/PreguntaModel', 'model/RespuestaModel', 'model/RespuestaEncuestaModel'], function (Marionette,moment,
        PreguntasEncuestaFormTemplate,
        PreguntaCollection, RespuestaCollection, RespuestaEncuestaCollection,
        PreguntaModel, RespuestaModel, RespuestaEncuestaModel
        ) {
    var respuestaEncuestaCollection = new RespuestaEncuestaCollection;
    //var preguntasShow = new PreguntaCollection;
    return Marionette.LayoutView.extend({
        initialize: function (options) {
            var options = options || {}, me = this;
            console.log("mostrara preguntas")
            if (typeof options.preguntacollection != 'undefined') {
                this.nuPregunta = 1;
                this.preguntacollection = options.preguntacollection;
                
            }
            if (typeof options.atencionModel != 'undefined') {
                this.atencionModel = options.atencionModel;
            }
            
            if (typeof options.respuestaCollection != 'undefined') {
                this.respuestaCollection = options.respuestaCollection;
            }
            this.atencionModel.set({nuPreguntaRespondida:0, nuTotal:this.preguntacollection.length});
            this.idAtencion = localStorage.getItem("idAtencion");
            this.preguntasShow = new PreguntaCollection;
            this.getPreguntasShow();

        },
        template: PreguntasEncuestaFormTemplate,
        serializeData: function () {
        	var respuestas = new Backbone.Collection(this.respuestaCollection.filter(function (obj) { return obj.get('esPlantillaEncuestaRespuesta') == 'A'; }));
            return _.extend({'preguntaCollection': this.preguntasShow, 'respuestaCollection': respuestas, 'atencionModel': this.atencionModel, 
                'moment': moment});

        },
        getPreguntasShow: function (tipo, save) {
            //var preguntaShowCollection = new PreguntaCollection();
            var  me=this;
            var nuInput = this.$('input').length,nuShow = 3;
            var preguntaAnterior = this.preguntacollection.at(this.nuPregunta - nuInput - 1);
            //var preguntaActual = this.preguntacollection.at(this.nuPregunta);
            if(tipo === 'siguiente'){
               // me.respuestaCollection.reset();
                this.nuPregunta++;
            }else if(tipo === 'anterior'){                
                
                if(save){
                    this.nuPregunta = 1;                    
                }else{
                    if(preguntaAnterior.get('coTipoPregunta')=== "ABIE"){// Solo si la pregunta anterior es abierta
                        if(nuInput>0){ //Pregunta abierta Debo retroceder la cantidad de inputs que se muestran en pantalla
                            this.nuPregunta = this.nuPregunta - nuInput -2  ;
                        }
                    }                    
                    else if(preguntaAnterior.get('coTipoPregunta')=== "CERR" && nuInput>0 ){
                        this.nuPregunta = this.nuPregunta - nuInput   ;
                    } 
                    else{
                            this.nuPregunta--;    
                    } 
                }   
                //me.respuestaCollection.reset();
            }
            var   totalPreguntas = this.preguntacollection.length;
            if (totalPreguntas > 0 && totalPreguntas > this.nuPregunta - 1 && this.nuPregunta>0) {
                this.preguntasShow.reset();
                if (this.preguntacollection.at(this.nuPregunta - 1).get('coTipoPregunta') === "CERR") {
                    this.preguntasShow.add(this.preguntacollection.at(this.nuPregunta - 1));
                    
                    var url, data;
                    url = rootUrl + '/api/respuestas';
                    data = {idPregunta: this.preguntasShow.at(0).toJSON().idPlantillaEncuestaDetalle};
                    $.get(url, data).success(function (response, opts) {
                        me.respuestaCollection = new RespuestaCollection(response);
                        me.respuestaCollection = new RespuestaCollection(me.respuestaCollection.filter(function (obj) { return obj.get('esPlantillaEncuestaRespuesta') == 'A'; }));
                        console.log("Opciones a mostrar: ", me.respuestaCollection);
                        me.render();
                        me.$('#deRespuesta').focus();
                    });
                } else {
                    var i = 0;
                    //, next = (this.nuPregunta - 1) + i;
                    while (i < nuShow && (this.nuPregunta <= totalPreguntas)) {
                        console.log("agregando una pregunta multiple" , this.nuPregunta);
                        this.preguntasShow.add(this.preguntacollection.at(this.nuPregunta - 1));
                        this.nuPregunta++;
                        i++;
                    }
                    this.nuPregunta--;
                    me.render();
                    me.$('#deRespuesta').focus();
                }
                
               // return this.preguntasShow;
            } else {
                alert("No existen más preguntas, solo se muestrán las preguntas que no han sido respondidas.");
                if(tipo === 'siguiente'){
                                this.nuPregunta--;
                }else if(tipo === 'anterior'){                
                    if(save){
                          this.nuPregunta = 0;                        
                    }else{
                      if(preguntaAnterior.get('coTipoPregunta')=== "ABIE"){// Solo si la pregunta anterior es abierta
                            if(nuInput>0){ //Pregunta abierta Debo retroceder la cantidad de inputs que se muestran en pantalla
                                this.nuPregunta = this.nuPregunta + nuInput +2  ;
                            }
                        }                    
                        else if(preguntaAnterior.get('coTipoPregunta')=== "CERR" && nuInput>0 ){
                            this.nuPregunta = this.nuPregunta + nuInput   ;
                        } 
                        else{
                                this.nuPregunta++;    
                        } 
                    }                    
                }
            }
           

        },
        events: {
            'click #siguiente': 'siguientePregunta',
            'click #cancelar': 'cancelarEncuesta',
            'click #anterior': 'anteriorPregunta',
            'click .respuesta': 'guardarRespuestaCerrada',
            'click #guardar-abierta': 'guardarRespuestaAbierta'
        },
        modelEvents: {
            'invalid': 'onInvalidModel',
            'change': 'render'
        },
        collectionEvents: {
            "change": 'render'
        },
        reiniciarEncuesta: function (evt) {
            evt.preventDefault();
        },
        siguientePregunta: function (evt) {
            evt.preventDefault();
            var me = this;
            //this.nuPregunta++;
            this.getPreguntasShow('siguiente', false);
        },
        anteriorPregunta: function (evt) {
            evt.preventDefault();
            var me = this;
            //this.nuPregunta--;
            this.getPreguntasShow('anterior', false);
          
        },
        guardarRespuestaAbierta: function (evt) {
            evt.preventDefault();
            var me = this, i=0;
            this.$('input').each(function(){                 
               
                var respuestaEncuestaModel = new RespuestaEncuestaModel();
                obj = {
                    deRespuesta: me.$(this).val(),
                    plantillaEncuestaPregunta: {
                        idPlantillaEncuestaDetalle: me.preguntasShow.at(i).get('idPlantillaEncuestaDetalle'),
                        coTipoPregunta: me.preguntasShow.at(i).get('coTipoPregunta')
                    },
                    plantillaEncuestaRespuesta: null,
                    encuesta: {
                        atencion: {
                            idAtencion: me.idAtencion
                            
                        },
                        local:{
                            idLocal: userData.idLocal
                        }
                    },
                    dePregunta:me.preguntasShow.at(i).get('dePregunta')
                };
                respuestaEncuestaModel.set(obj);
                
                respuestaEncuestaCollection.add(respuestaEncuestaModel);
                me.preguntacollection.remove(me.preguntasShow.at(i));
                i++;
                me.nuPregunta--;
            });
            this.atencionModel.set({nuPreguntaRespondida:this.atencionModel.toJSON().nuPreguntaRespondida+i});
           //this.$('input').remove();
            if (this.preguntacollection.length>0) {
                console.log("NuPregunta abierta: ", this.nuPregunta , "preguntas abierta: ", this.preguntacollection)
                if (this.nuPregunta === this.preguntacollection.length) {
                    console.log("mostrando anterior pregunta");
                    //this.nuPregunta = 0;
                    this.getPreguntasShow('anterior', true);

                } else {
                   console.log("mostrando siguiente pregunta");
                   
                    this.getPreguntasShow('siguiente', true);
                    //me.siguientePregunta(evt, true);
                }                       
            } else {
                console.log("Encuesta completa: ", respuestaEncuestaCollection);
                if (confirm("¿Deseas grabar la encuesta?")) {
                    Backbone.sync("create", respuestaEncuestaCollection, {
                        success: function (response) {
                            respuestaEncuestaCollection = new RespuestaEncuestaCollection;
                            localStorage.setItem("idEncuesta", response.idEncuesta);
                            console.log("Respuestas Grabadas, response: ",response );
                            me.trigger('go:showdatosencuestado');
                        },
                        error: function () {
                            respuestaEncuestaCollection = new RespuestaEncuestaCollection;
                            console.log("Respuestas Grabadas");
                            me.trigger('go:showdatosencuestado');
                        }
                    });
                } else {
                    window.location.reload();
                    me.trigger('go:showconfiguracionatencion');
                    //Se reinicia la encuesta
                }
            }
               // }
            console.log("Respuestas que se guardan", respuestaEncuestaCollection)
            
        },
        
        cancelarEncuesta: function (evt) {
            evt.preventDefault();
            var me = this;
            window.location.reload();
            me.trigger('go:showconfiguracionatencion');
        },
        guardarRespuestaCerrada: function (evt) {
            evt.preventDefault();
            var me = this;
            var respuestaEncuestaModel = new RespuestaEncuestaModel();
            obj = {
                //plantillaEncuestaRespuesta: {
                    idRespuesta: evt.currentTarget.getAttribute('data-idrespuesta'),
                //},
                plantillaEncuestaPregunta: {
                    idPlantillaEncuestaDetalle: this.preguntasShow.at(0).get('idPlantillaEncuestaDetalle')
                },
                encuesta: {
                    atencion: {
                        idAtencion: this.idAtencion
                    },
                    local:{
                            idLocal: userData.idLocal
                    }
                },
                dePregunta:this.preguntasShow.at(0).get('dePregunta'),
                deRespuestaCorta:evt.currentTarget.getAttribute('data-deRespuesta')
            };
            console.log("Pregunta show", this.preguntasShow.at(0))
            respuestaEncuestaModel.set(obj);
            respuestaEncuestaCollection.add(respuestaEncuestaModel);
            this.atencionModel.set({nuPreguntaRespondida:this.atencionModel.toJSON().nuPreguntaRespondida+1});
            this.preguntacollection.remove(this.preguntasShow.at(0));
            //console.log("preguntas faltantes: ", this.preguntacollection.toJSON());
            if (this.preguntacollection.length>0) {
                console.log("NuPregunta: ", this.nuPregunta , "preguntas: ", this.preguntacollection)
                if (this.nuPregunta === this.preguntacollection.length) {
                    this.nuPregunta++;
                    this.getPreguntasShow('anterior', true);                    
                } else {
                    this.nuPregunta--;
                    this.getPreguntasShow('siguiente', true);
                }
            } else {
                console.log("Encuesta completa");
//                this.preguntaModel.set({nuPreguntaRespondida: this.nuPreguntaRespondida = this.nuPreguntaRespondida + 1, nuTotal: this.preguntacollection.length});
//                me.render();
                if (confirm("¿Desea grabar la encuesta?")) {
                    Backbone.sync("create", respuestaEncuestaCollection, {
                        success: function (response) {
                            respuestaEncuestaCollection = new RespuestaEncuestaCollection;
                            console.log("Respuestas grabadas correctamente. response:", response);
                            localStorage.setItem("idEncuesta", response.idEncuesta);
                            me.trigger('go:showdatosencuestado');
                        },
                        error: function () {
                            respuestaEncuestaCollection = new RespuestaEncuestaCollection;
                            alert("Respuestas grabadas correctamente.")
                            me.trigger('go:showdatosencuestado');
                        }
                    });

                } else {
                    window.location.reload();
                    me.trigger('go:showconfiguracionatencion');
                    //Se reinicia la encuesta
                }
            }



        },
        grabarRespuestas: function (evt) {
            evt.preventDefault();

        },
        onInvalidModel: function (model, errors) {
            this.$('.form-group').removeClass('has-warning');
            this.$('.help-block').remove();
            _.each(errors, function (val) {
                var parentEl = this.$('#' + val.attribute).parent();
                parentEl.addClass('has-warning');
                parentEl.append($('<div>').addClass('help-block').text(val.error));
            });
        },
    });

});