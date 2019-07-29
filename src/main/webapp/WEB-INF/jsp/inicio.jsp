<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/carousel.css">

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<c:forEach items="${peliculas}" var="pelicula" varStatus="status">
				<li data-target="#myCarousel" data-slide-to="${status.index}"
					<c:if test="${status.index < 1}"> class="active"</c:if>>
				</li>
			</c:forEach>
		</ol>
		<div class="carousel-inner">
			<c:forEach items="${peliculas}" var="pelicula" varStatus="status">
				<c:if test="${status.index < 1}">
					<div class="carousel-item active">
				</c:if>
				<c:if test="${status.index >= 1}">
					<div class="carousel-item">
				</c:if>
				<img class="first-slide"
					src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
					alt="First slide">
				<div class="container">
					<div class="carousel-caption text-left">
						<div class="form-group row">
							<img src="${pelicula.imagen}" class="col-sm-3 col-form-label" width="180" height="280" />
							<div class="col-sm-9">
								<h3><spring:message code="label.titulo" />${pelicula.titulo}</h3>
								<p><spring:message code="label.descripcion" />${pelicula.descripcion}</p>
								<form:form method="post" action="pelicula.html" modelAttribute="peliElegida">
									<input type="submit" name="ver" value="<spring:message code="label.ver"/>"
										class="btn btn-primary mb-2" role="button" />
									<input type="hidden" name="idpelicula" value="${pelicula.idpelicula}" />
								</form:form>
							</div>
						</div>
					</div>
				</div>
		</div>
		</c:forEach>
	</div>
	<a class="carousel-control-prev" href="#myCarousel" role="button"
		data-slide="prev"> <span class="carousel-control-prev-icon"
		aria-hidden="true"></span> <span class="sr-only">Previous</span></a>
	<a class="carousel-control-next" href="#myCarousel" role="button"
		data-slide="next"> <span class="carousel-control-next-icon"
		aria-hidden="true"></span> <span class="sr-only">Next</span></a>
	</div>