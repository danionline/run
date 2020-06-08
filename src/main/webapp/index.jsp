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

<!-- datatables -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/styles.css">



<title>Corredores</title>
</head>


<div class="container">

	<!-- Image and text -->
	<nav class="navbar navbar-dark bg-dark">

		<img src="imagenes/canvas.png" width="30" height="30" alt="pajaro"></img>
		<ul class="navbar-nav n mr-auto mt-2 mt-lg-0">
			<li class="nav-item active"><a class="nav-link" href="#">Corredores</a>
			</li>
		</ul>	
	</nav>

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
</div>