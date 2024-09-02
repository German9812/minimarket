
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <%@include file="nav/head.jsp" %>
<%@include file="nav/barNav.jsp" %>
    
     <%  
                List<Usuario> listaUsuarios = (List<Usuario>) request.getSession().getAttribute("listaUsuarios");
                %>

    <body>
           <div class="mdl-tabs__panel" id="tabLista">
				<div class="mdl-grid">
					<div class="mdl-cell mdl-cell--4-col-phone mdl-cell--8-col-tablet mdl-cell--8-col-desktop mdl-cell--2-offset-desktop">
						<div class="full-width panel mdl-shadow--2dp">
							<div class="full-width panel-tittle bg-success text-center tittles">
								Lista usuarios
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
                                                               <% for (Usuario usu : listaUsuarios){ %>
                                                                    <div class="mdl-list">
                                                                        <div class="mdl-list__item mdl-list__item--two-line">
                                                                            <span class="mdl-list__item-primary-content">
                                                                                <i class="zmdi zmdi-account mdl-list__item-avatar"></i>
                                                                                <span><%= usu.getNombreUsuario() %></span>
                                                                                <span class="mdl-list__item-sub-title"><%= usu.getId() %></span>
                                                                                <span class="mdl-list__item-sub-title"><%= usu.getRol() %></span>
                                                                            </span>
                                                                            <span class="mdl-list__item-secondary-content">
                                                                                
                                                                               <!-- Boton para editar usuario -->
                                                                                <form action="SvEditarUsu" method="GET">
                                                                                    <button type="submit" class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored" >
                                                                                    <i class="zmdi zmdi-edit"></i>
                                                                                    <input type="hidden" name="id" value="<%= usu.getId() %>"> 
                                                                                </button> </form>
                                                                                <form action="SvEliminarUsu" method="POST">
                                                                                 <button type="submit" class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored" >
                                                                                    <i class="zmdi zmdi-delete"></i>
                                                                                    <input type="hidden" name="id" value="<%= usu.getId() %>">
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
