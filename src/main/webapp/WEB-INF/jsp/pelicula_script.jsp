<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC_ynxj540hup-TPsTJq9OYKCJQgbBgWTY&callback=initMap"
  type="text/javascript"></script>
 
<script type="text/javascript" src="js/jquery.js"></script>

<script>
	$(document).ready(function() {
		var mapa;
		var latitud = parseFloat($('#v_latitud').val());
		var longitud = parseFloat($('#v_longitud').val());
		var marcador;
		var coordenadas = new google.maps.LatLng(latitud, longitud);
		var opciones = {
			center : coordenadas,
			zoom : 18,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		mapa = new google.maps.Map($('#mapa')[0], opciones);
		ponCoordenadas(coordenadas);
		google.maps.event.addListener(mapa, 'click', function(event) {
			ponCoordenadas(event.latLng);
		});
		function ponCoordenadas(location) {
			if (marcador) {
				marcador.setPosition(location);
			} else {
				marcador = new google.maps.Marker({
					position : location,
					draggable : true,
					title : 'Arrastrar para marcar nuevas coordenadas.',
					map : mapa
				});
			}
		}
		google.maps.event.addListener(mapa, 'click', function(event) {
			ponCoordenadas(event.latLng);
			jQuery('#v_latitud').val(marcador.getPosition().lat());
			jQuery('#v_longitud').val(marcador.getPosition().lng());
		});
    });
</script>