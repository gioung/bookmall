package bookmall.vo;



public class BookVo {
	private String category;
	private String title;
	private Long price;
	private Long no;
	
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getNo() {
		return no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		if("IT".equals(category)) {
			this.category=category;
		}
		else if("소설".equals(category)) {
			this.category=category;
		}
		else if("경제".equals(category)) {
			this.category=category;
		}
		else {
			System.out.println("없는 카테고리입니다.");
		}
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookVo [no="+no+", category=" + category + ", title=" + title + ", price=" + price + "]";
	}
	
	
}
