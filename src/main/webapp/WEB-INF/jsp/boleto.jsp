<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="js/funciones.js" type="text/javascript"></script> 
</br>
	<h3>
		<center><spring:message code="label.seleccion2"/></center>
	</h3>	</br>
	<form:form method="post" action="asiento.html" modelAttribute="boletoForm" class="form2">
		<c:forEach items="${pago}" var="pago" varStatus="status">
			<div class="form-group row">
				<input type="hidden" name="boletos[${status.index}].idPago" value="${pago.idPago}" /> 
				<label class="col-sm-8 col-form-label">${pago.tipopersonal} | $ ${pago.costo} c/u </label> 
				<input id="number" type="number" name="boletos[${status.index}].cantidadP" value="0"
					class="monto col-sm-3" onchange="sumar(${pago.costo});" min="0" max="50"/>
			</div>
		</c:forEach>

		<div class="form-group row">
			<label class="col-sm-8 col-form-label text-right"><spring:message code="label.total"/></label>
			<div class="col-sm-3">$ <span id="spTotal"></span></div>
		</div>

		<div class="form-group text-right">						
			<input type="button" name="cancelar" value="<spring:message code="label.cancelar"/>" 
				onclick="self.location.href = 'inicio.html'" onkeypress="self.location.href = 'inicio.html'"
				class="btn btn-lg btn-dark" role="button" />
			<input type="submit" name="continuar" value="<spring:message code="label.continuar"/>" 
				class="btn btn-lg btn-success" role="button" />
		</div>
	</form:form>
