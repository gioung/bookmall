package bookmall.test;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDatTest {

	public static void main(String[] args) {
		
		//DB에서 enum 타입으로 정의 (IT,경제,소설)
		insert_category("경제");
		insert_category("IT");
		insert_category("소설");
	}
	
	//category insert
	public static void insert_category(String category) {
			CategoryVo vo = new CategoryVo();
			vo.setCategory(category);
			new CategoryDao().insert(vo);
	}
	
	
}
