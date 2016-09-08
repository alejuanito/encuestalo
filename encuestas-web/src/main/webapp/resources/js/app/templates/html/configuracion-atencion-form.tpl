

<div class="row" id="config-encuesta-form">
	<div id="board" class="row board-configuracion">
    		<div class="row">
                    <div class="text-center"><h3>Encuesta <%= ("000" + userData.nuLocal).slice(-3) + '-'+("000000" + nuCorrelativoEncuesta).slice(-6)%></h3></div>
                </div>
    		<div class="row form-configuracion">
                    <div class="col-sm-4 col-sm-offset-4 " align="center" style="vertical-align:middle">
                        <label for="zona">Zona</label>
                        <select class="form-control" id="idArea-config">
                                <% _.each(areaCollection.toJSON(), function (value) { %>
                                 <option  value="<%=value.idArea%>" ><%=value.deArea%></option>
                                <% }) %>	
			</select>
                    </div>
                </div>
            
                <div class="row form-configuracion">
                    <div class="col-sm-4 col-sm-offset-4 " align="center" style="vertical-align:middle">
                       <label for="mesa">Mesa</label>
                       <input type="number" class="form-control" min="0" max="100"  id="nuMesa" >
                       <span class="help-block"></span>
                    </div>
                </div>
            
                <div class="row form-configuracion">
                    <div class="col-sm-4 col-sm-offset-4 " align="center" style="vertical-align:middle">
                        <label for="mozo">Mozo</label>
                        <select class="form-control" id="idColaborador-config">
                                <% _.each(colaboradorCollection.toJSON(), function (value) { %>
                                 <option  value="<%=value.idColaborador%>" ><%=value.persona.noPersona + " " + value.persona.apPersona%></option>
                                <% }) %>

                        </select>
                    </div>
                </div>    
 
                <div class="row btn-sgt-config">
                        <div class="col-sm-5 col-sm-offset-5" id="verMesa"><img src="resources/img/continuar.png" /></div>
                </div>
			
					   	  	
    </div>
    	
</div>


<div id="atencion-form" class="hidden">
	<div id="top-header" class="form-configuracion">
	    	<div id="cabecera"><img class="adapta" src="resources/img/mostacho.jpg" /></div>
	        <div id="usuario" class="user-data"><span class="glyphicon glyphicon-user"><%=userData.username%></span>&nbsp&nbsp<span class="glyphicon glyphicon-shopping-cart"><%=userData.local%></span>&nbsp&nbsp<a href="<%=rootUrl%>/logout"><span class="glyphicon glyphicon-log-out">Salir</span></a></div>
        	<div id="fecha" class="user-data"><%=userData.date%></div>
	</div>

	<div class ="row" >
            <div id="board" class="form-configuracion" style="position: relative;">
	    	<div  align="center" id="cuadradocrema" style="vertical-align:middle">
	        	<div id="inter" >
	            <img  class="logo"src="resources/img/logoPiombino01A.png"/>
	            <img class="mesa" src= "resources/img/mesa01.png" />
	            </div>
	            <div id="continuar"><img src="resources/img/continuar.png" /></div>
	        </div>
	        
	    		<div id="cancelar" class="inicio"><img src="resources/img/cancelar.png" /></div>
	    		<div id="anterior" class="inicio"><img src="resources/img/anterior.png" /></div>
	   	  		
	      	</div>
	</div>
</div>