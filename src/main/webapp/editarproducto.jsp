





<title>Editar  Producto</title>

		<jsp:include page="include/cabecera.jsp">
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

		<form action="crear-producto" method="post">
			
			<label for="textlabel"	class="col-sm-3 col-form-label">ID del Producto</label> 
			
			<input class="form-control" value="${productos.id}" type="text">
		
		
			<label for="textlabel"	class="col-sm-3 col-form-label">Nombre del Producto</label> 
			
			<input class="form-control" name="nombre" type="text" placeholder="Nombre del Producto">
			
			<label for="textlabel" class="col-sm-3 col-form-label">Precio</label>
				 
			<input class="form-control" name="precio" type="text" placeholder="Precio">
				
			
			
			<button type="submit" class="btn btn-primary mb-2">Editar Producto</button>
			</form>
			
	
		<%@include file="include/pie.jsp"%>






