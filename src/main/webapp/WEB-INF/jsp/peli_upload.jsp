<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</br><h3><center><spring:message code="label.seleccion0" /></center></h3></br>

<form:form method="post" action="inicio_upload.html" modelAttribute="peliForm" enctype="multipart/form-data" class="form3">

	<input type="hidden" name="idpelicula" value="${peliForm.idpelicula}" />

	<div class="form-group">
		<label for="imagen"><spring:message code="label.imagen" /></label> 
		<input type="file" class="form-control" name="imagen" id="imagen" value="${peliForm.imagen}"/>
		<form:errors path="imagen" cssClass="error" />
	</div>

	<div class="form-group">
		<label for="titulo"><spring:message code="label.titulo" /></label>
		<input type="text" class="form-control" id="titulo" name="titulo"
			placeholder="<spring:message code="label.titulo"/>"	value="${peliForm.titulo}" />
		<form:errors path="titulo" cssClass="error" />
	</div>

	<div class="form-group">
		<label for="descripcion"><spring:message code="label.descripcion" /></label>
		<textarea class="form-control" id="descripcion" name="descripcion"
			rows="2" value="${peliForm.descripcion}" placeholder="<spring:message code="label.descripcion"/>"></textarea>
		<form:errors path="descripcion" cssClass="error" />
	</div>

	<div class="form-group">
		<label for="clasificacion"><spring:message code="label.clasificacion" /></label> 
		<select class="form-control" multiple size="3" id="clasificacion" 
			value="${peliForm.clasificacion}" name="clasificacion">
			<option selected="true" disabled="disabled">Seleccione la(s) clasificación(es)</option>
			<option value="Drama">Drama</option>
			<option value="Comedia">Comedia</option>
			<option value="Acción">Acción</option>
			<option value="Ciencia ficción">Ciencia ficción</option>
			<option value="Fantasía">Fantasía</option>
			<option value="Terror">Terror</option>
			<option value="Romance">Romance</option>
			<option value="Musical">Musical</option>
			<option value="Melodrama">Melodrama</option>
			<option value="Suspense">Suspense</option>
		</select>
		<form:errors path="clasificacion" cssClass="error" />
	</div>

	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="cine"><spring:message code="label.cine" /></label> 
			<select	class="form-control" id="cine" value="${peliForm.cine}" name="cine" onchange="CambiaValue()">
				<option selected="true" disabled="disabled">Seleccione un cine</option>
				<option value="Cinépolis Oasis Coyoacán">Cinépolis Oasis Coyoacán</option>
				<option value="Cinemex Patio Revolución Platino">Cinemex Patio Revolución Platino</option>
				<option value="Cinemex Galerías Coapa">Cinemex Galerías Coapa</option>
				<option value="Cinépolis Paseo Acoxpa">Cinépolis Paseo Acoxpa</option>
			</select>
			<form:errors path="cine" cssClass="error" />
		</div>

		<div class="form-group col-md-3">
			<label for="latitud"><spring:message code="label.latitud" /></label>
			<input type="text" class="form-control" id="latitud" value="${peliForm.latitud}" name="latitud" readonly />
			<form:errors path="latitud" cssClass="error" />
		</div>

		<div class="form-group col-md-3">
			<label for="longitud"><spring:message code="label.longitud" /></label>
			<input type="text" class="form-control" id="longitud" value="${peliForm.longitud}" name="longitud" readonly />
			<form:errors path="longitud" cssClass="error" />
		</div>
	</div>

	<div class="form-row">
		<div class="form-group col-md-3">
			<label for="version"><spring:message code="label.version" /></label>
			<input type="text" class="form-control" id="version" value="${peliForm.version}" name="version"
				placeholder="<spring:message code="label.version"/>" />
			<form:errors path="version" cssClass="error" />
		</div>

		<div class="form-group col-md-3">
			<label for="sala"><spring:message code="label.sala" /></label> 
			<input type="text" class="form-control" id="sala" value="${peliForm.sala}"
				name="sala" placeholder="<spring:message code="label.sala"/>" />
			<form:errors path="sala" cssClass="error" />
		</div>

		<div class="form-group col-md-3">
			<label for="dia"><spring:message code="label.dia" /></label> 
			<input	type="date" class="form-control" id="dia" value="${peliForm.dia}"
				min="2018-06-11" name="dia"	placeholder="<spring:message code="label.dia"/>"/>
			<form:errors path="dia" cssClass="error" />
		</div>

		<div class="form-group col-md-3">
			<label for="hora"><spring:message code="label.hora" /></label> 
			<input type="time" class="form-control" id="horario" onchange="onTimeChange()" 
				value="${peliForm.hora}" name="horario" placeholder="<spring:message code="label.hora"/>" /> 
			<input type="hidden" id="hora" name="hora" value="" />
			<form:errors path="hora" cssClass="error" />
		</div>
	</div>
	
	<div class="form-group text-right">
		<input type="button" name="cancelar" value="<spring:message code="label.cancelar"/>" 
			onclick="self.location.href = 'inicio.html'" onkeypress="self.location.href = 'inicio.html'"  
			class="btn btn-lg btn-dark" role="button" />
		<input type="submit" name="continuar" value="<spring:message code="label.continuar"/>" 
			class="btn btn-lg btn-success" role="button" />		
	</div>

</form:form>