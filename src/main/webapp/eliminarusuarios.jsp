<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<title>Eliminarse Runners</title>


	


		<jsp:include page="/includes/cabecera.jsp" >
		<jsp:param value="titulo" name="inicio"/>
		<jsp:param value="pagina" name="inicio"/>
		</jsp:include>
		
		<div class="alert alert-primary alert-dismissible fade show"
			role="alert">
			<strong>Mensaje</strong> ${mensaje}
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		
		
		
		

		<h1 align=center>Eliminarse en Runners</h1>

		<form action="eliminar" method="get">
				
				<input type="text" name="ide" value="">
			
     			<button type="submit" class="btn btn-warning mb-2">Eliminar</button>
				</form>
			
		

		
	


		<%@include file="/includes/pie.jsp"%>

	</div>



