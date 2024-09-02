

<%@page import="logica.CategoriaProducto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <%@include file="nav/head.jsp" %>
<%@include file="nav/barNav.jsp" %>
    
     <%  
                List<CategoriaProducto> listaCategoria = (List<CategoriaProducto>) request.getSession().getAttribute("listaCategoria");
                %>

    <body>
           <div class="mdl-tabs__panel" id="tabLista">
				<div class="mdl-grid">
					<div class="mdl-cell mdl-cell--4-col-phone mdl-cell--8-col-tablet mdl-cell--8-col-desktop mdl-cell--2-offset-desktop">
						<div class="full-width panel mdl-shadow--2dp">
							<div class="full-width panel-tittle bg-success text-center tittles">
								Lista Categorias
							</div>
							<div class="full-width panel-content">
								<form action="#">
									<div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
										<label class="mdl-button mdl-js-button mdl-button--icon" for="buscarusuario">
											<i class="zmdi zmdi-search"></i>
										</label>
										<div class="mdl-textfield__expandable-holder">
											<input class="mdl-textfield__input" type="text" id="buscarusuario">
											<label class="mdl-textfield__label"></label>
										</div>
									</div>
								</form>
                                                               <% for (CategoriaProducto catProd : listaCategoria){ %>
                                                                    <div class="mdl-list">
                                                                        <div class="mdl-list__item mdl-list__item--two-line">
                                                                            <span class="mdl-list__item-primary-content">
                                                                                <i class="zmdi zmdi-account mdl-list__item-avatar"></i>
                                                                                <span><%= catProd.getNombre() %></span>
                                                                                <span class="mdl-list__item-sub-title"><%= catProd.getId() %></span>
                                                                                <span class="mdl-list__item-sub-title"><%= catProd.getDescripcion()%></span>
                                                                            </span>
                                                                            <span class="mdl-list__item-secondary-content">

                                                                                <!-- Boton para editar Categoria -->
                                                                                 
                                                                                <form action="SvEditarCat" method="GET">
                                                                                    <button type="submit" class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored" >
                                                                                    <i class="zmdi zmdi-edit"></i>
                                                                                    <input type="hidden" name="id" value="<%= catProd.getId()%>"> 
                                                                                </button> </form>
                                                                                
                                                                                
                                                                                 <form action="SvEliminarCat" method="POST">
                                                                                  <button type="submit" class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored" >
                                                                                     <i class="zmdi zmdi-delete"></i>
                                                                                     <input type="hidden" name="id" value="<%= catProd.getId() %>">
                                                                                 </button>
                                                                                     </form>
                                                                             </span>
                                                                        </div>
                                                                        <li class="full-width divider-menu-h"></li>
                                                                    </div>
                                                                <% } %>

								</div>
							</div>
						</div>
				</div>
		</div>
    </body>
</html>
