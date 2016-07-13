<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css"/>
<title>Home</title>
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
     <c:if test="${usuario_logado.id == 1 || usuario_logado.id == 2}">
		<li><a href="menu">REDACÃO</a></li>
	 </c:if>

   </ul>

 </div>
 
<body>
	<div id="pagina">
		<h3>Bem-vindo(a) ${usuario_logado.nome} </h3>
		<a href="logout">sair</a>
	</div>
	
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