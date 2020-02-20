<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Animes encontrados</title>
	<link rel="stylesheet" type="text/css" href="/css/general.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script type="text/javascript" src="/js/scripts.js"></script>
</head>
<body class="reescalarImagen bodyResult">
<div class="posicionarIzquierda">
	<img class="logoSuccess" src='/images/LogoPequenio.png'>
</div>
<br />
<div class="posicionarDerecha centrarMovil">
	<form id='formNuevaBusqueda' action='/SearchController' method='post'>
		<label for="searchQuery" class="nuevaBusqueda">Nueva búsqueda: </label>
			<input type='text' placeholder='Busca un anime' name='searchQuery' required />
	</form>
</div>
<div class="clear"></div>
<br /><br />
<div class='contenedor'>
	<div class='col-100 tablet-100 movil-100 alinearCentro'>
		<h1 class="titulo"><c:out value="${info.title}" /></h1><br />
		<div id="slider" >
			<a href="#" class="control_next">&gt;</a> <a href="#" class="control_prev">&lt;</a>
			<ul>
				<li>
					<div class="Tumblr">
						<c:choose>
							<c:when test="${not empty param.searchQuery}">
								<c:forEach items="${requestScope.fotos.response}" var="respuesta">
									<c:forEach items="${respuesta.photos}" var="foto">
										<img src="<c:out value="${foto.original_size.url}"/>" />
									</c:forEach>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<span>No hay resultados.</span>
							</c:otherwise>
						</c:choose>
					</div>
				</li>
				<li>
					<div class="Aliexpress">
						<c:choose>
							<c:when test="${not empty param.searchQuery}">
								<c:forEach items="${requestScope.productos.result.products}" var="producto">
									<a target="_blank" href="<c:out value="${producto.productUrl}"/>">${producto.productTitle}</a><br />
									<img src="<c:out value="${producto.imageUrl}"/>" />
									<br /><hr class="lineasResultados">
								</c:forEach>
							</c:when>
							<c:otherwise>
								<span>No hay resultados.</span>
							</c:otherwise>
						</c:choose>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<video id="video" autoplay="autoplay" muted loop>
		<source src="/videos/amv.mp4" type="video/mp4"></source>
	</video>
</div>
</body>
</html>