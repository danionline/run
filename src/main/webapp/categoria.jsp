
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="include/cabecera.jsp">
	<jsp:param name="pagina" value="categorias" />
	<jsp:param name="title" value="Categorias" />
</jsp:include>









<h2>${cabecera}</h2>



<div class="row-card">
	
	
	<c:forEach items="${productos}" var="p">

		<div class="card">

			<img src="${p.imagen}" class="img-responsive" alt="Cinque Terre"></img>


			<div class="card-body">

				<h4 class="card-title">
					<strong>Categorias</strong>
				</h4>
				<p class="badge badge-pill badge-primary"></p>
     <p class="badge badge-pill badge-primary">${categoria.nombre }</p>
				<h5 class="card-title">${p.nombre}</h5>
				<p class="card-text">${p.precio}Euros.</p>


			</div>
		</div>
	</c:forEach>
</div>



<%@include file="include/pie.jsp"%>


