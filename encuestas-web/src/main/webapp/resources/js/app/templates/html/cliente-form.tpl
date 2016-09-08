

<div class="row" id="config-encuesta-form">
	<div id="top-header">   
    	<!--div id="usuario" class="user-data"><span class="glyphicon glyphicon-user"><%=userData.username%></span>&nbsp&nbsp<span class="glyphicon glyphicon-shopping-cart"><%=userData.local%></span>&nbsp&nbsp<a href="<%=rootUrl%>/logout"><span class="glyphicon glyphicon-log-out">Salir</span></a></div-->
        <!--div id="fecha" class="user-data"><%=moment().format('MMMM Do YYYY')%></div-->  
	</div>
	<div id="cancelar"><img src="resources/img/cancelar.png" /></div>
	<div id="board">
    	<div   id="cuadradocrema" style="vertical-align:middle; position: relative;">	
    		
    		<div class="titulo"><h3>Ficha del cliente</h3></div>
    		<div class="row" align="center" style="vertical-align:middle">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="zona">Tipo Documento*</label>
						<select class="form-control" id="coTipoDocumento">
						<% _.each(tipoDocumentoCollection.toJSON(), function (value) { %>
						 <option  value="<%=value.coTipoDocumento%>" ><%=value.deCorto%></option>
						<% }) %>	
						</select>
						<span class="help-block"></span>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label for="documento">Nro. Documento*</label>
						<input type="text" class="form-control" id="nuDocumento" maxlength="10" />
						<span class="help-block"></span>
					</div>
				</div>		
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombres">Nombres*</label>
						<input type="text" class="form-control" id="noPersona" >
						<span class="help-block"></span>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label for="ap">Apellido Paterno*</label>
						<input type="text" class="form-control" id="apPersona" >
						<span class="help-block"></span>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label for="am">Apellido Materno*</label>
						<input type="text" class="form-control" id="amPersona" >
						<span class="help-block"></span>
					</div>
				</div>				
			</div>
			

			
			<div class="row" align="center" style="vertical-align:middle">
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nacimiento">Fecha Nacimiento</label>
                                                <input type="date" class="form-control" style="text-align: center" min="1920-12-31" max="<%=moment(new Date()).format('YYYY-MM-DD')%>" value ="<%=moment(new Date()).format('YYYY-MM-DD')%>" id="feNacimiento" >
						<span class="help-block"></span>
					</div>
				</div>
                                <div class="col-sm-1">
					<div class="form-group">						
						<label for="sexo">Edad</label>	
                                                <input type="text" disabled="true" style="text-align: center" class="form-control" value="0" id="nuEdad" >	
					</div>
				</div>	
				<div class="col-sm-2">
					<div class="form-group">
						
						<label for="sexo">Sexo*</label>
						<select class="form-control" id="coSexo">	
							 <option  value="F" >Femenino</option>						
							 <option  value="M" >Masculino</option>							 						
						</select>
						<span class="help-block"></span>
					</div>
				</div>		
				<div class="col-sm-3">
					<div class="form-group">
						<label for="celular">Email</label>
						<input type="email" class="form-control" id="deEmail" style="text-transform:lowercase" >
						<span class="help-block"></span>
					</div>
				</div>		
				<div class="col-sm-2">
					<div class="form-group">
						<label for="celular">Teléfono Celular</label>
						<input type="text" class="form-control" id="nuTelefonoCelular" maxlength="10" />
					</div>
				</div>	
				<div class="col-sm-2">
					<div class="form-group">
						<label for="fijo">Teléfono Fijo</label>
						<input type="text" class="form-control" id="nuTelefonoFijo" maxlength="10" />
					</div>
				</div>				
			</div>
                        <div class="row" align="center" style="vertical-align:middle">
				<div class="checkbox">
                                    <label>
                                      <input id="inPromocion" type="checkbox" checked > Deseo recibir promociones
                                    </label>
                                </div>
                        </div>
                        <div class="row" id="finEncuesta">
                            <div class="col-sm-5 col-sm-offset-5" id="verMesa"><img src="resources/img/finalizar.png" /></div>
                        </div>
   	  		
   	  	</div>
   	  	
    </div>
    
</div>
