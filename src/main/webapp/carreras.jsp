<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!doctype html>
<html lang="es">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- fontawesome 5 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">



<!-- Custom CSS -->
<link rel="stylesheet" href="css/styles.css">



<title>Corredores</title>
</head>

<body>
	<div class="container">

		<jsp:include page="includes/cabecera.jsp">
		<jsp:param value="titulo" name="carreras"/>
		<jsp:param value="pagina" name="carreras"/>
		</jsp:include>



		<h1 align="center">Tabla de las carreras</h1>
		<table class="table">
			<thead class="bg-primary">

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
	</div>


</body>

</html>