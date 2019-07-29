package luis.framework.servicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import luis.framework.dao.PeliculaDAOImpl;
import luis.framework.pojo.PeliForm;
import luis.framework.pojo.Pelicula;

@Service
public class PeliculaServiceImpl {
	
	private PeliculaDAOImpl peliculaDAO = new PeliculaDAOImpl();
	
	public ArrayList<Pelicula> getPelicula() {
		return peliculaDAO.getPelicula();
	}

	public PeliForm getPeliForm() {
		int idpelicula = peliculaDAO.getUltIDPelicula() + 1;
		PeliForm peliForm = new PeliForm();
		peliForm.setIdpelicula(idpelicula);
		return peliForm;
	}

	public void insertarPeliculaServ(PeliForm peliForm, String ruta) {
		String images = "img/img" + peliForm.getIdpelicula() + ".jpg";	
		MultipartFile file = peliForm.getImagen();
		if (null != file && file.getSize() > 0) {
			try {
				file.transferTo( new File(ruta + images));
				peliculaDAO.insertarPelicula(peliForm, images);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public Pelicula getPeliculaIDServ(Pelicula p) {
		Pelicula pel = peliculaDAO.getPeliculaID(p.getIdpelicula());
		return pel;
	}

	public void downloadServ(int idPelicula, String ruta, HttpServletResponse response) throws IOException {
		Pelicula pel = peliculaDAO.getPeliculaID(idPelicula);
		File file = new File(ruta + pel.getImagen());		
		InputStream in = new FileInputStream(file);		
		String[] parts = pel.getImagen().split(Pattern.quote("/"));		
		response.setHeader("Content-Type", "image/jpg");
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline;filename=\"" + parts[parts.length - 1] + "\"" );
        FileCopyUtils.copy(in, response.getOutputStream());        
	}
}
