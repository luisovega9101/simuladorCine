package luis.framework.pojo;

public class Boleto {

	private int idboleto;
	private String asientos;
	private Pelicula pelicula;
	
	public Boleto() {
		
	}	
	public int getIdboleto() {
		return idboleto;
	}
	public void setIdboleto(int idboleto) {
		this.idboleto = idboleto;
	}
	public String getAsientos() {
		return asientos;
	}
	public void setAsientos(String asientos) {
		this.asientos = asientos;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
}
