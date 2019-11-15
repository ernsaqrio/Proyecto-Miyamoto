package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.resources.TumblrResource;

import aiss.tumblr.SearchImages;

public class TumblrController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(TumblrController.class.getName());

	public TumblrController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;

		log.log(Level.INFO, "Procesando TumblrController.");

		// Obtenemos el parámetro de búsqueda del perfil
		String query = request.getParameter("searchPerfilQuery");

		TumblrResource tumblr = new TumblrResource();

		log.log(Level.INFO, "Buscando para Tumblr imágenes de " + query);
		SearchImages tumblrResults = tumblr.getPost(query);

		if (tumblrResults != null) {
			request.setAttribute("fotos", tumblrResults);
			;
			rd = request.getRequestDispatcher("/resultados.jsp");
			log.log(Level.FINE, "Búsqueda de   fotos realiazada y procesada correctamente.");
		} else {
			log.log(Level.WARNING, "Error al realizar la búsqueda");
			rd = request.getRequestDispatcher("/error.jsp");
		}

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
