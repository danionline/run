  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Bootstrap 4, RunnerS</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <body>

    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">
			 
				
				 
				 
				 
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="navbar-toggler-icon"></span>
				</button> <a class="navbar-brand" href="index.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">RunnerS</font></font></a>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="navbar-nav">
						<li class="nav-item"  >
             				 <a class="nav-link ${ ( 'registrarse' eq param.pagina ) ? 'active' : '' }" href="registrarse.jsp">Registrarse</a>
            			</li>  
						 <li class="nav-item"  >
             		 <a class="nav-link ${ ( 'carreras' eq param.pagina ) ? 'active' : '' }" href="carreras">Carreras</a>
           			</li>
           			<li class="nav-item"  >
             	 <a class="nav-link ${ ( 'productos' eq param.pagina ) ? 'active' : '' }" href="productos">Productos</a>
            		
            		</li>
						<li class="nav-item dropdown">
							 <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Categorias</font></font></a>
							
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">    
		        					<c:forEach items="${categorias}" var="categoria">
		          				<a class="dropdown-item" href="inicio?idCategoria=${categoria.id}">${categoria.nombre}</a>
		          					</c:forEach>		          
		    					</div>
		    				
							
						</li>
					</ul>
				</div>
				
				 <div class="col-md-2">
						
					
							<ul class="navbar-nav">
								<li class="nav-item"  >
					
					
							<c:if test="${ empty sessionScope.usuario_login }">
            	 				 <a class="nav-link  btn btn-outline-warning" href="login.jsp">Iniciar Sesión</a>
            				</c:if>	  
            
            				<c:if test="${ not empty sessionScope.usuario_login }">
            					<span class="badge badge-pill badge-light mr-3">${sessionScope.usuario_login.nombre}</span>
            					<a class="nav-link  btn btn-outline-light" href="logout">Cerrar Sesión</a>
            				</c:if>
					
							</ul>
							</div>
						</nav>
					</div>
				</div>
				
			</div>	 
					
	
            
                       
               	
         
        
            
       
     
       
         
       
       
     	
  </nav>

    
      
      <main role="main" id="container">
   			
      	<jsp:include page="alerta.jsp"></jsp:include>
      