<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css"/>
<title>Alterar Classificado</title>
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
<div id="pagina">
	<h2>Alterar Classificado</h2>
	
	<form action="alterarClassificado" method="post">
		<input type="hidden" name="id" value="${classificado.id}" />
		Titulo: <input type="text" name="titulo" value="${classificado.titulo}" /><br />
		Texto: <input type="text" name="texto" value="${classificado.texto}"/><br />
		Preço: <input type="text" name="preco" value="${classificado.preco}"><br />
		Telefone: <input type="text" name="telefone" value="${classificado.telefone}"><br />
		Melhor Oferta: <input type="text" name="melhorOferta" value="${classificado.melhorOferta}"><br />		
		<input type="hidden" name="usuario" value="${usuario_logado.id}">
		<input type="submit" value="ALTERAR" />
	</form>
</div>
</body>
</html>