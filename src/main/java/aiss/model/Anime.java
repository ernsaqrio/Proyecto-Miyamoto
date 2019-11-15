package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Anime {
	private String id;
	private String name;
	private Integer episodes;
	private String startDate;
	private String endDate;
	private String synopsis;
	private List<Imagen> imagenes;
	private List<Noticia> noticias;
	private List<Producto> productos;
	private List<Video> videos;
	
	public Anime() {}
	
	public Anime(String id, String name, Integer episodes, String startDate, String endDate, String synonyms, List<Imagen> imagen, List<Noticia> noticias, List<Producto> productos, List<Video> videos) {
		this.id = id;
		this.name = name;
		this.episodes = episodes;
		this.startDate = startDate;
		this.endDate = endDate;
		this.synopsis = synonyms;
		this.imagenes = imagen;
		this.noticias = noticias;
		this.productos = productos;
		this.videos = videos;
	}

	public Anime(String name, Integer episodes, String startDate, String endDate, String synopsis, List<Imagen> imagen, List<Noticia> noticias, List<Producto> productos, List<Video> videos) {
		this.name = name;
		this.episodes = episodes;
		this.startDate = startDate;
		this.endDate = endDate;
		this.synopsis = synopsis;
		this.imagenes = imagen;
		this.noticias = noticias;
		this.productos = productos;
		this.videos = videos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEpisodes() {
		return episodes;
	}

	public void setEpisodes(Integer episodes) {
		this.episodes = episodes;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public List<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<Imagen> imagen) {
		this.imagenes = imagen;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	
	public void addNoticia(Noticia n) {
		if (noticias == null) {
			noticias = new ArrayList<Noticia>();
		}
		noticias.add(n);
	}
	
	public void updateNoticia(Noticia n) {
		List<Noticia> noticiasCopia = new ArrayList<>(noticias);
		for (Noticia noticia : noticiasCopia) {
			if(noticia.getId().equals(n.getId())) {
				noticiasCopia.remove(noticia);
				noticiasCopia.add(n);
				break;
			}
		}
		noticias = noticiasCopia;
	}
	
	public void deleteNoticia(Noticia n) {
		noticias.remove(n);
	}
	
	public void addImagen(Imagen i) {
		if (imagenes == null) {
			imagenes = new ArrayList<Imagen>();
		}
		imagenes.add(i);
	}
	
	public void updateImagen(Imagen i) {
		List<Imagen> imagenesCopia = new ArrayList<>(imagenes);
		for (Imagen imagen : imagenesCopia) {
			if(imagen.getId().equals(i.getId())) {
				imagenesCopia.remove(imagen);
				imagenesCopia.add(i);
				break;
			}
		}
		imagenes = imagenesCopia;
	}
	
	public void deleteImagen(Imagen i) {
		imagenes.remove(i);
	}
	
	public void addVideo(Video v) {
		if (videos == null) {
			videos = new ArrayList<Video>();
		}
		videos.add(v);
	}
	
	public void updateVideo(Video v) {
		List<Video> videosCopia = new ArrayList<>(videos);
		for (Video video : videosCopia) {
			if(video.getId().equals(v.getId())) {
				videosCopia.remove(video);
				videosCopia.add(v);
				break;
			}
		}
		videos = videosCopia;
	}
	
	public void deleteVideo(Video v) {
		videos.remove(v);
	}
	
	public void addProducto(Producto p) {
		if (productos == null) {
			productos = new ArrayList<Producto>();
		}
		productos.add(p);
	}
	
	public void updateProducto(Producto p) {
		List<Producto> productosCopia = new ArrayList<>(productos);
		for (Producto producto : productosCopia) {
			if(producto.getId().equals(p.getId())) {
				productosCopia.remove(producto);
				productosCopia.add(p);
				break;
			}
		}
		productos = productosCopia;
	}
	
	public void deleteProducto(Producto p) {
		productos.remove(p);
	}
}
