package aiss.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.aliExpress.SearchProducts;

public class AliExpressResource {

	private static final Logger log = Logger.getLogger(AliExpressResource.class.getName());

	private static final String APIKEY = "33503";
	private static final String URL_ALIEXPRESS = "http://gw.api.alibaba.com/openapi/param2/2/portals.open/api.listPromotionProduct/%APIKEY?fields=productId,productTitle,productUrl,imageUrl&keywords=%QUERY";


	public SearchProducts getProducts(String param) throws UnsupportedEncodingException {
		String query = URLEncoder.encode(param, "UTF-8");
		ClientResource cr = null;
		SearchProducts res = null;
		try {
			cr = new ClientResource(URL_ALIEXPRESS.replace("%APIKEY", APIKEY).replace("%QUERY", query));
			res = cr.get(SearchProducts.class);
			log.log(Level.FINE, "Búsqueda de productos de " + query + " realizada correctamente.");
		} catch (ResourceException e) {
			log.log(Level.WARNING, "Error al obtener los productos: " + cr.getResponse().getStatus());
			throw e;
		}
		return res;
	}

}