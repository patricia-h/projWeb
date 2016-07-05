<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Classificado</title>
</head>
<body>

<h2>Alterar Classificado</h2>

<form action="alterarClassificado" method="post">
	<input type="hidden" name="id" value="${classificado.id}" />
	Titulo: <input type="text" name="titulo" value="${classificado.titulo}" /><br />
	Texto: <input type="text" name="texto" value="${classificado.texto}"/><br />
	Preço: <input type="text" name="preco" value="${classificado.preco}"><br />
	Telefone: <input type="text" name="telefone" value="${classificado.telefone}"><br />
	Melhor Oferta: <input type="text" name="melhorOferta" value="${classificado.melhorOferta}"><br />
	Data Oferta: <input type="text" name="dataOferta" value="${classificado.dataOferta}"><br />
	
	<input type="submit" value="ALTERAR" />
</form>

</body>
</html>