package bookmall.test;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
				//book #1
				BookVo book1 = new BookVo();
				book1.setCategory("경제");
				book1.setTitle("부의 추월차선");
				book1.setPrice(15000L);
				insert_book(book1);
				
				//book #2
				BookVo book2 = new BookVo();
				book2.setCategory("IT");
				book2.setTitle("HTTP 완벽 가이드");
				book2.setPrice(35000L);
				insert_book(book2);
				
				//book #3
				BookVo book3 = new BookVo();
				book3.setCategory("소설");
				book3.setTitle("모멘트");
				book3.setPrice(13800L);
				insert_book(book3);

	}
	//book insert
	public static void insert_book(BookVo vo) {
			new BookDao().insert(vo);
	}
	

}
