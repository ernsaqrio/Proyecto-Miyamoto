package aiss.api.resources;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Video;
import aiss.model.repository.ProyectoMiyamotoRepository;
import aiss.model.repository.ProyectoMiyamotoRepositoryImplement;

@Path("/videos")
public class VideosApiResource {

	public static VideosApiResource _instance = null;
	ProyectoMiyamotoRepository repository;

	public VideosApiResource() {
		repository = ProyectoMiyamotoRepositoryImplement.getInstance();

	}

	public static VideosApiResource getInstance() {
		if (_instance == null)
			_instance = new VideosApiResource();
		return _instance;
	}

	// Método que devuelve todos los vídeos
	@GET
	@Produces("application/json")
	public Collection<Video> getAllVideos() {
		return repository.getAllAnimeVideos();
	}
	
	// Método que devuelve todos los vídeos de la id de un determinado anime
	@GET
	@Path("/idAnime")
	@Produces("application/json")
	public Collection<Video> getAllVideosById(@QueryParam("id") String idAnime) {
		Collection<Video> res = repository.getAnimeVideosById(idAnime);
		if (res == null) {
			throw new NotFoundException("No se encuentra ningún vídeo.");
		}
		return res;
	}
	
	// Método que devuelve todos los vídeos del nombre de un determinado anime
	@GET
	@Path("/titleAnime")
	@Produces("application/json")
	public Collection<Video> getAllVideosByTitle(@QueryParam("title") String title) {
		Collection<Video> res = repository.getAnimeVideosByName(title);
		if (res == null) {
			throw new NotFoundException("No se encuentra ningún vídeo.");
		}
		return res;
	}	
	
	// Método que devuelve un vídeo con una determinada id
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Video getVideoById(@PathParam("id") String id) {
		Video video = repository.getVideoById(id);
		if (video == null) {
			throw new BadRequestException("La vídeo solicitado no existe.");
		}
		return video;
	}
}