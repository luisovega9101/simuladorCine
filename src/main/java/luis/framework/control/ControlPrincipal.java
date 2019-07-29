package luis.framework.control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import luis.framework.pojo.Pago;
import luis.framework.pojo.BoletCant;
import luis.framework.pojo.BoletCantForm;
import luis.framework.pojo.Boleto;
import luis.framework.pojo.Compra;
import luis.framework.pojo.PeliForm;
import luis.framework.pojo.Pelicula;
import luis.framework.servicio.AsientoServiceImpl;
import luis.framework.servicio.BoletoServiceImpl;
import luis.framework.servicio.CompraServiceImpl;
import luis.framework.servicio.ComprobanteServiceImpl;
import luis.framework.servicio.PeliculaServiceImpl;
import luis.framework.validator.Validaciones;

@Controller
@SessionAttributes(value = { "peliElegida", "boletos", "boleto", "boletoForm", "asientos", "compra", "total" })
public class ControlPrincipal {

	private Pelicula peliElegida;
	private ArrayList<BoletCant> boletos = new ArrayList<BoletCant>();
	private String asientos = new String();
	private Compra compra = new Compra();
	private int cants = 0;
	private float total = 0;
	private BoletCantForm boletoForm;
	private String ruta = "C:/Users/X510UR/eclipse-workspace/cinecitoFinalv1/src/main/webapp/";
	private Validaciones validador = new Validaciones();
	private PeliculaServiceImpl peliculaService = new PeliculaServiceImpl();
	private BoletoServiceImpl boletoService = new BoletoServiceImpl();
	private AsientoServiceImpl asientoService = new AsientoServiceImpl();
	private CompraServiceImpl compraService = new CompraServiceImpl();
	private ComprobanteServiceImpl comprobanteService = new ComprobanteServiceImpl();

	@RequestMapping(value = "/inicio", method = { RequestMethod.POST, RequestMethod.GET })
	public String showInicio(ModelMap model, HttpServletRequest request) {
		ArrayList<Pelicula> peliculas = peliculaService.getPelicula();
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("peliElegida", new Pelicula());
		return "iniciotiles";
	}

	@RequestMapping(value = "/peli_upload", method = { RequestMethod.POST, RequestMethod.GET })
	public String uploadMovie(ModelMap model, HttpServletRequest request) {
		model.addAttribute("peliForm", peliculaService.getPeliForm());
		return "peli_uploadtiles";
	}

	@RequestMapping(value = "/inicio_upload", method = { RequestMethod.POST, RequestMethod.GET })
	public String showInicioUpload(ModelMap model, @ModelAttribute("peliForm") PeliForm peliForm, BindingResult result,
			HttpServletRequest request) throws UnsupportedEncodingException {
		validador.validaPeli(peliForm, result);
		if (result.hasErrors()) {
			model.addAttribute("peliForm", peliForm);
			return "peli_uploadtiles";
		}
		peliculaService.insertarPeliculaServ(peliForm, ruta);
		model.addAttribute("peliculas", peliculaService.getPelicula());
		model.addAttribute("peliElegida", new Pelicula());
		return "iniciotiles";
	}

	@RequestMapping(value = "/pelicula", method = { RequestMethod.POST, RequestMethod.GET })
	public String showPelicula(ModelMap model, @ModelAttribute("peliElegida") Pelicula peliElegida,
			HttpServletRequest request) {
		this.peliElegida = peliculaService.getPeliculaIDServ(peliElegida);
		model.addAttribute("peliElegida", this.peliElegida);
		return "peliculatiles";
	}

	@RequestMapping("/download/{idPelicula}")
	public String download(@PathVariable("idPelicula") Integer idPelicula, HttpServletResponse response)
			throws IOException {
		peliculaService.downloadServ(idPelicula, ruta, response);
		return null;
	}

	@RequestMapping(value = "/boleto", method = { RequestMethod.POST, RequestMethod.GET })
	public String showBoleto(ModelMap model, HttpServletRequest request) {
		ArrayList<Pago> pago = boletoService.getListPago();
		model.addAttribute("pago", pago);
		boletoForm = new BoletCantForm();
		boletoForm.setBoletos(boletos);
		model.addAttribute("boletoForm", boletoForm);
		return "boletotiles";
	}

	@RequestMapping(value = "/asiento", method = { RequestMethod.POST, RequestMethod.GET })
	public String showAsiento(ModelMap model, @ModelAttribute("boletoForm") BoletCantForm boletoForm,
			HttpServletRequest request) {
		boletos = boletoForm.getBoletos();
		model.addAttribute("boleto", new Boleto());
		cants = asientoService.cantAsiento(boletos);
		return "asientotiles";
	}

	@RequestMapping(value = "/asiento_asientos_list", method = RequestMethod.GET)
	public @ResponseBody String getAsientosList(@RequestParam("term") String query) {
		return asientoService.getListAsientos(query).toString();
	}

	@RequestMapping(value = "/comprar_atras", method = { RequestMethod.POST, RequestMethod.GET })
	public String showPagoAtras(ModelMap model, HttpServletRequest request) {
		model.addAttribute("pago", boletoService.getListPago());
		model.addAttribute("boletoForm", boletoForm);
		return "boletotiles";
	}

	@RequestMapping(value = "/comprar", method = { RequestMethod.POST, RequestMethod.GET })
	public String showPago(ModelMap model, @ModelAttribute("boleto") Boleto boleto, BindingResult result,
			HttpServletRequest request) {
		asientos = boleto.getAsientos();
		validador.validaAsiento(asientos, cants, result);
		if (result.hasErrors()) {
			model.addAttribute("boleto", boleto);
			return "asientotiles";
		} else {
			total = compraService.modifTotal(total, boletos);
			model.addAttribute("compra", compra);
			model.addAttribute("codigocompra", compraService.codigoCompra());
			model.addAttribute("numticket", compraService.numTicket());
			model.addAttribute("total", total);
			return "comprartiles";
		}
	}

	@RequestMapping(value = "/comprobante", method = { RequestMethod.POST, RequestMethod.GET })
	public String showComprobante(ModelMap model, @ModelAttribute("compra") Compra compra, BindingResult result,
			HttpServletRequest request) {
		validador.validate(compra, result);
		if (result.hasErrors()) {
			model.addAttribute("compra", compra);
			model.addAttribute("codigocompra", compraService.codigoCompra());
			model.addAttribute("numticket", compraService.numTicket());
			model.addAttribute("total", total);
			return "comprartiles";
		} else {
			String boletin = comprobanteService.Boletin(boletos);
			model.addAttribute("total", total);
			model.addAttribute("boletin", boletin);
			model.addAttribute("peliElegida", peliElegida);
			model.addAttribute("asientos", asientos);
			comprobanteService.createPDF(ruta, compra, total, boletin, peliElegida, asientos);
			return "comprobantetiles";
		}
	}

	@RequestMapping("/download2/{idioma}")
	public String downloadComprobante(@PathVariable("idioma") String idioma, HttpServletResponse response)
			throws IOException {
		comprobanteService.downloadComprobanteServ(idioma, ruta, response);
		return null;
	}
}
