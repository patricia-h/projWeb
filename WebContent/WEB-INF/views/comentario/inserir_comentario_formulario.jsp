<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
	
				<h2>${noticia_id.titulo}</h2>
				${noticia_id.subtitulo}<br />
				${noticia_id.texto}<br />
				
				<c:if test="${usuario_logado.id != null}">
					
					<form action="inserirComentario" method="post" enctype="multipart/form-data">
	
		
						Comentario: <input type="text" name="texto" /><br />
						
						<input type="hidden" name="noticia_id" value="${noticia_id.id}">
						<input type="hidden" name="usuario_id" value="${usuario_logado.id}"/><br />
						<input type="submit" value="ENVIAR" />		
					</form>
  					<br />
  				</c:if>
  				
  				
<table border="1">
	<c:forEach var="cm" items="${comentarios}">
	<tr>
		
		<td>${cm.texto}</td>
		<c:if test="${usuario_logado.id == cm.autorComentario.id}">
			<td><a href="alterarComentarioFormulario?id=${cm.id}">ALTERAR</a></td>
			<td><a href="apagarComentario?id=${cm.id}">APAGAR</a></td>	
	 	</c:if>
		
	</tr>
	</c:forEach>
</table>
	
	
	

</body>
</html>
