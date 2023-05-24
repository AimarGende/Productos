<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>MODIFICAR</h1>
	<form action="ModificarProducto" method="post">
			<p>${msg}</p>
			<label>ID: ${Producto.id}</label>
			<input type="hidden" name="id" value="${Producto.id}">
			<label>Codigo: ${Producto.codigo}</label>
			<input type="hidden" name="codigo" placeholder="codigo" value="${Producto.codigo}">
			<br><br>
			<label>Nombre</label>
			<input type="text" name="nombre" placeholder="Nombre" value="${Producto.nombre}">
			<br><br>
			<label>Cantidad</label>
			<input type="text" name="cantidad" placeholder="cantidad" value="${Producto.cantidad}">
			<br><br>
			<label>Precio</label>
			<input type="text" name="precio" placeholder="Precio" value="${Producto.precio}">
			<br><br>
			<label>Caducidad</label>
			<input type="date" name="caducidad" value="${Producto.caducidad }">
			<br><br>
			<label>Seccion</label>
			<select name="id_seccion">
				<option value=0></option>
				<c:forEach items="${Secciones}" var="seccion">
					<c:choose>
						<c:when test="${Producto.seccion.id==seccion.id}">
							<option selected value="${seccion.id}">${seccion.nombre}</option>
						</c:when>
						<c:otherwise>
							<option value="${seccion.id}">${seccion.nombre}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			<br><br>
			<c:forEach items="${supermercados}" var="supermercado">
				<c:set var="esta" value="No esta"></c:set>
				<c:forEach items="${supermercadosProducto}" var="superproductos">
						<c:if test="${supermercado.id==superproductos.id}">
							<c:set var="esta" value="Esta"></c:set>
						</c:if>
				</c:forEach>
				<c:choose>
					<c:when test="${esta eq 'Esta'}">
						<input type="checkbox" checked name="supermercados" value="${supermercado.id}">${supermercado.nombre}
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="supermercados" value="${supermercado.id}">${supermercado.nombre}
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<br><br>
			<input type="submit" value="Modificar Producto">
	</form>
	<a href="Principal">Volver</a>
</body>
</html>