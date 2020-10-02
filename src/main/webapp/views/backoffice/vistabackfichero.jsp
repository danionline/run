<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>vistaFicheroOfice</title>
</head>
<body>

	

<h2>mensaje: ${mensaje }</h2>
<h2>tiempo:  ${fichero }</h2>
<h2>caracteres de linea: ${cont }</h2>
<h2>numLineas: ${numero_lineas }</h2>
<h2>numLineasDuplicadas: ${ numLineasDuplicadas}</h2>
<h2>numeroInsercciones: ${numero_insercciones }</h2>
<h2>numero errores campos: ${numero_errores_campos }</h2>
<h2>numero errores nombre: ${numero_errores_nombre }</h2>
</body>
</html>