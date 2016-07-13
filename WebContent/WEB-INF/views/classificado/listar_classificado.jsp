<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css"/>
<title>Listar Classificado</title>
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
		<h3>Bem-vindo(a) ${usuario_logado.nome} </h3>
		<a href="menu">Menu</a>		
			<c:forEach var="c" items="${classificados}">
				<br />				
				<td>${c.titulo}</td>
				<td>${c.preco}</td>
				<c:if test="${usuario_logado.id != null}">
					<td><a href="alterarClassificadoFormulario?id=${c.id}">ALTERAR</a></td>
					<td><a href="apagarClassificado?id=${c.id}">APAGAR</a></td>
				</c:if>
			</c:forEach>
		
	</div>
</body>
</html>









