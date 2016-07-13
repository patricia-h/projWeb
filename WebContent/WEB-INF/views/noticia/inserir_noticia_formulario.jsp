<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css"/>
<title>Inserir Noticia</title>
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
     <c:if test="${usuario_logado.id != null}">
		<li><a href="menu">REDACÃO</a></li>
	 </c:if>

   </ul>

 </div>

<body>
<div id="pagina">
	<h2>Menu, Bem-vindo ${usuario_logado.nome}</h2>
	<h2><a href="menu">HOME</a></h2>
	
	<form action="inserirNoticia" method="post" enctype="multipart/form-data">
		Titulo: <input type="text" name="titulo" /><br />
		Subtitulo: <input type="text" name="subtitulo"/><br />
		Texto: <input type="text" name="texto"/><br />
		Data: <input type="text" name="dataNoticia"/><br />
		Imagem: <input type="file" name="imagem" /> <br />
		
								
		<select name="secoes">
		<c:forEach var="s" items="${secoes}">
			<option value="${s.id}">${s.titulo}</option>
			</c:forEach>
		</select>
		<input type="hidden" name="usuario_id" value="${usuario_logado.id}"/><br />
		
		<input type="submit" value="ENVIAR" />				
	</form>
</div>
</body>
</html>
