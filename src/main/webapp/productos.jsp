<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="productos" />
  <jsp:param name="title" value="Productos" /> 
</jsp:include>



	<h1 align="center">Tienda de Productos</h1>

	

	<%
		// Podemos usar el ${}  EL - Expresion Lenguage en los JSPs
		// suele ser mas comodo que tener que usar < % % >, a estos porcentajes se les llama SCRIPLETS
		// ademas se pueden combinar con JSTL - Java Servlet Tag Libraries
	%>	

	
	
	<table class="tabla table table-striped">
		<thead>
			<tr>
				<td>Id</td>
				<td>Nombre</td>
				<td>Precio</td>
				<td>Imagen</td>
				<td>Operaciones</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
				
					<td>${p.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${p.nombre}</td>
					<td>${p.precio} &euro;</td>
					<td><img src="${p.imagen}"  class="img-thumbnail" alt="imagen..."></td>
					<td>
						<a href="creareditarproducto.jsp" class="mr-4"><i class="fa fa-pencil-square fa-2x" style=" color:green" title="Crear Producto"></i></a>
						<a href="creareditarproducto.jsp" class="mr-4"> <i class="far fa-edit fa-2x" title="Editar Producto"></i></a>
						<a href="producto-eliminar?id=${p.id}"
						   onclick="confirmar('${p.nombre}')" 
						   ><i class="fas fa-trash fa-2x" style=" color:yellow" title="Eliminar Producto"></i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<%@include file="includes/pie.jsp" %>

</div>
</body>
