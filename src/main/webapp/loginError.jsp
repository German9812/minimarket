<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <%@include file="nav/head.jsp" %>
<body>
	<div class="login-wrap cover">
		<div class="container-login">
			<p class="text-center" style="font-size: 80px;">
				<img src="assets/img/logo2.png" alt="alt" width="150" height="100"/>
			</p>
			<p class="text-center text-condensedLight">Inicia de sesión incorrecto</p>
                        <form action="SvLogin" method="POST">
				
                            <br>
                             
                            <p class="text-center text-condensedLight">Nombre de usuario o Contraseña incorrectos</p>
                            
                            <br>
                            
                            <a href="index.jsp" class="mdl-button mdl-js-button mdl-js-ripple-effect" style="color: #3F51B5; margin: 0 auto; display: block;">
					INTENTAR NUEVAMENTE
				</a>
			</form>
		</div>
	</div>
</body>
</html>