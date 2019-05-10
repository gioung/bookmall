package bookmall.main;

import java.util.List;
import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderVo;
import bookmall.vo.OrdersBookVo;

public class BookMall {

	public static void main(String[] args) {
		
		
		getList_member();
		getList_category();
		getList_book();
		getList_cart();
		getList_order();
		
	

	}
	
	
	//member select
	public static void getList_member()
	{
		System.out.println("=======================멤버 목록=======================");
		
		MemberDao dao = new MemberDao();
		List<MemberVo> list =dao.getList();
		
		for(MemberVo e:list) {
			System.out.println(e);
		}
		System.out.println();
		
	}
	
	//category select
	public static void getList_category()
	{
		System.out.println("=======================카테고리 목록=======================");
		
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list =dao.getList();
		
		for(CategoryVo e:list) {
			System.out.println(e);
		}
		
		System.out.println();
	}
	
	
	//book select
	public static void getList_book()
	{
		System.out.println("=======================도서 목록=======================");
		
		BookDao dao = new BookDao();
		List<BookVo> list =dao.getList();
		
		for(BookVo e:list) {
			System.out.println(e);
		}
		
		System.out.println();
	}
	
	
	
	//cart select
	public static void getList_cart()
	{
		System.out.println("=======================카트 목록=======================");
		CartDao dao = new CartDao();
		List<CartVo> list =dao.getList();
		
		for(CartVo e:list) {
			System.out.println(e);
		}
		
		System.out.println();
	}
	
	
	
	
	//order select
	public static void getList_order()
	{
		System.out.println("=======================주문 목록=======================");
		OrderDao dao = new OrderDao();
		List<OrderVo> list =dao.getOrderList(1L);
		
		for(OrderVo e:list) {
			System.out.println(e);
		}
		
		System.out.println();
		
		System.out.println("=======================주문도서 목록=======================");
		List<OrdersBookVo> list2 = dao.getOrderBookList(1L);
		
		for(OrdersBookVo e:list2) {
			System.out.println(e);
		}
		
		System.out.println();
	}
	
	
	
	
	
}
