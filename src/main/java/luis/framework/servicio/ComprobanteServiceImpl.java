package luis.framework.servicio;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.ZapfDingbatsList;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

import luis.framework.dao.PagoDAOImpl;
import luis.framework.pojo.BoletCant;
import luis.framework.pojo.Compra;
import luis.framework.pojo.Pago;
import luis.framework.pojo.Pelicula;

@Service
public class ComprobanteServiceImpl {

	private PagoDAOImpl pagoDAO = new PagoDAOImpl();
	
	private String result1 = "comprobante/comprobante_es.pdf";
	private String result2 = "comprobante/comprobante_en.pdf";
	com.itextpdf.text.Font fontTitle = new com.itextpdf.text.Font(FontFamily.HELVETICA, 18, Font.ITALIC,
			BaseColor.BLACK);
	com.itextpdf.text.Font fontSub = new com.itextpdf.text.Font(FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
	com.itextpdf.text.Font fontVer = new com.itextpdf.text.Font(FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);
	com.itextpdf.text.Font fontVer1 = new com.itextpdf.text.Font(FontFamily.HELVETICA, 12, Font.PLAIN, BaseColor.BLACK);

	public String Boletin(ArrayList<BoletCant> boletos) {
		String boletin = "";
		ArrayList<Pago> pago = pagoDAO.getPago();
		for (int i = 0; i < pago.size(); i++) {
			for (int j = 0; j < boletos.size(); j++) {
				if (pago.get(i).getIdPago() == boletos.get(j).getIdPago() && boletos.get(j).getCantidadP() != 0) {
					boletin += "-" + pago.get(i).getTipopersonal() + " ";
				}
			}
		}
		return boletin;
	}

	public void createPDF(String ruta, Compra compra, float total, String boletin, Pelicula peliElegida,
			String asientos) {
		createPDF_es(ruta, compra, total, boletin, peliElegida, asientos);
		createPDF_en(ruta, compra, total, boletin, peliElegida, asientos);
	}

	public void createPDF_es(String ruta, Compra compra, float total, String boletin, Pelicula peliElegida,
			String asientos) {
		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream(new File(ruta + result1)));
			document.open();

			Paragraph paragraph1 = new Paragraph("¡Ya tienes tus boletos!", fontTitle);
			paragraph1.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph1);

			Paragraph paragraph2 = new Paragraph("Esta es tu confirmación de compra. Pasa por tus boletos a taquilla "
					+ "indicando el código de compra o con la tarjeta con la que hiciste tu compra", fontSub);
			paragraph2.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paragraph2);

			Paragraph p3 = new Paragraph("Código de compra: " + compra.getCodigocompra(), fontVer);
			p3.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(p3);

			Paragraph p4 = new Paragraph("Datos de la compra", fontVer);
			p4.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(p4);
			ZapfDingbatsList listado = new ZapfDingbatsList(77);
			ListItem it1 = new ListItem("Título: " + peliElegida.getTitulo(), fontVer1);
			ListItem it2 = new ListItem("Versión: " + peliElegida.getVersion(), fontVer1);
			ListItem it3 = new ListItem("Día: " + peliElegida.getDia(), fontVer1);
			ListItem it4 = new ListItem("Hora: " + peliElegida.getHora(), fontVer1);
			ListItem it5 = new ListItem("Cine: " + peliElegida.getCine(), fontVer1);
			ListItem it6 = new ListItem("Sala: " + peliElegida.getSala(), fontVer1);
			ListItem it7 = new ListItem("Tus boletos: " + boletin, fontVer1);
			ListItem it8 = new ListItem("Asientos seleccionado: " + asientos, fontVer1);
			ListItem it9 = new ListItem("Total pagado: " + total, fontVer1);
			listado.add(it1);
			listado.add(it2);
			listado.add(it3);
			listado.add(it4);
			listado.add(it5);
			listado.add(it6);
			listado.add(it7);
			listado.add(it8);
			listado.add(it9);
			document.add(listado);

			Paragraph p5 = new Paragraph("Datos para Comprobante Fiscal", fontVer);
			p4.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(p5);
			ZapfDingbatsList listado2 = new ZapfDingbatsList(77);
			ListItem it12 = new ListItem("Complejo: VIT", fontVer1);
			ListItem it22 = new ListItem("No. Boleto: " + compra.getNumticket(), fontVer1);
			ListItem it32 = new ListItem("Fecha de compra: " + compra.getFechacompra(), fontVer1);
			listado2.add(it12);
			listado2.add(it22);
			listado2.add(it32);
			document.add(listado2);

			Paragraph p6 = new Paragraph(peliElegida.getTitulo(), fontVer);
			p6.setAlignment(Element.ALIGN_CENTER);
			document.add(p6);

			Image image;
			image = Image.getInstance(ruta + peliElegida.getImagen());
			image.setAlignment(Element.ALIGN_CENTER);
			document.add(image);

			document.close();
			System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			System.out.println("The file not exists (Se ha producido un error al generar un documento): " + e);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createPDF_en(String ruta, Compra compra, float total, String boletin, Pelicula peliElegida,
			String asientos) {
		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream(new File(ruta + result2)));
			document.open();

			Paragraph paragraph1 = new Paragraph("You already have your tickets!", fontTitle);
			paragraph1.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph1);

			Paragraph paragraph2 = new Paragraph("This is your purchase confirmation. Pass your tickets to the "
					+ "ticket office indicating the purchase code or the card with which you made your purchase",
					fontSub);
			paragraph2.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paragraph2);

			Paragraph p3 = new Paragraph("Purchase code: " + compra.getCodigocompra(), fontVer);
			p3.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(p3);

			Paragraph p4 = new Paragraph("Purchase information", fontVer);
			p4.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(p4);
			ZapfDingbatsList listado = new ZapfDingbatsList(77);
			ListItem it1 = new ListItem("Title: " + peliElegida.getTitulo(), fontVer1);
			ListItem it2 = new ListItem("Version: " + peliElegida.getVersion(), fontVer1);
			ListItem it3 = new ListItem("Day: " + peliElegida.getDia(), fontVer1);
			ListItem it4 = new ListItem("Time: " + peliElegida.getHora(), fontVer1);
			ListItem it5 = new ListItem("Cinema: " + peliElegida.getCine(), fontVer1);
			ListItem it6 = new ListItem("Room: " + peliElegida.getSala(), fontVer1);
			ListItem it7 = new ListItem("Your tickets: " + boletin, fontVer1);
			ListItem it8 = new ListItem("Selected seats: " + asientos, fontVer1);
			ListItem it9 = new ListItem("Total paid: " + total, fontVer1);
			listado.add(it1);
			listado.add(it2);
			listado.add(it3);
			listado.add(it4);
			listado.add(it5);
			listado.add(it6);
			listado.add(it7);
			listado.add(it8);
			listado.add(it9);
			document.add(listado);

			Paragraph p5 = new Paragraph("Data for Tax Test", fontVer);
			p4.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(p5);
			ZapfDingbatsList listado2 = new ZapfDingbatsList(77);
			ListItem it12 = new ListItem("Complex: VIT", fontVer1);
			ListItem it22 = new ListItem("No. Ticket: " + compra.getNumticket(), fontVer1);
			ListItem it32 = new ListItem("Date of purchase: " + compra.getFechacompra(), fontVer1);
			listado2.add(it12);
			listado2.add(it22);
			listado2.add(it32);
			document.add(listado2);

			Paragraph p6 = new Paragraph(peliElegida.getTitulo(), fontVer);
			p6.setAlignment(Element.ALIGN_CENTER);
			document.add(p6);

			Image image;
			image = Image.getInstance(ruta + peliElegida.getImagen());
			image.setAlignment(Element.ALIGN_CENTER);
			document.add(image);

			document.close();
			System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			System.out.println("The file not exists (Se ha producido un error al generar un documento): " + e);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void downloadComprobanteServ(String idioma, String ruta, HttpServletResponse response) throws IOException {
		if(idioma.equals("es")) {
			File file = new File(ruta + "comprobante/comprobante_es.pdf");		
			InputStream in = new FileInputStream(file);		
			response.setHeader("Content-Type", "application/pdf");
	        response.setHeader("Content-Length", String.valueOf(file.length()));
	        response.setHeader("Content-Disposition", "inline;filename=\"" + "comprobante_es.pdf" + "\"" );
	        FileCopyUtils.copy(in, response.getOutputStream());
		}
		else if (idioma.equals("en")) {
			File file = new File(ruta + "comprobante/comprobante_en.pdf");		
			InputStream in = new FileInputStream(file);		
			response.setHeader("Content-Type", "application/pdf");
	        response.setHeader("Content-Length", String.valueOf(file.length()));
	        response.setHeader("Content-Disposition", "inline;filename=\"" + "comprobante_en.pdf" + "\"" );
	        FileCopyUtils.copy(in, response.getOutputStream());	
		}		
	}
}
