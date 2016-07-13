<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
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
	<h2>Menu, Bem-vindo(a) ${usuario_logado.nome} </h2>

	<c:if test="${papel_sessao == 1}">
			<a href="inserirUsuarioFormulario"> Cadastrar Usuario </a> <br />
			<a href="listarUsuario">Listar Usuarios</a> <br />		
			<a href="inserirPapelFormulario"> Cadastrar Papel </a> <br />
			<a href="listarPapel">Listar Papeis</a> <br />			
			<a href="inserirClassificadoFormulario"> Cadastrar Classificado </a> <br />				
			<a href="listarClassificado"> Listar Classificados </a> <br />				
			<a href="inserirSecaoFormulario"> Cadastrar Seção</a> <br />				
			<a href="listarSecao"> Listar Seção</a> <br />			
			<a href="inserirNoticiaFormulario"> Cadastrar Notícia </a> <br />			
			<a href="listarNoticia"> Listar Notícia </a><br />	
	</c:if>

	<c:if test="${papel_sessao == 2}">
			<a href="inserirNoticiaFormulario"> Cadastrar Notícia </a> <br />	
			<a href="listarNoticia"> Listar Notícia </a> <br />
	</c:if>
	
	<c:if test="${papel_sessao == 3}">
			<a href="inserirClassificadoFormulario"> Cadastrar Classificado </a> <br />	
			<a href="listarClassificado"> Listar Classificados </a> <br />
	
	</c:if>
	
		
	<a href="logout">Logout</a>
</div>
</body>
</html>