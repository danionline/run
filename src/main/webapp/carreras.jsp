<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



		<jsp:include page="includes/cabecera.jsp">
		<jsp:param value="titulo" name="carreras"/>
		<jsp:param value="pagina" name="Carreras"/>
		</jsp:include>


		
	 	<table class="table">
		<h2>Tabla De Carreras</h2>
			
	 	
			<thead class="thead-dark">
				<tr>
					
					<th scope="col">id</th>
					<th scope="col">Nombre</th>
					<th scope="col">Distancia</th>
					<th scope="col">Tiempo</th>
				</tr>
			</thead>


			<tbody>
			
				<c:forEach items="${carreras}" var="c">
					<tr>

					 
						<td>${c.id}</td>
						<td>${c.nombre}</td>
						<td>${c.distancia}</td>
						<td>${c.tiempo}</td>
					
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@include file="includes/pie.jsp"%>



