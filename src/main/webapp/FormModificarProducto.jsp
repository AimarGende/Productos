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
	<form action="ModificarProducto" method="post">
			<br><br>
			<p>${msg}</p>
			<br><br>
			<label>ID: ${Producto.id}</label>
			<input type="hidden" name="id" value="${Producto.id}">
			<label>Codigo</label>
			<input type="text" name="codigo" placeholder="codigo" value="${Producto.codigo}">
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
				<%boolean esta = false; %>
				<c:forEach items="${supermercadosProducto}" var="superproductos">
						<c:if test="${supermercado.id==superproductos.id}">
							<%esta=true;%>
						</c:if>
				</c:forEach>
				<%if(esta){
					%><input type="checkbox" checked name="supermercados" value="${supermercado.id}">${supermercado.nombre}<%
				}else{ %>
					<input type="checkbox" name="supermercados" value="${supermercado.id}">${supermercado.nombre}<%
				}%>
			</c:forEach>
			<br><br>
			<input type="submit" value="Modificar Producto">
	</form>
</body>
</html>