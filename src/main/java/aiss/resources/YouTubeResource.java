package aiss.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.youtube.SearchVideos;

public class YouTubeResource {

	private static final Logger log = Logger.getLogger(YouTubeResource.class.getName());

	private static final String APIKEY = "AIzaSyA1_L6d10aqO6X9E58LqlHEPvLxex1wlK0";
	private static final String URL_YOUTUBE = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=%QUERY+music&key=%APIKEY";

	

	public SearchVideos getVideo(String param) throws UnsupportedEncodingException {
		String query = URLEncoder.encode(param, "UTF-8");
		ClientResource cr = null;
		SearchVideos res = null;
		try {
			cr = new ClientResource(URL_YOUTUBE.replace("%QUERY", query).replace("%APIKEY", APIKEY));
			res = cr.get(SearchVideos.class);
			log.log(Level.FINE, "Búsqueda de vídeos de " + query + " realizada correctamente.");
		} catch (ResourceException e) {
			log.log(Level.WARNING, "Error al obtener los vídeos: " + cr.getResponse().getStatus());
			throw e;
		}
		return res;
	}

	

}