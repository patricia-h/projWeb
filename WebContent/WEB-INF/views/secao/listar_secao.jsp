<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Seção</title>
</head>
<body>

Usuario logado: ${usuario_logado.nome}

<h2><a href="menu">HOME</a></h2>
<br />
<table border="1">
	<c:forEach var="s" items="${secoes}">
	<tr>
		<td>${s.id}</td>
		<td>${s.titulo}</td>
		<td>${s.descricao}</td>
		<td><a href="alterarSecaoFormulario?id=${s.id}">ALTERAR</a></td>
		<td><a href="apagarSecao?id=${s.id}">APAGAR</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>









