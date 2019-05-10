package bookmall.test;

import java.util.ArrayList;
import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;
import bookmall.vo.OrdersBookVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		OrderVo order1 = new OrderVo();
		order1.setMember_no(1L);
		order1.setAddress("경기도 포천시");
		insert_order(order1);

	}
		//order insert
		public static void insert_order(OrderVo vo) {
		//최근 키값 받기
		Long order_no=new OrderDao().insertOrder(vo);
			
		//책 주문 리스트
		List<OrdersBookVo> list = new ArrayList<>();
		OrdersBookVo element1 = new OrdersBookVo();
		element1.setOrder_no(order_no);
		element1.setBook_no(2L);
		element1.setQty(3L);
		element1.setPayment(35000*3L);
		list.add(element1);
			
		OrdersBookVo element2 = new OrdersBookVo();
		element2.setOrder_no(order_no);
		element2.setBook_no(3L);
		element2.setQty(2L);
		element2.setPayment(13800*2L);
		list.add(element2);
		new OrderDao().insertOrderBook(list);
	}
	
	
}
