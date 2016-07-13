<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css"/>
<title>Alterar Noticia</title>
	
</head>

<div id="imagem">
		<img src="./resources/imagens/capa.png" width="330" height="120" 
		alt="logo de 220 por 80 pixel">
   
</div>

<div id="menu">
   
   <ul>
     <li><a href="home">HOME</a></li>
     <li><a href="listarNoticia">NOTÍCIAS</a></li>
     <li><a href="listarClassificado">CLASSIFICADOS</a></li>
     <li><a href="login">ENTRAR</a></li>

   </ul>

 </div>
   
   

<body>

	<div id="pagina">
		<h2>Alterar Noticia</h2>
		<a href="home">HOME</a><br />
		<form action="alterarNoticia" method="post">
			<input type="hidden" name="id" value="${noticia.id}" />
			<br />
			Titulo: <input type="text" name="titulo" value="${noticia.titulo}" /><br />
			Subtitulo: <input type="text" name="subtitulo" value="${noticia.subtitulo}"/><br />
			Texto: <input type="text" name="texto" value="${noticia.texto}"><br />
			<input type="hidden" name="autor" value="${noticia.idAutor.id}"><br />	
			<input type="hidden" name="secao" value="${noticia.idSecao.id}"><br />
			
			<input type="submit" value="ALTERAR" />
		</form>
	</div>
</body>
</html>