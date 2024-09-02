<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<%@include file="nav/head.jsp" %>
<%@include file="nav/barNav.jsp" %>
<body>
	
	<!-- contenido de la pagina -->
		
		<section class="full-width header-well">
			<div class="full-width header-well-icon">
				<i class="zmdi zmdi-account"></i>
			</div>
			<div class="full-width header-well-text">
				<p class="text-condensedLight">
			  CREAR NUEVOS USUARIOS
				</p>
			</div>
		</section>
        
		<div class="full-width divider-menu-h"></div>
		<div class="mdl-grid">
			<div class="mdl-cell mdl-cell--12-col">
				<div class="full-width panel mdl-shadow--2dp">
					<div class="full-width panel-tittle bg-primary text-center tittles">
						Nuevo Usuario
					</div>
					<div class="full-width panel-content">
						<form action="SvUsuarios" method="POST">
							<div class="mdl-grid">
								<div class="mdl-cell mdl-cell--12-col">
		                            <legend class="text-condensedLight"><i class="zmdi zmdi-border-color"></i> &nbsp; DATOS DE USUARIO</legend><br>
		                        </div>
								
								<div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
									<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                                            <input class="mdl-textfield__input" type="text" id="username" name="username">
										<label class="mdl-textfield__label" for="username">Nombre usuario</label>
										<span class="mdl-textfield__error">Usuario invalido</span>
									</div>
								</div>
                                                         
								<div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
									<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                                            <input class="mdl-textfield__input" type="password" id="password" name="password">
										<label class="mdl-textfield__label" for="password">Contraseña</label>
										<span class="mdl-textfield__error">Invalid password</span>
									</div>
								</div>
								<div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
                                                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                                    <select class="mdl-textfield__input" id="rol" name="rol">
                                                                        <option value="" disabled selected>Selecciona un rol</option>
                                                                        <option value="administrador">Administrador</option>
                                                                        <option value="empleado">Empleado</option>
                                                                    </select>
                                                                    <label class="mdl-textfield__label" for="rol"></label>
                                                                    <span class="mdl-textfield__error">Rol invalido</span>
                                                                </div>
                                                            </div>

							</div>
							<p class="text-center">
                                                            <button type="submit" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored mdl-button--mini-fab bg-primary" id="agregarusuario">
									<i class="zmdi zmdi-plus"></i>
								</button>
								<div class="mdl-tooltip" for="agregarusuario">Agregar Usuario</div>
							</p>
						</form>
					</div>
				</div>
			</div>
		</div>
          
         
	</section>
</body>
</html>