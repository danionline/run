<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<title>Iniciar Sesion</title>



	<jsp:include page="include/cabecera.jsp" >
		<jsp:param value="titulo" name="inicio"/>
		<jsp:param value="pagina" name="inicio"/>
		</jsp:include>
		
		
		
		<h1 align=center>Iniciar Session en Runners</h1>


	<form action="sesion" method="post">

	
		<label for="textlabel"	class="col-sm-3 col-form-label">Nombre del Corredor</label>			
		<input class="form-control" name="nombre" type="text" placeholder="Nombre deL Corredor">
	
		<label for="textlabel" class="col-sm-3 col-form-label">Contraseña</label>			
		<input class="form-control" name="contrasena" type="text" placeholder="Contrasena"> 
		<br>	
		<button type="submit" class="btn btn-success mb-2">Iniciar Sesion</button>
	</form>	
	
	
		
	<%@include file="/include/pie.jsp"%>


