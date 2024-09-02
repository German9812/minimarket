<%@page import="logica.CategoriaProducto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<%@include file="nav/head.jsp" %>
<%@include file="nav/barNav.jsp" %>
<body>
<% CategoriaProducto catProd = (CategoriaProducto) request.getSession().getAttribute("catEditar"); %>
	<!-- contenido de la pagina -->
		
		<section class="full-width header-well">
			<div class="full-width header-well-icon">
				<i class="zmdi zmdi-account"></i>
			</div>
			<div class="full-width header-well-text">
				<p class="text-condensedLight">
			  EDITAR CATEGORIA
				</p>
			</div>
		</section>
        
		<div class="mdl-grid">
					<div class="mdl-cell mdl-cell--12-col">
						<div class="full-width panel mdl-shadow--2dp">
							<div class="full-width panel-tittle bg-primary text-center tittles">
								EDITAR
							</div>
							<div class="full-width panel-content">
                                                            <form action="SvEditarCat" method="POST">
									<div class="mdl-grid">
										<div class="mdl-cell mdl-cell--12-col">
									        <legend class="text-condensedLight"><i class="zmdi zmdi-border-color"></i> &nbsp; DATOS DE LA CATEGORIA</legend><br>
									    </div>
									    <div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
											<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
												<input class="mdl-textfield__input" type="text" id="nombreCategoria" name="nombreCategoria">
                                                                                                <label class="mdl-textfield__label" for="nombreCategoria"><%=catProd.getNombre()%></label>
												<span class="mdl-textfield__error">Nombre no valido</span>
											</div>
									    </div>
									    <div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
											<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                                                            <input class="mdl-textfield__input" type="text" id="descripcionCategoria" name="descripcionCategoria">
												<label class="mdl-textfield__label" for="escripcionCategoria"><%=catProd.getDescripcion()%></label>
												<span class="mdl-textfield__error">Descripción invalida</span>
											</div>
									    </div>
                                                                            <div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
                                                                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                                                    <select class="mdl-textfield__input" id="estado" name="estado">
                                                                                        <option value="" disabled selected>Seleccione el nuevo estado</option>
                                                                                        <option value="ACTIVA">ACTIVA</option>
                                                                                        <option value="INACTIVA">INACTIVA</option>
                                                                                    </select>
                                                                                    <label class="mdl-textfield__label" for="estado"></label>
                                                                                    <span class="mdl-textfield__error">Estado no valido</span>
                                                                                </div>
                                                                            </div>
									</div>
									<p class="text-center">
										<button type="submit" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored mdl-button--mini-fab bg-primary" id="btn-addCategory">
											<i class="zmdi zmdi-plus"></i>
										</button>
										<div class="mdl-tooltip" for="btn-addCategory">Agregar Categoria</div>
									</p>
								</form>
							</div>
						</div>
					</div>
				</div>
          
         
	
</body>
</html>