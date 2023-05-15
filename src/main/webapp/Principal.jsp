<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<table class="table">
			<tr>
				<th scope="row">ID</th>
				<th scope="row">CODIGO</th>
				<th scope="row">NOMBRE</th>
				<th scope="row">CANTIDAD</th>
				<th scope="row">PRECIO</th>
				<th scope="row">CADUCIDAD</th>
				<th scope="row">ID_SECCION</th>
				<th scope="row">ELIMINAR</th>
				<th scope="row">MODIFICAR</th>
			</tr>
			<c:forEach items="${Productos}" var="producto">
				<tr>
					<td>${producto.id}</td>
					<td>${producto.codigo}</td>
					<td>${producto.nombre}</td>
					<td>${producto.cantidad}</td>
					<td>${producto.precio}</td>
					<td>${producto.caducidad}</td>
					<td>${producto.id_seccion}</td>
					<td><a href="EliminarProducto?id=${producto.id}">Eliminar</a></td>
					<td><a href="ModificarProducto?id=${producto.id}">Modificar</a></td>
				</tr>	
			</c:forEach>
		</table>
</body>
</html>