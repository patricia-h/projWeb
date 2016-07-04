<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Classificado</title>
</head>
<body>

Usuario logado: ${usuario_logado.nome}
<table border="1">
	<c:forEach var="c" items="${classificados}">
	<tr>
		<td>${c.id}</td>
		<td>${c.titulo}</td>
		<td><a href="alterarClassificadoFormulario?id=${c.id}">ALTERAR</a></td>
		<td><a href="apagarClassificado?id=${c.id}">APAGAR</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>









