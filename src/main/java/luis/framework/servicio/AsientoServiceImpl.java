package luis.framework.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Service;

import luis.framework.pojo.BoletCant;

@Service
public class AsientoServiceImpl {

	public int cantAsiento(ArrayList<BoletCant> boletos) {
		int cants = 0;
		for (int i = 0; i < boletos.size(); i++) {
			cants += boletos.get(i).getCantidadP();
		}
		return cants;
	}

	public List<String> getListAsientos(String query) {
		String asiento = null;
		query = query.toLowerCase();
		List<String> matched = new ArrayList<String>();
		for (int i = 0; i < getAsientos().size(); i++) {
			asiento = getAsientos().get(i).toLowerCase();
			if (asiento.startsWith(query)) {
				matched.add('"' + getAsientos().get(i) + '"');
			}
		}
		return matched;
	}
	
	public List<String> getAsientos(){
		List<String> asientos;
		String strAsientos = "";
		String[] letras = "A,B,C,D,E,F,G,H".split(",");
		for (int i = 0; i < letras.length; i++) {
			for (int j = 1; j <= 21; j++) {
				if (i == (letras.length - 1) && j == 21)
					strAsientos += letras[i] + j;
				else
					strAsientos += letras[i] + j + ", ";
			}
		}
		asientos = new ArrayList<String>();
		StringTokenizer st1 = new StringTokenizer(strAsientos, ",");

		// Parse the technologies list and set as Array
		while (st1.hasMoreTokens()) {
			asientos.add(st1.nextToken().trim());
		}
		return asientos;
	}
}