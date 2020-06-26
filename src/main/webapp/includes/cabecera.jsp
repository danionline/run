<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    


<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- fontawesome 5 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

	<!-- datatables -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/styles.css">



    <title> ${param.title} | Supermercado</title>
  </head>
  <body onload="init()">
    <nav class="navbar navbar-expand-md navbar-primary fixed-top bg-primary bg-dark">
        <!-- logo -->
        <a class="navbar-brand" href="index.html">
            <img src="imagenes/logolion.jpg" class="imagen"></img>
        </a>

       
      
        <!-- lista enlaces -->
          
          <ul class="navbar-nav mr-auto">
            <li class="nav-item"  >
              <a class="nav-link ${ ( 'inicio' eq param.pagina ) ? 'active' : '' }" href="index.jsp">Inicio</a>
            </li>
            
            
           
           
           
             
             
          <ul class="navbar-nav mr-auto">
            <li class="nav-item"  >
              <a class="nav-link ${ ( 'carreras' eq param.pagina ) ? 'active' : '' }" href="carreras.jsp">Carreras</a>
            </li>
            
             
            
          <ul class="navbar-nav mr-auto">
            <li class="nav-item"  >
              <a class="nav-link ${ ( 'registrarse' eq param.pagina ) ? 'active' : '' }" href="registrarse.jsp">Registrarse</a>
            </li>
           
           
       
            <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle navbar-primary" href="#" id="navbarDropdown " role="button" 
		           data-toggle="dropdown" aria-haspopup="true" 
		           aria-expanded="false">Categorias</a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		        	<c:forEach items="${categorias}" var="categoria">
		          		<a class="dropdown-item" href="inicio?idCategoria=${categoria.id}">${categoria.nombre}</a>
		          	</c:forEach>		          
		        </div>
		    </li>
            
            
            <!-- opciones cuando el usuario esta Logeado -->
            
             <c:if test="${ not empty usuario_login }">
             
            	<li class="nav-item">
              		<a class="nav-link ${ ( 'productos' eq param.pagina ) ? 'active' : '' } "  href="productos">Productos</a>
            	</li>
            	<li class="nav-item">
              		<a class="nav-link ${ ( 'usuario' eq param.pagina ) ? 'active' : '' } "  href="usuario">Usuarios</a>
            	</li>
            	
            </c:if>	           
        
            
      
       
        
         <span class="form-inline">
         	<c:if test="${ empty usuario_login }">
            	  <a class="nav-link  btn btn-outline-warning" href="login.jsp">Iniciar Sesi�n</a>
            </c:if>	  
            
            <c:if test="${ not empty usuario_login }">
            	<span class="badge badge-pill badge-light mr-3">${usuario_login.nombre}</span>
            	<a class="nav-link  btn btn-outline-light" href="logout">Cerrar Sesi�n</a>
            </c:if>
              
         </span>
        
        </div>
      </nav>
      
      <main role="main" class="container">
   			
      	<jsp:include page="alerta.jsp"></jsp:include>
      