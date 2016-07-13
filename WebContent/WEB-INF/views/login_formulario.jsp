<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css"/>
<title>Efetuar Login</title>
</head>

 <div id="menu">
   <div>
		<img src="./resources/imagens/capa.png" width="330" height="120" 
		alt="logo de 220 por 80 pixel" id="imagem">
   
   </div>
   <ul>
     <li><a href="home">HOME</a></li>
     <li><a href="listarNoticia">NOTÍCIAS</a></li>
     <li><a href="listarClassificado">CLASSIFICADOS</a></li>
     <li><a href="login">ENTRAR</a></li>

   </ul>

 </div>

<body>
	<div id="body_login">
		<b>Efetuar Login</b>
		<br />
		<form action="login" method="post">
			<br />
			Usuario: <input type="text" name="login" />
			<br />
			Senha: <input type="password" name="senha" /> <br />
			<br />
			<input type="submit" value="Entrar" /> 
		</form>
		<br />
		
		<b>Não possui uma conta?</b>
		<a href="inserirUsuarioFormulario"><p>Cadastre-se</a>
	</div>
</body>
</html>