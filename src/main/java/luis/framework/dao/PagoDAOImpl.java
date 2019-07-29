package luis.framework.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import luis.framework.pojo.Pago;

public class PagoDAOImpl extends CConnection{
   
	public ArrayList<Pago> getPago() {
		ArrayList<Pago> pago = new ArrayList<Pago>();
		Connection cn = null;
		try {
			String query = "select * from pago";
			cn = getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Pago p = new Pago();
				p.setIdPago(resultSet.getInt("idpago"));
				p.setTipopersonal(resultSet.getString("tipopersonal"));
				p.setCosto(resultSet.getFloat("costo"));
				pago.add(p);
			}
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
		return pago;
	}

}
