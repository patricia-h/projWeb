<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css"/>
<title>Efetuar Login</title>
</head>
<body>
	<div id="menu">
		<h2><b>Efetuar Login</b></h2>
		
		<form action="login" method="post">
			Login: <input type="text" name="login" /> <br />
			Senha: <input type="password" name="senha" /> <br />
			<input type="submit" value="Entrar" /> 
		</form>
		<br />
		<h2><b>Não possui uma conta?</b></h2>
		<a href="inserirUsuarioFormulario">Cadastre-se</a>
	</div>
</body>
</html>