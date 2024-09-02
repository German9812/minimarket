<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<%@include file="nav/head.jsp" %>
<%@include file="nav/barNav.jsp" %>
<body>
	
	<!-- Contenido de la pagina -->
	
		
		<section class="full-width header-well">
			<div class="full-width header-well-icon">
				<i class="zmdi zmdi-truck"></i>
			</div>
			<div class="full-width header-well-text">
				<p class="text-condensedLight">
					CREACION DE PROVEEDORES
				</p>
			</div>
		</section>
				<div class="mdl-grid">
					<div class="mdl-cell mdl-cell--12-col">
						<div class="full-width panel mdl-shadow--2dp">
							<div class="full-width panel-tittle bg-primary text-center tittles">
								Nuevo Proveedor
							</div>
							<div class="full-width panel-content">
								<form>
									<div class="mdl-grid">
										<div class="mdl-cell mdl-cell--12-col">
									        <legend class="text-condensedLight"><i class="zmdi zmdi-border-color"></i> &nbsp; DATOS DEL PROVEEDOR</legend><br>
									    </div>
									    <div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
											<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                                                            <input class="mdl-textfield__input" type="number" pattern="-?[0-9]*(\.[0-9]+)?" id="nitproveedor" name="nit proveedor">
												<label class="mdl-textfield__label" for="DNIProvider">NIT</label>
												<span class="mdl-textfield__error">Invalid number</span>
											</div>
									    </div>
									    <div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
											<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
												<input class="mdl-textfield__input" type="text" pattern="-?[A-Za-z0-9 ]*(\.[0-9]+)?" id="NameProvider">
												<label class="mdl-textfield__label" for="NameProvider">Nombre</label>
												<span class="mdl-textfield__error">Invalid name</span>
											</div>
									    </div>
									    <div class="mdl-cell mdl-cell--12-col">
											<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
												<input class="mdl-textfield__input" type="text" id="addressProvider">
												<label class="mdl-textfield__label" for="addressProvider">Correo electronico</label>
												<span class="mdl-textfield__error">Invalid address</span>
											</div>
									    </div>
									    <div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
											<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
												<input class="mdl-textfield__input" type="tel" pattern="-?[0-9+()- ]*(\.[0-9]+)?" id="phoneProvider">
												<label class="mdl-textfield__label" for="phoneProvider">Telefono</label>
												<span class="mdl-textfield__error">Invalid phone number</span>
											</div>
									    </div>
									    <div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
											<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
												<input class="mdl-textfield__input" type="text" id="webProvider">
												<label class="mdl-textfield__label" for="webProvider">Dirección</label>
												<span class="mdl-textfield__error">Invalid web address</span>
											</div>
									    </div>
									</div>
									<p class="text-center">
										<button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored mdl-button--mini-fab bg-primary" id="btn-addProvider">
											<i class="zmdi zmdi-plus"></i>
										</button>
										<div class="mdl-tooltip" for="btn-addProvider">Agregar Proveedor</div>
									</p>
								</form>
							</div>
						</div>
					</div>
				</div>
</body>
</html>