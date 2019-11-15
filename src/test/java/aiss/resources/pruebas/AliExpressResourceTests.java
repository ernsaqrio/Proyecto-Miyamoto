package aiss.resources.pruebas;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.aliExpress.SearchProducts;
import aiss.resources.AliExpressResource;

public class AliExpressResourceTests {

	AliExpressResource aliexpress = new AliExpressResource();
	
	@Test
	public void testGetProducts() throws UnsupportedEncodingException {
		String busqueda = "Naruto";
		System.out.println("Test AliExpress: Probando búsqueda de productos de " + busqueda);
		SearchProducts res = aliexpress.getProducts(busqueda);
		
		// La siguiente línea es para traducir cuando no hay resultados
		if (res.toString().contains("3444d69d")) {
			res = null;
		}
		if (res != null) {
			System.out.println("Encontrado correctamente");
		}

		assertNotNull("La lista de productos no puede ser null", res);

	}
}