<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</br>
	<h3>
		<center><spring:message code="label.seleccion5"/></center>
	</h3></br>

	<form:form method="post" action="comprobante.html" modelAttribute="compra" class="form3">

		<div class="form-group">
			<label for="totalPagar"><spring:message code="label.total"/>$ ${total}</label>
		</div>

		<div class="form-group">
			<label for="titular"><spring:message code="label.titular"/></label> 
			<input type="text" class="form-control" name="titular" id="titular"
				placeholder="<spring:message code="label.titular1"/>" value="${compra.titular}">
			<form:errors path="titular" cssClass="error" />
		</div>

		<div class="form-group">
			<label for="email"><spring:message code="label.email"/></label> 
			<input type="email" class="form-control" id="email" name="email" 
				placeholder="<spring:message code="label.email1"/>" value="${compra.email}">
			<form:errors path="email" cssClass="error" />
		</div>

		<div class="form-group">
			<label for="numtarjeta"><spring:message code="label.tarjeta"/></label> 
			<input type="text" class="form-control" id="numtarjeta" name="numtarjeta"
				maxlength="12" value="${compra.numtarjeta}" placeholder="<spring:message code="label.tarjeta1"/>">
			<form:errors path="numtarjeta" cssClass="error" />
		</div>

		<div class="form-row">
			<div class="form-group col-md-5">
				<label for="codigoseguridad"><spring:message code="label.seguridad"/></label> 
				<input type="text" class="form-control" id="codigoseguridad"
					name="codigoseguridad" maxlength="3" placeholder="<spring:message code="label.seguridad1"/>">
				<form:errors path="codigoseguridad" cssClass="error" />
			</div>
			
			<div class="form-group">
				<label for="vence"><spring:message code="label.vence"/></label>
			</div>
			
			<div class="form-group col-md-2">
				<label for="mesvencimiento"><spring:message code="label.vence.mes"/></label>
				<input type="number" class="form-control" id="mesvencimiento" name="mesvencimiento"
					value="1" min="1" max="12">
			</div>
			<div class="form-group col-md-2">
				<label for="annovencimiento"><spring:message code="label.vence.ano"/></label>
				<input type="number" class="form-control" id="annovencimiento" name="annovencimiento"
					value="18" min="18" max="30">
			</div>
		</div>
		
		<div class="form-group text-right">
			<input type="button" name="cancelar" value="<spring:message code="label.cancelar"/>" 
				onclick="self.location.href = 'inicio.html'" onkeypress="self.location.href = 'inicio.html'"
				class="btn btn-lg btn-dark" role="button" />
			<input type="submit" name="continuar" value="<spring:message code="label.continuar"/>" 
				class="btn btn-lg btn-success" role="button" />		
		</div>
		<input type="hidden" name="fechacompra" value="<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date())%>" />
		<input type="hidden" name="codigocompra" value="${codigocompra}" />
		<input type="hidden" name="numticket" value="${numticket}" />	
	</form:form>