package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Anime;
import aiss.model.Imagen;
import aiss.model.Noticia;
import aiss.model.Producto;
import aiss.model.Video;
import aiss.model.repository.ProyectoMiyamotoRepository;
import aiss.model.repository.ProyectoMiyamotoRepositoryImplement;

@Path("/animes")
public class AnimesApiResource {

	public static AnimesApiResource _instance = null;
	ProyectoMiyamotoRepository repository;

	public AnimesApiResource() {
		repository = ProyectoMiyamotoRepositoryImplement.getInstance();

	}

	public static AnimesApiResource getInstance() {
		if (_instance == null)
			_instance = new AnimesApiResource();
		return _instance;
	}

	
	// Método que devuelve todos los animes
	@GET
	@Produces("application/json")
	public Collection<Anime> getAllAnimes() {
		return repository.getAllAnimes();
	}
	
	// Método que devuelve un anime con una determinada id
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Anime getAnimeById(@PathParam("id") String id) {
		Anime anime = repository.getAnimeById(id);
		if (anime == null) {
			throw new BadRequestException("El anime solicitado no existe.");
		}
		return anime;
	}
	
	// Método que devuelve todos los animes de un determinado título
	@GET
	@Path("/title}")
	@Produces("application/json")
	public Collection<Anime> geAllAnimesByTitle(@QueryParam("title") String title) {
		Collection<Anime> res = repository.getAnimesByTitle(title);
		if (res == null) {
			throw new NotFoundException("No se encuentra ningún anime.");
		}
		return res;
	}
	
	// Método que añade un anime
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addAnime(@Context UriInfo uriInfo, Anime anime) {
		if (anime.getId() == null || anime.getId() == "") {
			throw new BadRequestException("El anime no es válido");
		}
		repository.addAnime(anime);
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(anime);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(anime);
		return resp.build();
	}

	// Método que actualiza un anime
	@PUT
	@Consumes("application/json")
	public Response updateAnime(Anime anime) {
		Anime oldAnime = repository.getAnimeById(anime.getId());
		if (oldAnime == null) {
			throw new NotFoundException("El anime con id="+ anime.getId() +" no fue encontrado");			
		}
		else {
			repository.updateAnime(anime);
		}
		return Response.noContent().build();
	}

	// Método que elimina un anime
	@DELETE
	@Path("/{id}")
	@Consumes("application/json")
	public Response removeAnime(@PathParam("id") String id) {
		Anime anime = repository.getAnimeById(id);
		if (anime == null) {
			throw new NotFoundException("El anime con id="+ id +" no fue encontrado");			
		}
		else {
			repository.deleteAnime(id);
		}
		return Response.noContent().build();
	}
	
	// Método que añade una noticia a un anime
	@POST
	@Path("/noticia/{idAnime}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addNoticiaAnime(@Context UriInfo uriInfo, @PathParam("idAnime") String idAnime, Noticia noticia) {
		if (idAnime == null || idAnime == "") {
			throw new BadRequestException("La noticia no es válida");
		}
		repository.addNoticiaAnime(idAnime, noticia);
		ResponseBuilder resp = Response.created(uriInfo.getAbsolutePath());
		resp.entity(noticia);   
		return resp.build();
	}

	// Método que actualiza una noticia de un anime
	@PUT
	@Path("/noticia/{idAnime}")
	@Consumes("application/json")
	public Response updateNoticiaAnime(@PathParam("idAnime") String idAnime, Noticia noticia) {
		Noticia oldNoticia = repository.getNoticiaById(noticia.getId());
		if (oldNoticia == null) {
			throw new NotFoundException("La noticia no fue encontrada");			
		}
		else {
			repository.updateNoticiaAnime(idAnime, noticia);
		}
		return Response.noContent().build();
	}

	// Método que elimina una noticia de un anime
	@DELETE
	@Path("/noticia/{idAnime}/{idNoticia}")
	@Consumes("application/json")
	public Response deleteNoticiaAnime(@PathParam("idAnime") String idAnime, @PathParam("idNoticia") String idNoticia) {
		if (idNoticia == null) {
			throw new NotFoundException("La noticia no fue encontrada");			
		}
		else {
			repository.deleteNoticiaAnime(idAnime, idNoticia);
		}
		return Response.noContent().build();
	}
	
	// Método que añade una imagen a un anime
	@POST
	@Path("/imagen/{idAnime}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addImagenAnime(@Context UriInfo uriInfo, @PathParam("idAnime") String idAnime, Imagen imagen) {
		if (idAnime == null || idAnime == "") {
			throw new BadRequestException("La imagen no es válida");
		}
		repository.addImagenAnime(idAnime, imagen);
		ResponseBuilder resp = Response.created(uriInfo.getAbsolutePath());
		resp.entity(imagen);   
		return resp.build();
	}

	// Método que actualiza una imagen de un anime
	@PUT
	@Path("/imagen/{idAnime}")
	@Consumes("application/json")
	public Response updateImagenAnime(@PathParam("idAnime") String idAnime, Imagen imagen) {
		Imagen oldImagen = repository.getImagenById(imagen.getId());
		if (oldImagen == null) {
			throw new NotFoundException("La imagen no fue encontrada");			
		}
		else {
			repository.updateImagenAnime(idAnime, imagen);
		}
		return Response.noContent().build();
	}

	// Método que elimina una imagen de un anime
	@DELETE
	@Path("/imagen/{idAnime}/{idImagen}")
	@Consumes("application/json")
	public Response deleteImagenAnime(@PathParam("idAnime") String idAnime, @PathParam("idImagen") String idImagen) {
		if (idImagen == null) {
			throw new NotFoundException("La imagen no fue encontrada");			
		}
		else {
			repository.deleteImagenAnime(idAnime, idImagen);
		}
		return Response.noContent().build();
	}
	
	// Método que añade un vídeo a un anime
	@POST
	@Path("/video/{idAnime}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addVideoAnime(@Context UriInfo uriInfo, @PathParam("idAnime") String idAnime, Video video) {
		if (idAnime == null || idAnime == "") {
			throw new BadRequestException("El vídeo no es válido");
		}
		repository.addVideoAnime(idAnime, video);
		ResponseBuilder resp = Response.created(uriInfo.getAbsolutePath());
		resp.entity(video);   
		return resp.build();
	}

	// Método que actualiza un vídeo de un anime
	@PUT
	@Path("/video/{idAnime}")
	@Consumes("application/json")
	public Response updateVideoAnime(@PathParam("idAnime") String idAnime, Video video) {
		Video oldVideo = repository.getVideoById(video.getId());
		if (oldVideo == null) {
			throw new NotFoundException("El vídeo no fue encontrado");			
		}
		else {
			repository.updateVideoAnime(idAnime, video);
		}
		return Response.noContent().build();
	}

	// Método que elimina un vídeo de un anime
	@DELETE
	@Path("/video/{idAnime}/{idVideo}")
	@Consumes("application/json")
	public Response deleteVideoAnime(@PathParam("idAnime") String idAnime, @PathParam("idVideo") String idVideo) {
		if (idVideo == null) {
			throw new NotFoundException("El vídeo no fue encontrado");			
		}
		else {
			repository.deleteVideoAnime(idAnime, idVideo);
		}
		return Response.noContent().build();
	}
	
	// Método que añade un producto a un anime
	@POST
	@Path("/producto/{idAnime}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addProductoAnime(@Context UriInfo uriInfo, @PathParam("idAnime") String idAnime, Producto producto) {
		if (idAnime == null || idAnime == "") {
			throw new BadRequestException("El producto no es válido");
		}
		repository.addProductoAnime(idAnime, producto);
		ResponseBuilder resp = Response.created(uriInfo.getAbsolutePath());
		resp.entity(producto);   
		return resp.build();
	}

	// Método que actualiza un producto de un anime
	@PUT
	@Path("/producto/{idAnime}")
	@Consumes("application/json")
	public Response updateProductoAnime(@PathParam("idAnime") String idAnime, Producto producto) {
		Producto oldProducto = repository.getProductoById(producto.getId());
		if (oldProducto == null) {
			throw new NotFoundException("El producto no fue encontrado");			
		}
		else {
			repository.updateProductoAnime(idAnime, producto);
		}
		return Response.noContent().build();
	}

	// Método que elimina un producto de un anime
	@DELETE
	@Path("/producto/{idAnime}/{idProducto}")
	@Consumes("application/json")
	public Response deleteProductoAnime(@PathParam("idAnime") String idAnime, @PathParam("idProducto") String idProducto) {
		if (idProducto == null) {
			throw new NotFoundException("El producto no fue encontrado");			
		}
		else {
			repository.deleteProductoAnime(idAnime, idProducto);
		}
		return Response.noContent().build();
	}
	
	
}
