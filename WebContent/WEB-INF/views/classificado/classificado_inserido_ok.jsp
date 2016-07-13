<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css"/>
<title>Classificado Inserido</title>
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
		<c:if test="${papel_sessao == 1 || papel_sessao == 2}">
			<li><a href="menu">REDACÃO</a></li>
	 	</c:if>
		
	 </c:if>

   </ul>

 </div>

<body>
	<h2><a href="home">HOME</a></h2>
	<br />
	Classificado inserido com sucesso.
</body>
</html>