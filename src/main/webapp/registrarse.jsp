<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Registrarse Runners</title>


		<jsp:include page="/include/cabecera.jsp">
			<jsp:param value="titulo" name="inicio" />
			<jsp:param value="pagina" name="inicio" />
		</jsp:include>

		<div class="alert alert-primary alert-dismissible fade show"
			role="alert">
			<strong>Mensaje</strong> ${mensaje}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>



		<h1 align=center>Registrarse en Runners</h1>

		"${usu}"

		<form action="registrarse" method="post">

				
			<input class="form-control"	name="nombre" type="text" placeholder="Nombre de Usuario">
			<br>	
			<input	class="form-control" name="conse" type="password" placeholder="Contraseña de Usuario"> 
			<br>
			
			<input	class="form-control" name="consedos" type="password" placeholder="Contraseña de Usuario"> 
			<br>

			<button type="submit" class="btn btn-success mb-2">Registrarse</button>

		</form>

		<%@include file="/include/pie.jsp"%>




