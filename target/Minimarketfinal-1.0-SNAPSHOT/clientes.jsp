<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<%@include file="nav/head.jsp" %>
<%@include file="nav/barNav.jsp" %>
<body>
	<!-- pageContent -->
	
		<section class="full-width header-well">
			<div class="full-width header-well-icon">
				<i class="zmdi zmdi-accounts"></i>
			</div>
			<div class="full-width header-well-text">
				<p class="text-condensedLight">
                                    CREACIÓN DE CLIENTES
                                </p>
			</div>
		</section>
		
				<div class="mdl-grid">
					<div class="mdl-cell mdl-cell--12-col">
						<div class="full-width panel mdl-shadow--2dp">
							<div class="full-width panel-tittle bg-primary text-center tittles">
								Nuevo Cliente
							</div>
							<div class="full-width panel-content">
								<form>
									<div class="mdl-grid">
										<div class="mdl-cell mdl-cell--12-col">
									        <legend class="text-condensedLight"><i class="zmdi zmdi-border-color"></i> &nbsp; Datos del Cliente</legend><br>
									    </div>
									   <div class="mdl-cell mdl-cell--12-col">
											<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
												<input class="mdl-textfield__input" type="number" id=cedulaCliente">
												<label class="mdl-textfield__label" for="cedulaCliente">Documento identidad</label>
												<span class="mdl-textfield__error">Invalid number</span>
											</div>
									    </div>
									    <div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
											<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
												<input class="mdl-textfield__input" type="text" id="nombreCliente">
												<label class="mdl-textfield__label" for="nombreCliente">Nombre</label>
												<span class="mdl-textfield__error">Nombre no valido</span>
											</div>
									    </div>
										<div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
											<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
												<input class="mdl-textfield__input" type="text" id="apellidoCliente">
												<label class="mdl-textfield__label" for="apellidoCliente">Apellido</label>
												<span class="mdl-textfield__error">Apellido no valido</span>
											</div>
										</div>
										<div class="mdl-cell mdl-cell--4-col mdl-cell--8-col-tablet">
											<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
												<input class="mdl-textfield__input" type="tel" id="telefonoCliente">
												<label class="mdl-textfield__label" for="telefonoCliiente">Telefono</label>
												<span class="mdl-textfield__error">Numero no valido</span>
											</div>
										</div>
									</div>
									<p class="text-center">
										<button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored mdl-button--mini-fab bg-primary" id="btn-addClient">
											<i class="zmdi zmdi-plus"></i>
										</button>
										<div class="mdl-tooltip" for="btn-addClient">Agregar Cliente</div>
									</p>
								</form>
							</div>
						</div>
					</div>
				</div>
</body>
</html>