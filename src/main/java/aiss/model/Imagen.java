package aiss.model;

public class Imagen {
	private String id;
	private String size;
	private String url;
	private String title;
	
	public Imagen() {}

	public Imagen(String id, String size, String url, String title) {
		this.id = id;
		this.size = size;
		this.url = url;
		this.title = title;
	}
	
	public Imagen(String size, String url, String title) {
		this.size = size;
		this.url = url;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}