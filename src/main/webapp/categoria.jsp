
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="include/cabecera.jsp">
	<jsp:param name="pagina" value="categorias" />
	<jsp:param name="title" value="Categorias" />
</jsp:include>






 <STYLE type="text/css">
 			 H1 { text-align: center}
 			</STYLE>
 			<H1>Productos por Categoria</H1>


		<div class="row">
			<c:forEach items="${productos}" var="p">
  				<div class="col-sm-3">
					<div class="card-group">
  						<div class="card" style="width: 18rem;">
  						
    					<img class="card-img-top" src="${p.imagen}" alt="Card image cap">
    					<div class="card-body">
      					<h5 class="card-title"><span class="badge badge-warning">${p.categoria.nombre}</span></h5>
      					<p class="card-text">${p.nombre }</p>
      					<p class="card-text">${p.precio}Euros.</p>
   						</div>
   					</div>
   				</div>	
   			</div>	
   			 </c:forEach>
   		 </div>
    
    
  	
	

		


<%@include file="include/pie.jsp"%>


