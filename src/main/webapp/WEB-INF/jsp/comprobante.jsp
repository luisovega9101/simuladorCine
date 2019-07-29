<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</br>
	<h3>
		<center><spring:message code="label.texto1"/></center>
	</h3></br>
	<form:form method="post" action="/index.html" class="form-horizontal">
	
		<div class="form-group">
			<label class="text-center"><spring:message code="label.texto2"/></label>
		</div>

		<div class="form-group row">
			<label class="col-sm-5 col-form-label text-right"><spring:message code="label.codigo"/></label>
			<div class="col-sm-6">${compra.codigocompra}</div>
		</div>

		<div class="form-group">
			<label for="totalPagar"><spring:message code="label.datos"/></label>
		</div>

		<div class="form-group row">
			<label class="col-sm-5 col-form-label text-right"><spring:message code="label.titulo"/></label>
			<div class="col-sm-6">${peliElegida.titulo}</div>
		</div>

		<div class="form-group row">
			<label class="col-sm-5 col-form-label text-right"><spring:message code="label.version"/></label>
			<div class="col-sm-6">${peliElegida.version}</div>
		</div>

		<div class="form-group row">
			<label class="col-sm-5 col-form-label text-right"><spring:message code="label.dia"/></label>
			<div class="col-sm-6">${peliElegida.dia}</div>
		</div>

		<div class="form-group row">
			<label class="col-sm-5 col-form-label text-right"><spring:message code="label.hora"/></label>
			<div class="col-sm-6">${peliElegida.hora}</div>
		</div>

		<div class="form-group row">
			<label class="col-sm-5 col-form-label text-right"><spring:message code="label.cine"/></label>
			<div class="col-sm-6">${peliElegida.cine}</div>
		</div>

		<div class="form-group row">
			<label class="col-sm-5 col-form-label text-right"><spring:message code="label.sala"/></label>
			<div class="col-sm-6">${peliElegida.sala}</div>
		</div>

		<div class="form-group row">
			<label class="col-sm-5 col-form-label text-right"><spring:message code="label.boletos"/></label>
			<div class="col-sm-6">${boletin}</div>
		</div>

		<div class="form-group row">
			<label class="col-sm-5 col-form-label text-right"><spring:message code="label.asientos"/></label>
			<div class="col-sm-6">${asientos}</div>
		</div>

		<div class="form-group row">
			<label class="col-sm-5 col-form-label text-right"><spring:message code="label.pagado"/></label>
			<div class="col-sm-6">$ ${total}</div>
		</div>

		<div class="form-group">
			<label><spring:message code="label.datos1"/></label>
		</div>

		<div class="form-group row">
			<label class="col-sm-5 col-form-label text-right"><spring:message code="label.complejo"/></label>
			<div class="col-sm-6">VIT</div>
		</div>

		<div class="form-group row">
			<label class="col-sm-5 col-form-label text-right"><spring:message code="label.ticket"/></label>
			<div class="col-sm-6">${compra.numticket}</div>
		</div>

		<div class="form-group row">
			<label class="col-sm-5 col-form-label text-right"><spring:message code="label.fecha"/></label>
			<div class="col-sm-6">${compra.fechacompra}</div>
		</div>
		
		<a class="btn btn-primary btn-lg btn-block" target="_blank" 
			href="${pageContext.request.contextPath}/download2/es.html"><spring:message code="label.comprobanteES"/></a>
		<a class="btn btn-secondary btn-lg btn-block" target="_blank" 
			href="${pageContext.request.contextPath}/download2/en.html"><spring:message code="label.comprobanteEN"/></a>
		
	</form:form>