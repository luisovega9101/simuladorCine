package luis.framework.pojo;

public class Pago{
	
	private int idPago;
	private String tipopersonal;
	private float costo;
	
	public Pago() {
		
	}
	
	public int getIdPago() {
		return idPago;
	}
	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}
	public String getTipopersonal() {
		return tipopersonal;
	}
	public void setTipopersonal(String tipopersonal) {
		this.tipopersonal = tipopersonal;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
}
