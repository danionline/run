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
				
				</nav>
				</div>
				
			</div>	 
					
					
			
			<div class="carousel slide" id="carousel-722381">
				<ol class="carousel-indicators">
					<li data-slta-target="#carousel-722381">
					</li>
					<li data-slide-to="1" data-target="#carousel-722381" class="active">
					</li>
					<li data-slide-to="2" data-target="#carousel-722381">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item">
						<img class="d-block w-100" alt="Bootstrap de carrusel primero" src="https://www.layoutit.com/img/sports-q-c-1600-500-1.jpg">
						<div class="carousel-caption">
							<h4><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">RunnerS
								
							</font></font></h4>
							<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
							 </font><font style="vertical-align: inherit;"> </font><font style="vertical-align: inherit;">
							</font></font></p>
						</div>
					</div>
					<div class="carousel-item active">
						<img class="d-block w-100" alt="Carrusel Bootstrap Second" src="https://www.layoutit.com/img/sports-q-c-1600-500-2.jpg">
						<div class="carousel-caption">
							<h4><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">RunnerS
								
							</font></font></h4>
							<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
								 </font><font style="vertical-align: inherit;"> </font><font style="vertical-align: inherit;">
							</font></font></p>
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" alt="Carrusel Bootstrap Third" src="https://www.layoutit.com/img/sports-q-c-1600-500-3.jpg">
						<div class="carousel-caption">
							<h4><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">RunnerS
								
							</font></font></h4>
							<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
								 </font><font style="vertical-align: inherit;"> </font><font style="vertical-align: inherit;">
							</font></font></p>
						</div>
					</div>
				</div> <a class="carousel-control-prev" href="#carousel-722381" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Anterior</font></font></span></a> <a class="carousel-control-next" href="#carousel-722381" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">del mes próximo</font></font></span></a>
			</div>
			 <STYLE type="text/css">
 			 H2 { text-align: center}
 			</STYLE>
 			<H2>RunnerS</H2>
 			
			  <STYLE type="text/css">
 				p { text-align: center}
 			</STYLE>
			<p style center" >Web basada en deportes y para el deporte, make of JAVA and BOOTSRAP.</p>
		</div>
	</div>
</div>
<%@include file="include/pie.jsp"%>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>