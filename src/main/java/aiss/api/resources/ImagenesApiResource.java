package aiss.api.resources;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Imagen;
import aiss.model.repository.ProyectoMiyamotoRepository;
import aiss.model.repository.ProyectoMiyamotoRepositoryImplement;

@Path("/imagenes")
public class ImagenesApiResource {


	public static ImagenesApiResource _instance = null;
	ProyectoMiyamotoRepository repository;

	public ImagenesApiResource() {
		repository = ProyectoMiyamotoRepositoryImplement.getInstance();

	}

	public static ImagenesApiResource getInstance() {
		if (_instance == null)
			_instance = new ImagenesApiResource();
		return _instance;
	}

	// Método que devuelve todas las imágenes
	@GET
	@Produces("application/json")
	public Collection<Imagen> getAllImagenes() {
		return repository.getAllAnimeImagenes();
	}
	
	// Método que devuelve todas las imágenes de la id de un determinado anime
	@GET
	@Path("/idAnime")
	@Produces("application/json")
	public Collection<Imagen> getAllImagenesById(@QueryParam("id") String idAnime) {
		Collection<Imagen> res = repository.getAnimeImagenesById(idAnime);
		if (res == null) {
			throw new NotFoundException("No se encuentra ninguna imagen.");
		}
		return res;
	}
	
	// Método que devuelve todas las imágenes del nombre de un determinado anime
	@GET
	@Path("/titleAnime")
	@Produces("application/json")
	public Collection<Imagen> getAllImagenesByTitle(@QueryParam("title") String title) {
		Collection<Imagen> res = repository.getAnimeImagenesByName(title);
		if (res == null) {
			throw new NotFoundException("No se encuentra ninguna imagen.");
		}
		return res;
	}	
	
	// Método que devuelve una imagen con una determinada id
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Imagen getImagenById(@PathParam("id") String id) {
		Imagen imagen = repository.getImagenById(id);
		if (imagen == null) {
			throw new BadRequestException("La imagen solicitada no existe.");
		}
		return imagen;
	}
}