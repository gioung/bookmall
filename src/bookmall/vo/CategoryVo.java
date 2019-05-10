package bookmall.vo;

public class CategoryVo {
	private String category;

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
			System.out.println("존재할 수 없는 카테고리입니다.");
		}
	}

	@Override
	public String toString() {
		return "CategoryVo [category=" + category + "]";
	}
	
	
}
