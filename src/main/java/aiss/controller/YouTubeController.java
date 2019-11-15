package aiss.controller;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.resources.YouTubeResource;
import aiss.youtube.SearchVideos;

public class YouTubeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(YouTubeController.class.getName());

	public YouTubeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;

		log.log(Level.INFO, "Procesando YouTubeController.");

		String query = request.getParameter("searchQuery");

		YouTubeResource youtube = new YouTubeResource();

		log.log(Level.INFO, "Buscando para YouTube vídeos de " + query);
		SearchVideos youtubeResults = youtube.getVideo(query);

		if (youtubeResults != null) {

			request.setAttribute("videos", youtubeResults);

			rd = request.getRequestDispatcher("/resultados.jsp");
			log.log(Level.FINE, "Búsqueda de vídeos realiazada y procesada correctamente.");
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