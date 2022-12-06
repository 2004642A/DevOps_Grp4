public class AllProduct {
	public AllProduct(String name, String category, Double price, String image) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	protected String name;
	protected String category;
	protected Double price;
	protected String image;
	
	
	
	
}
