package luis.framework.servicio;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import luis.framework.dao.PagoDAOImpl;
import luis.framework.pojo.BoletCant;
import luis.framework.pojo.Pago;

@Service
public class CompraServiceImpl {

	private PagoDAOImpl pagoDAO = new PagoDAOImpl();
	
	public float modifTotal(float total, ArrayList<BoletCant> boletos) {
		ArrayList<Pago> pago = pagoDAO.getPago();
		for (int i = 0; i < pago.size(); i++) {
			for (int j = 0; j < boletos.size(); j++) {
				if (pago.get(i).getIdPago() == boletos.get(j).getIdPago() && boletos.get(j).getCantidadP() != 0) {
					total += pago.get(i).getCosto() * boletos.get(j).getCantidadP();
				}
			}
		}		
		return total;
	}
	
	public String codigoCompra() {
		String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
		String cadena = "";
		int longitudCadena = 10;
		for (int x = 0; x < longitudCadena; x++) {
			int caracter = (int) Math.floor(Math.random() * 37); // Generamos la cadena
			cadena = cadena + letras.charAt(caracter);
		}
		return cadena;
	}

	public String numTicket() {
		String letras = "0123456789";
		String cadena = "";
		int longitudCadena = 7;
		for (int x = 0; x < longitudCadena; x++) {
			int caracter = (int) Math.floor(Math.random() * 10); // Generamos la cadena
			cadena = cadena + letras.charAt(caracter);
		}
		return cadena;
	}
}
