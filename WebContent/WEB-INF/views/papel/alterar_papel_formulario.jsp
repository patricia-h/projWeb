<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Papel</title>
</head>
<body>

<h2><a href="menu">HOME</a></h2>
<br />
<form action="alterarPapel" method="post">
	<input type="hidden" name="id" value="${papel.id}" />
	Papel: <input type="text" name="papel" value="${papel.papel}" /><br />	
	<input type="submit" value="ALTERAR" />
</form>

</body>
</html>