package aiss;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Index extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Index.class.getName());

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		log.log(Level.INFO, "Procesando index.");

		// Mostramos el contenido con HTML
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html> ");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' type='text/css' href='/css/general.css'>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>");
		out.println("<title>Inicio</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='contenedor'>");
		out.println("<div class='col-100 tablet-100 movil-100 alinearCentro reescalarImagen'>");
		out.println("<img class='logoIndex' src='/images/Logo.png'>");
		out.println("</div>");
		out.println("</div>");
		out.println("<div class='clear'></div>");
		out.println("<div class='contenedor'>");
		out.println("<div class='col-100 tablet-100 movil-100 alinearCentro'>");
		out.println("<form action='/SearchController' method='post'>");
		out.println("<input type='text' placeholder='Busca un anime' class='busqueda' name='searchQuery' required/><br /><br />");
		out.println("<input type='submit' class='enviar' name='searchBtn' title='search' value='Buscar'>");
		out.println("</form>");
		out.println("</div>");
		out.println("</div>");
		out.println("<div class='clear'></div>");
		out.println("<br /><br />");
		out.println("<div class='contenedor'>");
		out.println("<div class='col-100 tablet-100 movil-100 alinearCentro'>");
		out.println("<br />");
		out.println("<a class='api' href='/docs/index.html'> Ver documentacion de la API</a>");
		out.println("</div>");
		out.println("</div>");
		out.println("<video id='video' autoplay='autoplay' muted loop>");
		out.println("<source src='/videos/amv.mp4' type='video/mp4'></source>");
		out.println("</video>");
		out.println("</div>");
		out.println("</body></html>");

		log.log(Level.FINE, "Index procesado con éxito.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doGet(request, response);
	}
}