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
	<div class="Ordenado" style="display: inline-block; width: 50%;">
	<h1>Ordenar</h1>
		<form action="OrdenarPorCodigo">
			<p>Ordenar por codigo</p>
			<input type="Submit" value="Ascendente" name="orden">
			<input type="Submit" value="Descendente" name="orden">
		</form>
		<br> <br>
		<form action="OrdenarPorPrecio">
			<p>Ordenar por precio</p>
			<input type="Submit" value="Ascendente" name="orden">
			<input type="Submit" value="Descendente" name="orden">
		</form>
	</div>
	<div class="buscador" style="display:inline-block	;  width: 45%;">
		<h1>Buscadores</h1>
		<form action="BuscadorCodigo">
			<input type="text" name="codigo" placeholder="Codigo">
			<input type="submit" value="BuscarPorCodigo">
		</form>
		<br><br>
		<form action="BuscadorNombre">
			<input type="text" name="nombre" placeholder="Nombre">
			<input type="submit" value="BuscarNombre">
		</form>
	</div>
	<br> <br>
	<form action="EntrePrecios" method="get">
		<input type="text" name="max" placeholder="Precio maximo">
		<input type="text" name="min" placeholder="Precio minimo">
		<input type="Submit" value="Mostrar productos entre los 2 precios">
	</form>
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
		<a href="Principal">Recargar Pagina</a>
		<br><br>
		<p>${msg}</p>
		<br><br>	
		<form action="InsertarProducto">
		<h1>INSERTAR PRODUCTO</h1>
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
			<c:forEach items="${Supermercados}" var="supermercado">
				<input type="checkbox" name="supermercados" value="${supermercado.id}">${supermercado.nombre}
			</c:forEach>
			<br><br>
			<input type="submit" value="Insertar Producto">
		</form>
		<br><br><br>
		
</body>
</html>