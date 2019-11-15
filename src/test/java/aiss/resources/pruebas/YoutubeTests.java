package aiss.resources.pruebas;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.resources.YouTubeResource;
import aiss.youtube.SearchVideos;

public class YoutubeTests {

	YouTubeResource youtube = new YouTubeResource();

	@Test
	public void testGetVideos() throws UnsupportedEncodingException {
		String busqueda = "Naruto";
		System.out.println("Test YouTube: Probando búsqueda de vídeos de " + busqueda);
		SearchVideos res = youtube.getVideo(busqueda);

		// La siguiente línea es para traducir cuando no hay resultados
		if (res.getItems().isEmpty()) {
			res = null;
		}
		if (res != null) {
			System.out.println("Encontrado Correctamente");
		}

		assertNotNull("La lista de vídeos no puede ser null", res);

	}
}