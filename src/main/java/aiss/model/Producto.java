package aiss.model;

public class Producto {
	private String id;
	private String name;
	private String prize;
	private String url;
	private String description;

	public Producto() {}
	
	public Producto(String id, String name, String prize, String url, String description) {
		this.id = id;
		this.name = name;
		this.prize = prize;
		this.url = url;
		this.description = description;
	}
	
	public Producto(String name, String prize, String url, String description) {
		this.name = name;
		this.prize = prize;
		this.url = url;
		this.description = description;
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

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}