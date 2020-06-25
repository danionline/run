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



<title>Formulario registros de Carreras</title>
</head>
<body>
	<div class="container">

		<jsp:include page="includes/cabecera.jsp">
			<jsp:param name="pagina" value="inicio" />
			<jsp:param name="title" value="Inicio" />
		</jsp:include>

		<div class="alert alert-primary alert-dismissible fade show"
			role="alert">
			<strong>Mensaje</strong> ${mensaje}
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<form action="registro" method="post">
			<label for="textlabel" class="col-sm-3 col-form-label">ID de la	Carrera</label>
			
			<input class="form-control" name="ide" type="text" placeholder="ID de la Carrera"> 
		
			<label for="textlabel"	class="col-sm-3 col-form-label">Nombre de la Carrera</label> 
			
			<input class="form-control" name="nombre" type="text" placeholder="Nombre de la Carrera">
			
			<label for="textlabel" class="col-sm-3 col-form-label">Distancia</label>
				 
			<input class="form-control" name="distancia" type="text" placeholder="Distancia de la Carrera">
				
			<label for="textlabel" class="col-sm-3 col-form-label">Tiempo</label> 
			
			<input	class="form-control" name="tiempo" type="text" placeholder="Tiempo">
			<br>
		
			<button type="submit" class="btn btn-primary mb-2">Editar Carrera</button>
			<br>
			</form>
			<form action="registro" method="post">
			<label for="textlabel" class="col-sm-3 col-form-label">ID de la	Carrera</label>
			<input class="form-control" name="idcrear" type="text" placeholder="ID de la Carrera"> 
			<br>
			<button type="submit" class="btn btn-success mb-2">Crear Carrera</button>
			</form>

	
		<br>

		<form action="eliminaregistros" method="post">
			<label for="textlabel" class="col-sm-3 col-form-label">ID de la Carrera</label>
			
			<input class="form-control" name="ideliminar" type="text" placeholder="ID de la Carrera">
			 <br>
			
			<button type="submit" class="btn btn-warning mb-2">Eliminar</button>
		</form>






		<%@include file="includes/pie.jsp"%>

	</div>


</body>

</html>

