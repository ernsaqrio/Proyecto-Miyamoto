package aiss.api.resources;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Noticia;
import aiss.model.repository.ProyectoMiyamotoRepository;
import aiss.model.repository.ProyectoMiyamotoRepositoryImplement;

@Path("/noticias")
public class NoticiasApiResource {

	public static NoticiasApiResource _instance = null;
	
	ProyectoMiyamotoRepository repository;

	public NoticiasApiResource() {
		repository = ProyectoMiyamotoRepositoryImplement.getInstance();
	}

	public static NoticiasApiResource getInstance() {
		if (_instance == null) {
			_instance = new NoticiasApiResource();
		}
		return _instance;
	}

	// Método que devuelve todas las noticias
	@GET
	@Produces("application/json")
	public Collection<Noticia> getAllNoticias() {
		return repository.getAllAnimeNoticias();
	}
	
	// Método que devuelve todos las noticias de la id de un determinado anime
	@GET
	@Path("/idAnime")
	@Produces("application/json")
	public Collection<Noticia> getAllNoticiasById(@QueryParam("id") String idAnime) {
		Collection<Noticia> res = repository.getAnimeNoticiasById(idAnime);
		if (res == null) {
			throw new NotFoundException("No se encuentra ninguna noticia.");
		}
		return res;
	}
	
	// Método que devuelve todas las noticias del nombre de un determinado anime
	@GET
	@Path("/titleAnime")
	@Produces("application/json")
	public Collection<Noticia> getAllNoticiasByTitle(@QueryParam("title") String title) {
		Collection<Noticia> res = repository.getAnimeNoticiasByName(title);
		if (res == null) {
			throw new NotFoundException("No se encuentra ninguna noticia.");
		}
		return res;
	}	
	
	// Método que devuelve una noticia con una determinada id
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Noticia getNoticiaById(@PathParam("id") String id) {
		Noticia noticia = repository.getNoticiaById(id);
		if (noticia == null) {
			throw new BadRequestException("La noticia solicitada no existe.");
		}
		return noticia;
	}
}