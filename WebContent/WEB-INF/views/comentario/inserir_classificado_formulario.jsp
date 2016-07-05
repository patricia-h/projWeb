<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Comentario</title>
</head>
<body>
	<h2>Menu, Bem-vindo ${usuario_logado.nome}</h2>
	
	<form action="inserirComentario" method="post" enctype="multipart/form-data">
	
		
		Titulo: <input type="text" name="titulo" /><br />
		Texto: <input type="text" name="texto"/><br />
		Preço: <input type="text" name="preco"/><br />
		Telefone: <input type="text" name="telefone"/><br />
		Melhor Oferta: <input type="text" name="melhorOferta"/><br />
		Data Oferta: <input type="text" name="dataOferta"/><br />
		<input type="hidden" name="usuario_id" value="${usuario_logado.id}"/><br />
		<input type="submit" value="ENVIAR" />		
	</form>

</body>
</html>
