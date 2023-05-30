<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito</title>
</head>
<body>

	<table border=1>
		<tr >
			<td align="center" colspan=5>Prodcutos</td>
		</tr>
		<c:forEach items="${carrito}" var="producto">
		<tr>
			<td>${producto.id}</td>
			<td>${producto.nombre}</td>
			<td>${producto.codigo}</td>
			<td>${producto.precio}</td>
			<td><a href="EliminarDeCarrito?id=${producto.id}">Eliminar</a></td>
		</tr>
		</c:forEach>
	</table>
	<a href="Principal">Volver</a> <br><br>
	<a href="FinalizarCompra">FinalizarCompra</a>
</body>
</html>