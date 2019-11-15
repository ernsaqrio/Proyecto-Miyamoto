package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.aliExpress.SearchProducts;
import aiss.resources.AliExpressResource;




public class AliExpressController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(AliExpressController.class.getName());

	public AliExpressController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;

		log.log(Level.INFO, "Procesando AliExpressController.");
		String query = request.getParameter("searchQuery");

		AliExpressResource aliexpress = new AliExpressResource();
		
		log.log(Level.INFO, "Buscando para AliExpress productos de " + query);
		SearchProducts aliexpressResults = aliexpress.getProducts(query);
		
		if ( aliexpressResults != null) {
			request.setAttribute("productos", aliexpressResults);
			rd = request.getRequestDispatcher("/resultados.jsp");
			log.log(Level.FINE, "Búsqueda de productos realiazada y procesada correctamente.");
		} else {
			log.log(Level.WARNING, "Error al realizar la búsqueda");
			rd = request.getRequestDispatcher("/error.jsp");
		}
		
		rd.forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doGet(request, response);
	}

}
