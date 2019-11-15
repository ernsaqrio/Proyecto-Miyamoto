package aiss.resources.pruebas;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import java.util.Collection;

import org.junit.Test;
import aiss.animeNewsNetwork.SearchAnimeNews;

import aiss.resources.AnimeNewsNetworkResource;

public class AnimeNewsNetworksTest {
	
	AnimeNewsNetworkResource animeNews = new AnimeNewsNetworkResource();

	@Test
	public void testGetNews() throws IOException {
		String busqueda = "Naruto";
		System.out.println("Test AnimeNewsNetworks: Probando búsqueda de noticias de " + busqueda);
		Collection<SearchAnimeNews> res = animeNews.getAnimeNews(busqueda);
		
		// La siguiente línea es para traducir cuando no hay resultados
		if (res.isEmpty()) {
			res = null;
		}
		if (res != null) {
			System.out.println("Encontrado Correctamente");
		}

		assertNotNull("La lista de noticias no puede ser null", res);

	}
}