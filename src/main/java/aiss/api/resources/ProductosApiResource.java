package aiss.api.resources;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Producto;
import aiss.model.repository.ProyectoMiyamotoRepository;
import aiss.model.repository.ProyectoMiyamotoRepositoryImplement;

@Path("/productos")
public class ProductosApiResource {

	public static ProductosApiResource _instance = null;
	
	ProyectoMiyamotoRepository repository;

	public ProductosApiResource() {
		repository = ProyectoMiyamotoRepositoryImplement.getInstance();
	}

	public static ProductosApiResource getInstance() {
		if (_instance == null) {
			_instance = new ProductosApiResource();
		}
		return _instance;
	}
	
	// Método que devuelve todos los productos
	@GET
	@Produces("application/json")
	public Collection<Producto> getAllProductos() {
		return repository.getAllAnimeProductos();
	}
	
	// Método que devuelve todos los productos de la id de un determinado anime
	@GET
	@Path("/idAnime")
	@Produces("application/json")
	public Collection<Producto> getAllProductosById(@QueryParam("id") String idAnime) {
		Collection<Producto> res = repository.getAnimeProductosById(idAnime);
		if (res == null) {
			throw new NotFoundException("No se encuentra ningún producto.");
		}
		return res;
	}
	
	// Método que devuelve todos los productos del nombre de un determinado anime
	@GET
	@Path("/titleAnime")
	@Produces("application/json")
	public Collection<Producto> getAllProductosByTitle(@QueryParam("title") String title) {
		Collection<Producto> res = repository.getAnimeProductosByName(title);
		if (res == null) {
			throw new NotFoundException("No se encuentra ningún producto.");
		}
		return res;
	}	
	
	// Método que devuelve un producto con una determinada id
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Producto getProductoById(@PathParam("id") String id) {
		Producto producto = repository.getProductoById(id);
		if (producto == null) {
			throw new BadRequestException("La producto solicitado no existe.");
		}
		return producto;
	}
}
