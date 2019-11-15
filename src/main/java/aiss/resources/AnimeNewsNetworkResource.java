package aiss.resources;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.animeNewsNetwork.Anime;
import aiss.animeNewsNetwork.Ann;
import aiss.animeNewsNetwork.News;
import aiss.animeNewsNetwork.SearchAnimeNews;

public class AnimeNewsNetworkResource {

	private static final Logger log = Logger.getLogger(AnimeNewsNetworkResource.class.getName());

	private static final String URL_ANIMENEWSNETWORK = "http://cdn.animenewsnetwork.com/encyclopedia/api.xml?title=~%QUERY";

	public Collection<SearchAnimeNews> getAnimeNews(String param) throws IOException, UnsupportedEncodingException {
		String query = URLEncoder.encode(param, "UTF-8");
		ClientResource cr = null;
		List<Element> animes = new ArrayList<>();
		List<News> listaNoticias = new ArrayList<>();
		List<SearchAnimeNews> res = new ArrayList<>();
		try {
			cr = new ClientResource(URL_ANIMENEWSNETWORK.replace("%QUERY", query));
			String resultado = cr.get().getText();
			Document doc = Jsoup.parse(resultado, "", Parser.xmlParser());
			animes.addAll(doc.getElementsByTag("ann").first().getElementsByTag("anime"));
			for (Element elementoAnime : animes) {
				List<Element> newsElements = new ArrayList<>();
				Anime anime = new Anime();
				Ann ann = new Ann();
				SearchAnimeNews searchAnimeNews = new SearchAnimeNews();
				newsElements.addAll(elementoAnime.getElementsByTag("news"));
				for (Element e : newsElements) {
					News news = new News();
					String noticiaEnlace = e.attr("href");
					String noticiaFecha = e.attr("datetime").substring(0, 10);
					String cita = e.getElementsByAttribute("href").text().replaceAll("[<cite>|</cite>]", "");
					news.setCite(cita);
					news.setDatetime(noticiaFecha);
					news.setHref(noticiaEnlace);
					listaNoticias.add(news);
				}
				anime.setNews(listaNoticias);
				ann.setAnime(anime);
				searchAnimeNews.setAnn(ann);
				res.add(searchAnimeNews);
			}
			log.log(Level.FINE, "Búsqueda de noticias de " + query + " realizada correctamente.");
		} catch (ResourceException e) {
			log.log(Level.WARNING, "Error al obtener las noticias: " + cr.getResponse().getStatus());
			throw e;
		}
		return res;
	}

	
}