<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Noticia</title>
</head>
<body>

<h2>Alterar Noticia</h2>

<a href="menu">HOME</a>
<br />
<form action="alterarNoticia" method="post">
	<input type="hidden" name="id" value="${noticia.id}" />
	Titulo: <input type="text" name="titulo" value="${noticia.titulo}" /><br />
	Subtitulo: <input type="text" name="subtitulo" value="${noticia.subtitulo}"/><br />
	Texto: <input type="text" name="texto" value="${noticia.texto}"><br />
	Data: <input type="text" name="dataNoticia" value="${noticia.dataNoticia}"><br />
	<input type="hidden" name="idAutor" value="${noticia.idAutor}"><br />
	<input type="hidden" name="idSecao" value="${noticia.idSecao}"><br />
	
	<input type="submit" value="ALTERAR" />
</form>

</body>
</html>