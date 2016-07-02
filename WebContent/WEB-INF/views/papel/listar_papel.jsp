<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Papel</title>
</head>
<body>

Usuario logado: ${usuario_logado.nome}
<table border="1">
	<c:forEach var="p" items="${papeis}">
	<tr>
		<td>${p.id}</td>
		<td>${p.papel}</td>
		<td><a href="alterarPapelFormulario?id=${p.id}">ALTERAR</a></td>
		<td><a href="apagarPapel?id=${p.id}">APAGAR</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>









