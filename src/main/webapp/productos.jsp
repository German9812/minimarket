<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="logica.CategoriaProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<%@include file="nav/head.jsp" %>
<%@include file="nav/barNav.jsp" %>
<body>
   
<% List<CategoriaProducto> listaCategorias = (List<CategoriaProducto>) request.getSession().getAttribute("listaCategorias"); %>
    
   
    
    <!-- contenido de la pagina -->
    <section class="full-width header-well">
        <div class="full-width header-well-icon">
            <i class="zmdi zmdi-washing-machine"></i>
        </div>
        <div class="full-width header-well-text">
            <p class="text-condensedLight">
                CREACIÓN DE PRODUCTOS
            </p>
        </div>
    </section>
    
    <div class="mdl-grid">
        <div class="mdl-cell mdl-cell--12-col">
            <div class="full-width panel mdl-shadow--2dp">
                <div class="full-width panel-tittle bg-primary text-center tittles">
                    Nuevo Producto
                </div>
                <div class="full-width panel-content">
                    <form action="SvProducto" method="POST">
                        <div class="mdl-grid">
                            <div class="mdl-cell mdl-cell--12-col">
                                <legend class="text-condensedLight"><i class="zmdi zmdi-border-color"></i> &nbsp; INFORMACIÓN BASICA</legend><br>
                            </div>
                            
                            <div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" id="nombreProducto" name="nombreProducto">
                                    <label class="mdl-textfield__label" for="nombreProducto">Nombre</label>
                                    <span class="mdl-textfield__error">Nombre no valido</span>
                                </div>
                            </div>
                            <div class="mdl-cell mdl-cell--4-col mdl-cell--8-col-tablet">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" id="precioProducto" name="precioProducto">
                                    <label class="mdl-textfield__label" for="precioProducto">Precio</label>
                                    <span class="mdl-textfield__error">Precio no valido</span>
                                </div>
                            </div>
                            <div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" id="descricionPago" name="descricionPago">
                                    <label class="mdl-textfield__label" for="descricionPago">Descripción</label>
                                    <span class="mdl-textfield__error">Descripción no valida</span>
                                </div>
                            </div>
                            
                            <div class="mdl-cell mdl-cell--4-col mdl-cell--8-col-tablet">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="number" id="cantidad" name="cantidad" min="1" step="1">
                                    <label class="mdl-textfield__label" for="cantidad">Cantidad</label>
                                    <span class="mdl-textfield__error">Cantidad no valida</span>
                                </div>  
                            </div>

                            <div class="mdl-cell mdl-cell--12-col">
                                <legend class="text-condensedLight"><i class="zmdi zmdi-border-color"></i> &nbsp; CATEGORIA</legend><br>
                            </div>
                            <div class="mdl-cell mdl-cell--06-col">
                                <div class="mdl-textfield mdl-js-textfield">
                                    <% if (listaCategorias != null && !listaCategorias.isEmpty()) { %>
                                    <select name="categoriaProducto" class="mdl-textfield__input">
                                        <option value="" disabled selected>Seleccione Categoria</option>
                                        <% for (CategoriaProducto categoria : listaCategorias) { %>
                                            <option value="<%= categoria.getId() %>"><%= categoria.getNombre() %></option>
                                        <% } %>
                                    </select>
                                <% } else { %>
                                    <p>No hay categorías disponibles.</p>
                                <% } %>
                                </div>
                            </div>  
                        </div>
                        <p class="text-center">
                            <button type="submit" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored bg-primary" id="btn-addProduct">
                                <i class="zmdi zmdi-plus"></i>
                            </button>
                            <div class="mdl-tooltip" for="btn-addProduct">Agregar Producto</div>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
