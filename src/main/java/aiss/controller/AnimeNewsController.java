package aiss.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import aiss.animeNewsNetwork.SearchAnimeNews;
import aiss.resources.AnimeNewsNetworkResource;


public class AnimeNewsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(AnimeNewsController.class.getName());

	public AnimeNewsController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;

		log.log(Level.INFO, "Procesando AnimeNewsController.");

		

		String query = request.getParameter("searchQuery");
		AnimeNewsNetworkResource animeNewsNetwork = new AnimeNewsNetworkResource();
		
		
		
		
		log.log(Level.INFO, "Buscando para Anime News Network noticias de " + query);
		Collection<SearchAnimeNews> animeNewsNetworkResults = animeNewsNetwork.getAnimeNews(query);
		
		
		
		if ( animeNewsNetworkResults != null) {
			request.setAttribute("noticias", animeNewsNetworkResults);
			
			rd = request.getRequestDispatcher("/resultados.jsp");
			log.log(Level.FINE, "Búsqueda de  noticias realiazada y procesada correctamente.");
		} else {
			log.log(Level.WARNING, "Error al realizar la búsqueda");
			rd = request.getRequestDispatcher("/error.jsp");
		}
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doGet(request, response);
	}
}