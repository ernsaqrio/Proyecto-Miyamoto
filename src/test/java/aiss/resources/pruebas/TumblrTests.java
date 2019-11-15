package aiss.resources.pruebas;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.resources.TumblrResource;
import aiss.tumblr.SearchImages;

public class TumblrTests {

	TumblrResource tumblr = new TumblrResource();

	@Test
	public void testGetFotosTumblr() throws UnsupportedEncodingException {
		String busqueda = "Naruto";
		System.out.println("Test Tumblr: Probando búsqueda de imágenes de " + busqueda);
		SearchImages res = tumblr.getPost(busqueda);

		// La siguiente línea es para traducir cuando no hay resultados
		if (res.getResponse().toString().contains("1d296da")) {
			res = null;
		}
		if (res != null) {
			System.out.println("Encontrado Correctamente");
		}

		assertNotNull("La lista de imágenes no puede ser null", res);

	}
}
