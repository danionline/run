<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/cabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
	<jsp:param name="title" value="Inicio" />
</jsp:include>



	<div class="row-card">

		<c:forEach items="${productos}" var="p">

			<div class="card">
			
				<img src="${p.imagen}" class="img-responsive" alt="Cinque Terre">


				<div class="card-body">
					<h5 class="card-title">${p.nombre}</h5>
					<p class="card-text">${p.precio}Euros.</p>
					<p>
						<span class="badge badge-pill badge-primary" class="card-text">${p.categoria.nombre }</span>
					</p>

				</div>
			</div>
		</c:forEach>
	</div>






	<%@include file="includes/pie.jsp"%>

