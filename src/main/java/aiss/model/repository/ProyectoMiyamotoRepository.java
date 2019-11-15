package aiss.model.repository;

import java.util.Collection;

import aiss.model.Anime;
import aiss.model.Imagen;
import aiss.model.Noticia;
import aiss.model.Producto;
import aiss.model.Video;

public interface ProyectoMiyamotoRepository {

	// Métodos de noticias
	public Collection<Noticia> getAllAnimeNoticias();
	public Collection<Noticia> getAnimeNoticiasById(String idAnime);
	public Collection<Noticia> getAnimeNoticiasByName(String name);
	public Noticia getNoticiaById(String id);
	
	// Métodos de imágenes
	public Collection<Imagen> getAllAnimeImagenes();
	public Collection<Imagen> getAnimeImagenesById(String idAnime);
	public Collection<Imagen> getAnimeImagenesByName(String name);
	public Imagen getImagenById(String id);
	
	// Métodos de vídeos
	public Collection<Video> getAllAnimeVideos();
	public Collection<Video> getAnimeVideosById(String idAnime);
	public Collection<Video> getAnimeVideosByName(String name);
	public Video getVideoById(String id);
	
	// Métodos de productos
	public Collection<Producto> getAllAnimeProductos();
	public Collection<Producto> getAnimeProductosById(String idAnime);
	public Collection<Producto> getAnimeProductosByName(String name);
	public Producto getProductoById(String id);
	
	// Métodos de animes
	public Collection<Anime> getAllAnimes();
	public Collection<Anime> getAnimesByTitle(String title);
	public Anime getAnimeById(String id);
	public void addAnime(Anime id);
	public void updateAnime(Anime id);
	public void deleteAnime(String id);
	public void addNoticiaAnime(String idAnime, Noticia n);
	public void updateNoticiaAnime(String idAnime, Noticia n);
	public void deleteNoticiaAnime(String idAnime, String idNoticia);
	public void addImagenAnime(String idAnime, Imagen i);
	public void updateImagenAnime(String idAnime, Imagen i);
	public void deleteImagenAnime(String idAnime, String idImagen);
	public void addVideoAnime(String idAnime, Video v);
	public void updateVideoAnime(String idAnime, Video v);
	public void deleteVideoAnime(String idAnime, String idVideo);
	public void addProductoAnime(String idAnime, Producto p);
	public void updateProductoAnime(String idAnime, Producto p);
	public void deleteProductoAnime(String idAnime, String idProducto);
	
	
}