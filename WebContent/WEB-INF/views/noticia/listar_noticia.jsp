<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Noticia</title>
</head>
<body>

Usuario logado: ${usuario_logado.nome}
<br />
<a href="home">HOME</a>
<br />
<table border="1">
	<c:forEach var="n" items="${noticias}">
	<tr>
		<td>${n.id}</td>
		<td>${n.titulo}</td>
		<td><a href="alterarNoticiaFormulario?id=${n.id}">ALTERAR</a></td>
		<td><a href="apagarNoticia?id=${n.id}">APAGAR</a></td>
	</tr>
	</c:forEach>
</table>
	
</body>
</html>









