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
  
  <jsp:include page="include/cabecera.jsp">
	<jsp:param name="pagina" value="Inicio" />
	<jsp:param name="title" value="Inicio" />
</jsp:include>
  <body>


 <div class="col-md-2">
						
					
							<ul class="navbar-nav">
								<li class="nav-item"  >
					
					
							<c:if test="${ empty sessionScope.usuario_login }">
            	 				 <a class="nav-link  btn btn-outline-warning mb-4" href="login.jsp">Iniciar Sesión</a>
            				</c:if>	  
            
            				<c:if test="${ not empty sessionScope.usuario_login }">
            					<span class="badge badge-pill badge-light mr-3">${sessionScope.usuario_login.nombre}</span>
            					<a class="nav-link  btn btn-outline-light" href="logout">Cerrar Sesión</a>
            				</c:if>
					
							</ul>
							</div>
					
  




    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		
				
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
				</div> <a class="carousel-control-prev" href="#carousel-722381" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Anterior</font></font></span></a> <a class="carousel-control-next" href="#carousel-722381" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">del mes prÃ³ximo</font></font></span></a>
			</div>
			 <STYLE type="text/css">
 			 H2 { text-align: center}
 			</STYLE>
 			<H2>RunnerS</H2>
 			
			 <STYLE type="text/css">
 				p{ text-align: center}
 				
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