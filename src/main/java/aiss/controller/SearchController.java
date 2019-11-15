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


import aiss.aliExpress.SearchProducts;
import aiss.animeNewsNetwork.SearchAnimeNews;
import aiss.resources.AliExpressResource;
import aiss.resources.AnimeNewsNetworkResource;
import aiss.resources.TumblrResource;
import aiss.resources.YouTubeResource;
import aiss.tumblr.SearchImages;
import aiss.youtube.SearchVideos;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(SearchController.class.getName());

	public SearchController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;

		log.log(Level.INFO, "Procesando SearchController.");

		

		String query = request.getParameter("searchQuery");
		
		AnimeNewsNetworkResource animeNewsNetwork = new AnimeNewsNetworkResource();
		
		TumblrResource tumblr = new TumblrResource();
		
		YouTubeResource youtube = new YouTubeResource();
		
		AliExpressResource aliexpress = new AliExpressResource();
		
		
		log.log(Level.INFO, "Buscando para Anime News Network noticias de " + query);
		Collection<SearchAnimeNews> animeNewsNetworkResults = animeNewsNetwork.getAnimeNews(query);
		
		log.log(Level.INFO, "Buscando para Tumblr imágenes de " + query);
		SearchImages tumblrResults = tumblr.getPost(query);
		
		log.log(Level.INFO, "Buscando para YouTube vídeos de " + query);
		SearchVideos youtubeResults = youtube.getVideo(query);
		
		log.log(Level.INFO, "Buscando para AliExpress productos de " + query);
		SearchProducts aliexpressResults = aliexpress.getProducts(query);
		
		if ( animeNewsNetworkResults != null || tumblrResults != null || youtubeResults != null || aliexpressResults != null) {
			request.setAttribute("noticias", animeNewsNetworkResults);
			request.setAttribute("fotos", tumblrResults);
			request.setAttribute("videos", youtubeResults);
			request.setAttribute("productos", aliexpressResults);
			rd = request.getRequestDispatcher("/resultados.jsp");
			log.log(Level.FINE, "Búsqueda de  noticias, fotos, vídeos y productos realiazada y procesada correctamente.");
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