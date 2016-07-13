<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css"/>
<title>Inserir Usuario</title>
</head>
<body>
	<div id="imagem">
		<img src="./resources/imagens/capa.png" width="330" height="120" 
		alt="logo de 220 por 80 pixel">
   
   </div>

	<div id="menu">
	
		<ul class="menu">
     		<li><a href="home">HOME</a></li>
	     	<li><a href="listarNoticia">NOTÍCIAS</a></li>
		    <li><a href="listarClassificado">CLASSIFICADOS</a></li>
		    <li><a href="login">ENTRAR</a></li>

   		</ul>
   	</div>
	
	<div id="form">
		<form action="inserirUsuario" method="post" enctype="multipart/form-data">
			Nome: <input type="text" name="nome" />
			<form:errors path="usuario.nome" /> 
			E-mail: <input type="text" name="email" /> <br />
			
			Perfil:
			<select name="papeis">
				<c:forEach var="p" items="${papeis}">
					<option value="${p.id}">${p.papel}</option>
				</c:forEach>
			</select>
			
		
			Senha: <input type="password" name="senha" /> <br />
			Login: <input type="text" name="login" /> <br />
			Imagem: <input type="file" name="imagem" /> <br />
			<input type="submit" value="ENVIAR" />
			<br />
			
		</form>
	</div>
</body>
</html>