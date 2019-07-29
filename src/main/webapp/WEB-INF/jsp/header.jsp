<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<nav class="navbar navbar-expand-lg navbar-light bg-light"> 
		<a class="navbar-brand" href="<c:url value="inicio.html"/>">Cinecito</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item">
        		<a class="nav-link" href="<c:url value="peli_upload.html"/>"><spring:message code="label.seleccion0" /></a>
     		 </li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <spring:message	code="label.menu1" />
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="?theme=darkly"><spring:message code="label.color1" /></a> 
					<a class="dropdown-item" href="?theme=cosmo"><spring:message code="label.color2" /></a>
				</div>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <spring:message	code="label.menu2" />
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="?lang=es"><spring:message code="label.espanol" /></a> 
					<a class="dropdown-item" href="?lang=en"><spring:message code="label.ingles" /></a>
				</div>
			</li>
		</ul>
		<ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
			<li class="nav-item">
				<img src="img/reloj/dg8.gif" name="hrs1"/>
           		<img src="img/reloj/dg8.gif" name="hrs2"/>
            	<img src="img/reloj/dgc.gif" name="cs"/>
            	<img src="img/reloj/dg8.gif" name="mns1"/>
            	<img src="img/reloj/dg8.gif" name="mns2"/>
            	<img src="img/reloj/dgc.gif" name="cs"/>
            	<img src="img/reloj/dg8.gif" name="ses1"/>
            	<img src="img/reloj/dg8.gif" name="ses2"/>
            	<img src="img/reloj/dgpm.gif" name="ampm"/>
			</li>
		</ul>
	</div>
	</nav>

<script language="javascript"><!-- start
        dg0 = new Image();dg0.src = "img/reloj/dg0.gif";
        dg1 = new Image();dg1.src = "img/reloj/dg1.gif";
        dg2 = new Image();dg2.src = "img/reloj/dg2.gif";
        dg3 = new Image();dg3.src = "img/reloj/dg3.gif";
        dg4 = new Image();dg4.src = "img/reloj/dg4.gif";
        dg5 = new Image();dg5.src = "img/reloj/dg5.gif";
        dg6 = new Image();dg6.src = "img/reloj/dg6.gif";
        dg7 = new Image();dg7.src = "img/reloj/dg7.gif";
        dg8 = new Image();dg8.src = "img/reloj/dg8.gif";
        dg9 = new Image();dg9.src = "img/reloj/dg9.gif";
        dgam= new Image();dgam.src= "img/reloj/dgam.gif";
        dgpm= new Image();dgpm.src= "img/reloj/dgpm.gif";
        dgc = new Image();dgc.src = "img/reloj/dgc.gif";

        function dotime(){
            setTimeout('dotime()',1000);
            d = new Date();
            hr= d.getHours()+100;
            mn= d.getMinutes()+100;
            se= d.getSeconds()+100;
            if(hr==100){hr=112;am_pm='am';}
            else if(hr<112){am_pm='am';}
            else if(hr==112){am_pm='pm';}
            else if(hr>112){am_pm='pm';hr=(hr-12);}
            tot=''+hr+mn+se;
            document.hrs1.src = 'img/reloj/dg'+tot.substring(1,2)+'.gif';
            document.hrs2.src = 'img/reloj/dg'+tot.substring(2,3)+'.gif';
            document.mns1.src = 'img/reloj/dg'+tot.substring(4,5)+'.gif';
            document.mns2.src = 'img/reloj/dg'+tot.substring(5,6)+'.gif';
            document.ses1.src = 'img/reloj/dg'+tot.substring(7,8)+'.gif';
            document.ses2.src = 'img/reloj/dg'+tot.substring(8,9)+'.gif';
            document.ampm.src= 'img/reloj/dg'+am_pm+'.gif';}
        dotime();       
    </script>