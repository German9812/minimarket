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
			<p class="text-center text-condensedLight">Inicia sesión en tu cuenta</p>
                        <form action="SvLogin" method="POST">
				<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" id="userName" name="userName">
				    <label class="mdl-textfield__label" for="userName">Usuario</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="password" id="pass" name="pass">
				    <label class="mdl-textfield__label" for="pass">Contraseña</label>
				</div>
                            <button type="submit" class="mdl-button mdl-js-button mdl-js-ripple-effect" style="color: #3F51B5; margin: 0 auto; display: block;">
					INGRESAR
				</button>
			</form>
		</div>
	</div>
</body>
</html>