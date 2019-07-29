<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
	<h3>
		<center><spring:message code="label.seleccion3"/></center>
	</h3>
	<form:form method="post" action="comprar.html" modelAttribute="boleto" class="form2">
		<div class="form-group">
			<img class="zoom" src="img/pantalla.jpg" /> 
			<label class="text-center"><spring:message code="label.seleccion4"/></label> 
			<input id="asientos" type="text" class="form-control" name="asientos"
				value="${boleto.asientos}" align="right" placeholder="A3, B6" /></br>
			<form:errors path="asientos" cssClass="error" />
		</div>
		
		<div class="form-group text-right">						
			<input type="button" name="atras" value="<spring:message code="label.atras"/>" 
				onclick="self.location.href = 'comprar_atras.html'" onkeypress="self.location.href = 'comprar_atras.html'"
				class="btn btn-lg btn-dark" role="button" />
			<input type="submit" name="continuar" value="<spring:message code="label.continuar"/>" 
				class="btn btn-lg btn-success" role="button" />
		</div>
	</form:form>
		
	<script> 
// Comentario en bloque script
function split( val ) {     
	return val.split( /,\s*/ ); 
  } 
  
function extractLast( term ) {     
	return split( term ).pop(); 
  }   
  
$(document).ready( function() { 	
	$( "#asientos" ).autocomplete({ 
		source: function( request, response ) { 
			$.getJSON( "${pageContext.request.contextPath}/asiento_asientos_list.html", 
					   { term : extractLast( request.term ) }, response ); 							
	   }, // function
	// Eventos en el autocomplete:
    // Evita llamar al autocomplete cuando se hace backspace	   
	search: function () { 
		// custom minLength 
		 var term = extractLast( this.value ); 
		 if ( term.length < 1 ) { 
			 return false; // No ejecuta el autocomplete	 
		 }
	 }, 	
	 focus: function () { 
		// prevent value inserted on focus  
		 return false; // No ejecuta el autocomplete
	 },
	 select: function( event, ui ) { 
		 var terms = split( this.value );  
		// remove the current input 
		 terms.pop(); 
		// add the selected item 
		 terms.push( ui.item.value ); 
		// add placeholder to get the comma-and-space at the end 
		 terms.push( "" ); 
		 this.value = terms.join( ", " ); 
		 return false; // No ejecuta el autocomplete
	   }
    }); // #technologies-autocomplete
    
}); // document-ready-function
</script>   