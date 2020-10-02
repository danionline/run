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

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/styles.css">

	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    <title> ${param.title} | Runners</title>
  </head>
  <body onload="init()" >


      <div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">
				 
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="navbar-toggler-icon"></span>
					</button> <a class="navbar-brand" href="index.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">RUNNERS</font></font></a>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="navbar-nav mr-auto">
           				 <li class="nav-item"  >
            			  <a class="nav-link ${ ( 'eliminarusuarios' eq param.pagina ) ? 'active' : '' }" href="eliminarusuarios.jsp">Darse de Baja</a>
            			</li>
          			</ul>
            
          <ul class="navbar-nav mr-auto">
            	<li class="nav-item"  >
             	 <a class="nav-link ${ ( 'registrarse' eq param.pagina ) ? 'active' : '' }" href="registrarse.jsp">Registrarse</a>
            	</li>     
           </ul>
           
            <ul class="navbar-nav mr-auto">
          		  <li class="nav-item"  >
             		 <a class="nav-link ${ ( 'carreras' eq param.pagina ) ? 'active' : '' }" href="carreras">Carreras</a>
           			</li>
           </ul>
           
			<ul class="navbar-nav mr-auto">
            	<li class="nav-item"  >
             	 <a class="nav-link ${ ( 'productos' eq param.pagina ) ? 'active' : '' }" href="productos">Productos</a>
            		
            	</li>
           	</ul>
       
            <div class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle navbar-primary" href="#" id="navbarDropdown " role="button" 
		           data-toggle="dropdown" aria-haspopup="true" 
		           aria-expanded="false">Categorias</a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">    
		        	<c:forEach items="${categorias}" var="categoria">
		          		<a class="dropdown-item" href="inicio?idCategoria=${categoria.id}">${categoria.nombre}</a>
		          	</c:forEach>		          
		    	</div>
		    </div>	
		             
   </div></nav></div></div>
        
         
         	
         
         	<c:if test="${ empty sessionScope.usuario_login }">
            	  <a class="nav-link  btn btn-outline-warning" href="views/login.jsp">Iniciar Sesión</a>
            </c:if>	  
            
            <c:if test="${ not empty sessionScope.usuario_login }">
            	<span class="badge badge-pill badge-light mr-3">${sessionScope.usuario_login.nombre}</span>
            	<a class="nav-link  btn btn-outline-light" href="logout">Cerrar Sesión</a>
            </c:if>
              
         
				</div>
			</nav>
       
      
        <!-- lista enlaces -->
          
          
            
                       
               	
         
        
            
       
     
       
         
       
       
     	
  </nav>

    
      
      <main role="main" id="container">
   			
      	<jsp:include page="alerta.jsp"></jsp:include>
      