
<!--
	<div id="top-header">
        <div id="usuario" class="user-data"><span class="glyphicon glyphicon-user"><%=userData.username%></span>&nbsp&nbsp<span class="glyphicon glyphicon-shopping-cart"><%=userData.local%></span>&nbsp&nbsp<a href="<%=rootUrl%>/logout"><span class="glyphicon glyphicon-log-out">Salir</span></a></div>
        <div id="fecha" class="user-data"><%=moment().format('MMMM Do YYYY')%></div> 
    </div>-->
    
<div class ="row" >
    <div class="col-sm-12">
        <div id="cancelar"><img src="resources/img/cancelar.png" /></div>
        <div class="col-sm-12">
            <div class="col-sm-2">
                <img class="img-responsive" src="resources/img/logoPiombino02.png"/>
            </div>
            <div class="col-sm-8">
                <div class="row">
                    <div class="text-center"><h3><%= _.isUndefined(preguntaCollection.at(0)) ? 'Encuesta' : preguntaCollection.at(0).toJSON().plantillaEncuesta.deEncuestaCorto %></h3></div>
                </div>
                <div class="row">
                    <div class="col-sm-4 text-right">
                        Zona: <%=atencionModel.toJSON().area.deArea%>
                    </div>
                    <div class="col-sm-4 text-center">
                        Mesa: <%=atencionModel.toJSON().nuMesa%>
                    </div>
                    <div class="col-sm-4 text-left">
                        Mozo: <%=atencionModel.toJSON().colaborador.persona.noPersona %>
                    </div>
                </div>
            </div>
           
        </div>
    	<div  class="col-sm-12" id="cuadradocrema" style="vertical-align:middle; position: relative;">
                    	<div id="opcion" class="contenido">
                                <% var i = 1%>
                                 <% _.each(preguntaCollection.toJSON(), function (value) { %>
<!--<<<<<< HEAD -->
                                         <div class="text-center"><h1><%=value.dePregunta %></h1></div>
                                         <!--div class="pregunta"><h1><%=value.dePregunta %></h1></div-->
                                        <% if(value.coTipoPregunta == "CERR") { %>
                                            <div class="text-center">
<!--=======-->
<!-- >>>>>>> e6f6e08e6774c897863b05d222027173a9bca735 -->
                                            <% _.each(respuestaCollection.toJSON(), function (value) { %>
                                                    <img class="imagen respuesta" style="padding: 0px 30px 0px 30px;" data-deRespuesta="<%=value.deRespuesta%>" data-idRespuesta="<%=value.idRespuesta%>" src="resources/img/<%=value.noImg%>"/>
                                            <% }) %>
                                            </div>
                                        <% } else {%>
                                                <div class="row">
                                                <div class="col-sm-offset-4 col-sm-4">
                                                        <input type="text" class="form-control"  id="deRespuesta-<%=i%>" autofocus>
                                                        <span class="help-block"></span>
                                                        <%if(i===preguntaCollection.length){  %>
                                                        <img id="guardar-abierta" src="resources/img/guardar.png" />
                                                        <%} i++;%>
                                                </div>
                                                </div>
                                            <% } %>
                                 <% }) %>

        	</div>
                    <div id="anterior"><img src="resources/img/anterior.png" /></div>
                    <div id="siguiente"><img src="resources/img/siguiente.png" /></div>
                    <div id="contador" class="text-right"><label><%=atencionModel.toJSON().nuPreguntaRespondida%>/<%=atencionModel.toJSON().nuTotal%> Preguntas contestadas</label></div>
       </div>
      	</div>
</div>

<div id="confirm" class="modal hide fade">
  <div class="modal-body">
    Are you sure?
  </div>
  <div class="modal-footer">
    <button type="button" data-dismiss="modal" class="btn btn-primary" id="delete">Delete</button>
    <button type="button" data-dismiss="modal" class="btn">Cancel</button>
  </div>
</div>
    