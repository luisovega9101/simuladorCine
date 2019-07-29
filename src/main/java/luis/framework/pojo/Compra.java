package luis.framework.pojo;

import java.math.BigInteger;

public class Compra {

	private int idcompra;
	private String titular;
	private String email;
	private BigInteger numtarjeta;
	private int codigoseguridad;
	private int mesvencimiento;
	private int annovencimiento;
	private String fechacompra;
	private String codigocompra;
	private int numticket;
	private Boleto boleto;
	
	public Compra() {
		
	}
	
	public int getIdcompra() {
		return idcompra;
	}
	public void setIdcompra(int idcompra) {
		this.idcompra = idcompra;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigInteger getNumtarjeta() {
		return numtarjeta;
	}
	public void setNumtarjeta(BigInteger numtarjeta) {
		this.numtarjeta = numtarjeta;
	}
	public int getCodigoseguridad() {
		return codigoseguridad;
	}
	public void setCodigoseguridad(int codigoseguridad) {
		this.codigoseguridad = codigoseguridad;
	}
	public int getMesvencimiento() {
		return mesvencimiento;
	}
	public void setMesvencimiento(int mesvencimiento) {
		this.mesvencimiento = mesvencimiento;
	}
	public int getAnnovencimiento() {
		return annovencimiento;
	}
	public void setAnnovencimiento(int annovencimiento) {
		this.annovencimiento = annovencimiento;
	}
	public String getFechacompra() {
		return fechacompra;
	}
	public void setFechacompra(String fechacompra) {
		this.fechacompra = fechacompra;
	}
	public String getCodigocompra() {
		return codigocompra;
	}
	public void setCodigocompra(String codigocompra) {
		this.codigocompra = codigocompra;
	}
	public int getNumticket() {
		return numticket;
	}
	public void setNumticket(int numticket) {
		this.numticket = numticket;
	}
	public Boleto getBoleto() {
		return boleto;
	}
	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}
}
