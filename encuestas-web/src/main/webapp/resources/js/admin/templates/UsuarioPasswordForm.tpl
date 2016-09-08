<form>
	<div class="form-group">
		<label>Usuario</label>
		<div class="col-sm-12">
			<%=username%>
		</div>
	</div>
	<!--div class="form-group">
		<label for="oldPassword">Contraseña anterior</label>
		<input id="oldPassword" type="password" class="form-control input-sm" />
	</div-->
	<div class="form-group">
		<label for="newPassword">Nueva contraseña</label>
		<input id="newPassword" type="password" class="form-control input-sm" />
	</div>
	<div class="form-group">
		<label for="newPassword2">Repita nueva ontraseña</label>
		<input id="newPassword2" type="password" class="form-control input-sm" />
	</div>
	<button id="cambiarcontra" class="btn btn-sm btn-primary">Cambiar</button>
	&nbsp;<button id="cancel" class="btn btn-sm btn-primary">Cancelar</button>
</form>