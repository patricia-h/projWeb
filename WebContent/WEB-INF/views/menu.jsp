<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
</head>
<body>
	<h2>Menu, Bem-vindo ${usuario_logado.nome} </h2>

	<a href="inserirUsuarioFormulario"> Inserir Usuario </a> <br />

	<a href="listarUsuario">Listar Usuarios</a> <br />
	
	<a href="inserirPapelFormulario"> Inserir Papel </a> <br />
	
	<a href="listarPapel">Listar Papeis</a> <br />
	
	<a href="inserirClassificadoFormulario"> Inserir Classificado </a> <br />
	
	<a href="listarClassificado"> Listar Classificados </a> <br />
	
	<a href="logout">Logout</a>
</body>
</html>