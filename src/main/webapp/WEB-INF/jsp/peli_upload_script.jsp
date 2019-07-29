<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script>	
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1; //January is 0!
	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd
	}
	if (mm < 10) {
		mm = '0' + mm
	}
	today = yyyy + '-' + mm + '-' + dd;
	document.getElementById("dia").setAttribute("min", today);

	function CambiaValue() {
		var cine = document.getElementById('cine').value;
		if (cine == 'Cinépolis Oasis Coyoacán') {
			document.getElementById("latitud").setAttribute("value",
					'19.345393');
			document.getElementById("longitud").setAttribute("value",
					'-99.180295');
		} else if (cine == 'Cinemex Patio Revolución Platino') {
			document.getElementById("latitud").setAttribute("value",
					'19.3418511');
			document.getElementById("longitud").setAttribute("value",
					'-99.1913404');
		} else if (cine == 'Cinemex Galerías Coapa') {
			document.getElementById("latitud").setAttribute("value",
					'19.3024951');
			document.getElementById("longitud").setAttribute("value",
					'-99.1225693');
		} else if (cine == 'Cinépolis Paseo Acoxpa') {
			document.getElementById("latitud").setAttribute("value",
					'19.3002611');
			document.getElementById("longitud").setAttribute("value",
					'-99.1369099');
		}
	}

	function onTimeChange() {
		var inputEle = document.getElementById('horario');
		var timeSplit = inputEle.value.split(':'), hours, minutes, meridian;
		hours = timeSplit[0];
		minutes = timeSplit[1];
		if (hours > 12) {
			meridian = 'PM';
			hours -= 12;
		} else if (hours < 12) {
			meridian = 'AM';
			if (hours == 0) {
				hours = 12;
			}
		} else {
			meridian = 'PM';
		}
		document.getElementById("hora").setAttribute("value",
				hours + ':' + minutes + ' ' + meridian);
	}
</script>