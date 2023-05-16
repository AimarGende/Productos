<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
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
				<th scope="row">SECCION</th>
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
					<td>${producto.seccion.nombre}</td>
					<td><a href="EliminarProducto?id=${producto.id}">Eliminar</a></td>
					<td><a href="ModificarProducto?id=${producto.id}">Modificar</a></td>
				</tr>	
			</c:forEach>
		</table>
		<br><br>
		<p>${msg}</p>
		<br><br>	
		<form action="InsertarProducto">
			<label>Codigo</label>
			<input type="text" name="codigo" placeholder="codigo">
			<br><br>
			<label>Nombre</label>
			<input type="text" name="nombre" placeholder="Nombre">
			<br><br>
			<label>Cantidad</label>
			<input type="text" name="cantidad" placeholder="cantidad">
			<br><br>
			<label>Precio</label>
			<input type="text" name="precio" placeholder="Precio">
			<br><br>
			<label>Caducidad</label>
			<input type="date" name="caducidad" >
			<br><br>
			<label>Seccion</label>
			<select name="id_seccion">
				<option value=0></option>
				<c:forEach items="${Secciones}" var="seccion">
					<option value="${seccion.id}">${seccion.nombre}</option>
				</c:forEach>
			</select>
			<br><br>
			<input type="submit" value="Insertar Producto">
		</form>
		
</body>
</html>