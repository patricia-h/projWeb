<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Usuario</title>
</head>
<body>

<h2>Alterar Usuario</h2>

<form action="alterarUsuario" method="post">
	<input type="hidden" name="id" value="${usuario.id}" />
	Nome: <input type="text" name="nome" value="${usuario.nome}" /><br />
	Email: <input type="text" name="email" value="${usuario.email}" /><br />
	Login: <input type="text" name="login" value="${usuario.login}" /> <br />
	Senha: <input type="password" name="senha" value="${usuario.senha}" /> <br />
	Imagem: <input type="file" name="imagem" /> <br />
	<input type="submit" value="ALTERAR" />
</form>

</body>
</html>