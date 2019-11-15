package aiss.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.tumblr.SearchImages;

public class TumblrResource {

	private static final Logger log = Logger.getLogger(TumblrResource.class.getName());

	private static final String APIKEY = "dztBgYI7BAEbAyEZwY5f7YviRddsqWqIeeUGkP9ciLQJNgIgYQ";
	private static final String URL_TUMBLR = "https://api.tumblr.com/v2/tagged?tag=%QUERY&filter=photo&api_key=%APIKEY";

	public SearchImages getPost(String param) throws UnsupportedEncodingException {
		String query = URLEncoder.encode(param, "UTF-8");
		ClientResource cr = null;
		SearchImages res = null;
		try {
			cr = new ClientResource(URL_TUMBLR.replace("%QUERY", query).replace("%APIKEY", APIKEY));
			res = cr.get(SearchImages.class);
			log.log(Level.FINE, "Búsqueda de imágenes de " + query + " realizada correctamente.");
		} catch (ResourceException e) {
			log.log(Level.WARNING, "Error al obtener las imágenes: " + cr.getResponse().getStatus());
			throw e;
		}
		return res;
	}

	
}