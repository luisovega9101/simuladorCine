package luis.framework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import luis.framework.pojo.PeliForm;
import luis.framework.pojo.Pelicula;

public class PeliculaDAOImpl extends CConnection{
	
	public ArrayList<Pelicula> getPelicula() {
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		Connection cn =  null;
		try {
			String query = "select * from pelicula";
			cn = getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Pelicula p = new Pelicula();
				p.setIdpelicula(resultSet.getInt("idpelicula"));
				p.setImagen(resultSet.getString("imagen"));
				p.setTitulo(resultSet.getString("titulo"));
				p.setDescripcion(resultSet.getString("descripcion"));
				p.setClasificacion(resultSet.getString("clasificacion"));
				p.setVersion(resultSet.getString("version"));
				p.setCine(resultSet.getString("cine"));
				p.setSala(resultSet.getString("sala"));
				p.setDia(resultSet.getString("dia"));
				p.setHora(resultSet.getString("hora"));
				p.setLatitud(resultSet.getString("latitud"));
				p.setLongitud(resultSet.getString("longitud"));
				peliculas.add(p);
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
		return peliculas;
	}

	public Pelicula getPeliculaID(int idPelicula) {
		Pelicula p = new Pelicula();
		Connection cn = null;
		try {
			String query = "select * from pelicula where idpelicula=" + idPelicula;
			cn = getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				p.setIdpelicula(resultSet.getInt("idpelicula"));
				p.setImagen(resultSet.getString("imagen"));
				p.setTitulo(resultSet.getString("titulo"));
				p.setDescripcion(resultSet.getString("descripcion"));
				p.setClasificacion(resultSet.getString("clasificacion"));
				p.setVersion(resultSet.getString("version"));
				p.setCine(resultSet.getString("cine"));
				p.setSala(resultSet.getString("sala"));
				p.setDia(resultSet.getString("dia"));
				p.setHora(resultSet.getString("hora"));
				p.setLatitud(resultSet.getString("latitud"));
				p.setLongitud(resultSet.getString("longitud"));
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
		return p;
	}

	public int getUltIDPelicula() {
		int idUlt =0;
		Connection cn = null;
		try {
			String query = "SELECT max(pelicula.idpelicula) as maximo FROM pelicula";
			cn = getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				idUlt=resultSet.getInt("maximo");
			}
		} catch (Exception error) {
			System.out.println(error.toString());
		}finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}		
		return idUlt;
	}

	public void insertarPelicula(PeliForm p, String images) {
		Connection cn = null;
		try {			  				
			String query = "INSERT INTO pelicula(idpelicula, imagen, titulo, descripcion, clasificacion, version, cine, "
					+ "sala, dia, hora, latitud, longitud) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			cn = getConnection();
			PreparedStatement stmt = cn.prepareStatement(query);
			
			stmt.setInt(1,p.getIdpelicula());
			stmt.setString(2,images);
			stmt.setString(3,p.getTitulo());
			stmt.setString(4,p.getDescripcion());
			stmt.setString(5,p.getClasificacion());
			stmt.setString(6,p.getVersion());
			stmt.setString(7,p.getCine());
			stmt.setString(8,p.getSala());
			stmt.setString(9,p.getDia());
			stmt.setString(10,p.getHora());
			stmt.setString(11,p.getLatitud());
			stmt.setString(12,p.getLongitud());
	
			stmt.executeUpdate();
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
	}
}