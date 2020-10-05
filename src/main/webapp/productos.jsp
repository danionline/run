<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<jsp:include page="include/cabecera.jsp" >
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
				<td>Categoria</td>
				<td>Imagen</td>
				
			</tr>
		</thead>
		<tbody>
	
			<c:forEach items="${productos}" var="p">
				<tr>
				
					<td>${p.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${p.nombre}</td>
					<td>${p.precio} &euro;</td>
					<td>${p.categoria.nombre}</td>
					<td><img src="${p.imagen}"  class="img-thumbnail" alt="imagen..."></td>
					<td>
					
						<a href="crearproducto.jsp" class="btn btn-xs btn-success">[+] <span class="glyphicon glyphicon-registration-mark"></span></a>
						
						<a href="editarproducto.jsp?id=${p.id}" class="btn btn-xs btn-info">[=] <span class="glyphicon glyphicon-registration-mark"></span></a>
						<a href="producto-eliminar?id=${p.id}"  onclick="confirmar('${p.nombre}')" ><i class="btn btn-xs btn-warning">[-]</i> <span class="glyphicon glyphicon-registration-mark"></span></a>					
						
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<%@include file="include/pie.jsp" %>


