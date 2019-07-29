function sumar(costo) {
  var total = 0;
  $(".monto").each(function() {
    if (isNaN(parseFloat($(this).val()))) {
      total += 0;
    } else {
      total += parseFloat($(this).val())*parseFloat(costo);
    }
  });
  //alert(total);
  document.getElementById('spTotal').innerHTML = total;
}

