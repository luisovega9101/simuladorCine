package luis.framework.servicio;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import luis.framework.dao.PagoDAOImpl;
import luis.framework.pojo.Pago;

@Service
public class BoletoServiceImpl {

	private PagoDAOImpl pagoDAO = new PagoDAOImpl();
	
	public ArrayList<Pago> getListPago() {
		return pagoDAO.getPago();
	}

}
