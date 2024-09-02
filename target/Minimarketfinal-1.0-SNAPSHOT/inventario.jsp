<%@page import="logica.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<%@include file="nav/head.jsp" %>
<%@include file="nav/barNav.jsp" %>
<body>
	
<% List<Producto> listaProductos = (List<Producto>) request.getSession().getAttribute("listaProductos"); %>
	<!-- CONTENIDO -->
		
		<section class="full-width header-well">
			<div class="full-width header-well-icon">
				<i class="zmdi zmdi-store"></i>
			</div>
			<div class="full-width header-well-text">
				<p class="text-condensedLight">
					INVENTARIO
				</p>
			</div>
		</section>
		<div class="full-width divider-menu-h"></div>
		<div class="mdl-grid">
			<div class="mdl-cell mdl-cell--4-col-phone mdl-cell--8-col-tablet mdl-cell--12-col-desktop">
				<div class="table-responsive">
					<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp full-width table-responsive">
						<thead>
							<tr>
								<th class="mdl-data-table__cell--non-numeric">Nombre</th>
								<th>Codigo</th>
								<th>Stock</th>
								<th>Precio</th>
								<th>Opciones</th>
							</tr>
						</thead>
						<tbody>
                                                    <% for (Producto prod : listaProductos) { %>
							<tr>
								<td class="mdl-data-table__cell--non-numeric"><%=prod.getNombre()%></td>
								<td><%=prod.getId()%></td>
								<td><%=prod.getCantidad()%></td>
								<td><%=prod.getPrecio()%></td>
								<td><button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect"><i class="zmdi zmdi-more"></i></button></td>
							</tr>
                                                        <% } %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
</body>
</html>