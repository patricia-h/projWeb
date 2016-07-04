<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Secão</title>
</head>
<body>
	
	<form action="inserirSecao" method="post" enctype="multipart/form-data">
		Título: <input type="text" name="titulo" />
		<form:errors path="papel.nome" /> 
		<br />
		Descrição: <input type="text" name="descricao"/>
		<input type="submit" value="ENVIAR" />		
	</form>

</body>
</html>