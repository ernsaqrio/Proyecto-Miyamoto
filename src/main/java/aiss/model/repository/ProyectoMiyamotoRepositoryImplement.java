package aiss.model.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import aiss.model.Anime;
import aiss.model.Imagen;
import aiss.model.Noticia;
import aiss.model.Producto;
import aiss.model.Video;

public class ProyectoMiyamotoRepositoryImplement implements ProyectoMiyamotoRepository {

	Map<String, Anime> animesMap;

	private static ProyectoMiyamotoRepositoryImplement instance = null;
	private int index = 0;

	public static ProyectoMiyamotoRepositoryImplement getInstance() {
		if (instance == null) {
			instance = new ProyectoMiyamotoRepositoryImplement();
			instance.init();
		}
		return instance;
	}

	public void init() {
		
		animesMap = new HashMap<String, Anime>();
		
		// Crear noticias
		Noticia n1 = new Noticia("n501", "www.animenews.com/noticias", "Nueva película de naruto", "La nueva pelicula de naruto se estrenará en diciembre.");
		Noticia n2 = new Noticia("n502", "www.animenews.com/noticias", "Nueva película de no game no life", "La nueva pelicula de no game no life se estrenará en enero.");
		Noticia n3 = new Noticia("n503", "www.animenews.com/noticias", "Nueva temporada para naruto", "La nueva tempporada de naruto se estrenará en octubre.");
		Noticia n4 = new Noticia("n504", "www.animenews.com/noticias", "Lo que no sabias de higurashi", "El anime higurashi escondia mas secretos de los que se creia.");
		Noticia n5 = new Noticia("n505", "www.animenews.com/noticias", "Nueva película de higurashi", "La nueva pelicula de higurashi se estrenará en febrero.");
		Noticia n6 = new Noticia("n506", "www.animenews.com/noticias", "Nueva temporada para no game no life", "La nueva temporada de nogame no life se estrenará en septiembre.");
		List<Noticia> noticiasNaruto = new ArrayList<>();
		List<Noticia> noticiasNGNL = new ArrayList<>();
		List<Noticia> noticiasHigurashi = new ArrayList<>();
		noticiasNaruto.add(n1);
		noticiasNaruto.add(n3);
		noticiasNGNL.add(n2);
		noticiasNGNL.add(n6);
		noticiasHigurashi.add(n4);
		noticiasHigurashi.add(n5);
		
		// Crear imágenes
		Imagen i1 = new Imagen("i501", "120x300","www.tumblr.com/imagen12738", "Naruto en bici");
		Imagen i2 = new Imagen("i502", "1080x920","www.tumblr.com/imagen13898", "Cosplay de shiro");
		Imagen i3 = new Imagen("i503", "560x600","www.tumblr.com/imagen14538", "Cosplay higurashi");
		Imagen i4 = new Imagen("i504", "120x300","www.tumblr.com/imagen12738", "Cosplay del relleno de naruto");
		Imagen i5 = new Imagen("i505", "1080x920","www.tumblr.com/imagen13898", "Hermanos no game no life");
		Imagen i6 = new Imagen("i506", "560x600","www.tumblr.com/imagen14538", "Escena higurashi");
		List<Imagen> imagenesNaruto = new ArrayList<>();
		List<Imagen> imagenesNGNL = new ArrayList<>();
		List<Imagen> imagenesHigurashi = new ArrayList<>();
		imagenesNaruto.add(i1);
		imagenesNaruto.add(i4);
		imagenesNGNL.add(i2);
		imagenesNGNL.add(i5);
		imagenesHigurashi.add(i3);
		imagenesHigurashi.add(i6);
		
		// Crear vídeos
		Video v1 = new Video("v501", "Opening 1 naruto","www.youtube.com/nasjdih2j3j");
		Video v2 = new Video("v502", "Opening 2 naruto Shipudden","www.youtube.com/dfmkks2j3j");
		Video v3 = new Video("v503", "Opening 1 no game no life","www.youtube.com/kdfopgjdpk12");
		Video v4 = new Video("v504", "Opening 2 no game no life","www.youtube.com/kospgjp78909");
		Video v5 = new Video("v505", "Opening 1 higurashi","www.youtube.com/nnko98789");
		Video v6 = new Video("v506", "Opening 2 higurashi","www.youtube.com/siao36784");
		List<Video> videosNaruto = new ArrayList<>();
		List<Video> videosNGNL = new ArrayList<>();
		List<Video> videosHigurashi = new ArrayList<>();
		videosNaruto.add(v1);
		videosNaruto.add(v2);
		videosNGNL.add(v3);
		videosNGNL.add(v4);
		videosHigurashi.add(v5);
		videosHigurashi.add(v6);
		
		// Crear productos
		Producto p1 = new Producto("p501", "Figura naruto", "20€", "www.aliExpress.com/merchadising", "Figura de naruto hecha a mano.");
		Producto p2 = new Producto("p502", "Figura sasuke", "3€", "www.aliExpress.com/merchadising", "Figura de sasuke corriendo.");
		Producto p3 = new Producto("p503", "Figura shiro", "50€", "www.aliExpress.com/merchadising", "Figura super kawaii de shiro en pijama.");
		Producto p4 = new Producto("p504", "Figura sora", "13€", "www.aliExpress.com/merchadising", "Figura de sora espiando en el baño de las chicas.");
		Producto p5 = new Producto("p505", "Figura higurashi", "70€", "www.aliExpress.com/merchadising", "Figura de todos los personajes de higurashi.");
		Producto p6 = new Producto("p506", "Figura de Keiichi", "30€", "www.aliExpress.com/merchadising", "Figura de Keiichi hecha a mano.");
		List<Producto> productosNaruto = new ArrayList<>();
		List<Producto> productosNGNL = new ArrayList<>();
		List<Producto> productosHigurashi = new ArrayList<>();
		productosNaruto.add(p1);
		productosNaruto.add(p2);
		productosNGNL.add(p3);
		productosNGNL.add(p4);
		productosHigurashi.add(p5);
		productosHigurashi.add(p6);
		
		// Crear animes
		Anime a1 = new Anime("Naruto", 230, "4/10/1994", "5/2/2005","Naruto es un ninja que sueña en convertirse en hokage", imagenesNaruto, noticiasNaruto, productosNaruto, videosNaruto);
		Anime a2 = new Anime("No game no life", 24, "6/1/2016", "12/2/2016","Shiro y sora son dos hermanos que entran en un mundo diferente al suyo", imagenesNGNL, noticiasNGNL, productosNGNL, videosNGNL);
		Anime a3 = new Anime("Higurashi", 12, "1/3/2010", "4/2/2010"," Keiichi es un joven estudiante perteneciente a una familia clase media, quienes en busca de descanso deciden mudarse a la pequeña y apartada villa de Hinamizawa", imagenesHigurashi, noticiasHigurashi, productosHigurashi, videosHigurashi);
		addAnime(a1);
		addAnime(a2);
		addAnime(a3);
		
		
	}

	
	// Métodos de noticias
	
	public Collection<Noticia> getAllAnimeNoticias() {
		Collection<Noticia> noticias = new HashSet<>();
		for (Anime a : getAllAnimes()) {
			noticias.addAll(a.getNoticias());
		}
		return noticias;
	}


	public Collection<Noticia> getAnimeNoticiasById(String idAnime) {
		return getAnimeById(idAnime).getNoticias();
	}

	public Collection<Noticia> getAnimeNoticiasByName(String name) {
		Collection<Noticia> res = new HashSet<>();
		for (Anime a : getAnimesByTitle(name)) {
			res.addAll(a.getNoticias());
		}
		return res;
	}

	public Noticia getNoticiaById(String id) {
		Noticia res = null;
		for (Noticia n : getAllAnimeNoticias()) {
			if (n.getId().equals(id)) {
				res = n;
				break;
			}
		}
		return res;
	}
	
	
	// Métodos de imágenes

	public Collection<Imagen> getAllAnimeImagenes() {
		Collection<Imagen> imagenes = new HashSet<>();
		for (Anime a : getAllAnimes()) {
			imagenes.addAll(a.getImagenes());
		}
		return imagenes;
	}

	public Collection<Imagen> getAnimeImagenesById(String idAnime) {
		return getAnimeById(idAnime).getImagenes();
	}
	
	public Collection<Imagen> getAnimeImagenesByName(String name) {
		Collection<Imagen> res = new HashSet<>();
		for (Anime a : getAnimesByTitle(name)) {
			res.addAll(a.getImagenes());
		}
		return res;
	}

	public Imagen getImagenById(String id) {
		Imagen res = null;
		for (Imagen i : getAllAnimeImagenes()) {
			if (i.getId().equals(id)) {
				res = i;
				break;
			}
		}
		return res;
	}
		

	// Métodos de vídeos

	public Collection<Video> getAllAnimeVideos() {
		Collection<Video> videos = new HashSet<>();
		for (Anime a : getAllAnimes()) {
			videos.addAll(a.getVideos());
		}
		return videos;
	}

	public Collection<Video> getAnimeVideosById(String idAnime) {
		return getAnimeById(idAnime).getVideos();
	}
	
	public Collection<Video> getAnimeVideosByName(String name) {
		Collection<Video> res = new HashSet<>();
		for (Anime a : getAnimesByTitle(name)) {
			res.addAll(a.getVideos());
		}
		return res;
	}

	public Video getVideoById(String id) {
		Video res = null;
		for (Video i : getAllAnimeVideos()) {
			if (i.getId().equals(id)) {
				res = i;
				break;
			}
		}
		return res;
	}

	
	// Métodos de productos

	public Collection<Producto> getAllAnimeProductos() {
		Collection<Producto> productos = new HashSet<>();
		for (Anime a : getAllAnimes()) {
			productos.addAll(a.getProductos());
		}
		return productos;
	}

	public Collection<Producto> getAnimeProductosById(String idAnime) {
		return getAnimeById(idAnime).getProductos();
	}
	
	public Collection<Producto> getAnimeProductosByName(String name) {
		Collection<Producto> res = new HashSet<>();
		for (Anime a : getAnimesByTitle(name)) {
			res.addAll(a.getProductos());
		}
		return res;
	}

	public Producto getProductoById(String id) {
		Producto res = null;
		for (Producto p : getAllAnimeProductos()) {
			if (p.getId().equals(id)) {
				res = p;
				break;
			}
		}
		return res;
	}
	
	
	// Métodos de animes
	
	public Collection<Anime> getAllAnimes() {
		return animesMap.values();
	}

	public Collection<Anime> getAnimesByTitle(String title) {
		Collection<Anime> res = new HashSet<>();
		for (Anime a : getAllAnimes()) {
			if (a.getName().equals(title)) {
				res.add(a);
			}
		}
		return res;
	}
	
	public Anime getAnimeById(String id) {
		return animesMap.get(id);
	}	

	public void addAnime(Anime a) {
		String idAnime = "a" + index++;
		a.setId(idAnime);
		animesMap.put(idAnime, a);
	}

	public void updateAnime(Anime a) {
		if (getAllAnimes().contains(a)) {
			animesMap.put(a.getId(), a);
		}
	}

	public void deleteAnime(String id) {
		animesMap.remove(id);
	}
	
	public void addNoticiaAnime(String idAnime, Noticia n) {
		String idNoticia = "n" + index++;
		n.setId(idNoticia);
		getAnimeById(idAnime).addNoticia(n);
	}

	public void updateNoticiaAnime(String idAnime, Noticia n) {
		getAnimeById(idAnime).updateNoticia(n);
	}

	public void deleteNoticiaAnime(String idAnime, String idNoticia) {
		getAnimeById(idAnime).deleteNoticia(getNoticiaById(idNoticia));
	}

	public void addImagenAnime(String idAnime, Imagen i) {
		String idImagen = "i" + index++;
		i.setId(idImagen);
		getAnimeById(idAnime).addImagen(i);
	}

	public void updateImagenAnime(String idAnime, Imagen i) {
		getAnimeById(idAnime).updateImagen(i);
	}

	public void deleteImagenAnime(String idAnime, String idImagen) {
		getAnimeById(idAnime).deleteImagen(getImagenById(idImagen));
	}

	public void addVideoAnime(String idAnime, Video v) {
		String idVideo = "v" + index++;
		v.setId(idVideo);
		getAnimeById(idAnime).addVideo(v);
	}

	public void updateVideoAnime(String idAnime, Video v) {
		getAnimeById(idAnime).updateVideo(v);
	}

	public void deleteVideoAnime(String idAnime, String idVideo) {
		getAnimeById(idAnime).deleteVideo(getVideoById(idVideo));
	}

	public void addProductoAnime(String idAnime, Producto p) {
		String idProducto = "p" + index++;
		p.setId(idProducto);
		getAnimeById(idAnime).addProducto(p);
	}

	public void updateProductoAnime(String idAnime, Producto p) {
		getAnimeById(idAnime).updateProducto(p);
	}

	public void deleteProductoAnime(String idAnime, String idProducto) {
		getAnimeById(idAnime).deleteProducto(getProductoById(idProducto));
	}
	

	
}