<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</br><h2>
	<center><spring:message code="label.seleccion1" /></center>
</h2></br>
<form:form method="post" action="boleto.html" class="form1">
	<div class="container">
		<div class="row">
			<div class="col-sm-5 col-md-3">
				<a target="_blank" href="${pageContext.request.contextPath}/download/${peliElegida.idpelicula}.html" download>
			   <img	id="zoom" src="${peliElegida.imagen}" width="200" height="220" title="Download this image"/></a>
			</div>

			<div class="col-sm-6 col-md-5">
				<b><spring:message code="label.titulo" /></b> ${peliElegida.titulo}</br>
				<b><spring:message code="label.clasificacion" /></b>${peliElegida.clasificacion}</br>
				<b><spring:message code="label.version" /></b>${peliElegida.version}</br> 
				<b><spring:message code="label.cine" /></b>${peliElegida.cine}</br> 
				<b><spring:message code="label.sala" /></b> ${peliElegida.sala} </br> 
				<b><spring:message code="label.dia" /></b> ${peliElegida.dia} </br> 
				<b><spring:message code="label.hora" /></b> ${peliElegida.hora} </br>  
				<input type="button" name="cancelar" value="<spring:message code="label.cancelar"/>"
					onclick="self.location.href = 'inicio.html'" onkeypress="self.location.href = 'inicio.html'"
					class="btn btn-dark mb-2" role="button" />
				<input type="submit" name="comprar" value="<spring:message code="label.comprar"/>"
					class="btn btn-success mb-2" role="button" /> </br>
			</div>
			<div class="col-sm-13 col-md-4">
				<div id="mapa">
					<input type="hidden" value="${peliElegida.latitud}" id="v_latitud" />
					<input type="hidden" value="${peliElegida.longitud}" id="v_longitud" />
				</div>
			</div>
		</div>
	</div>
</form:form>