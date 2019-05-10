package bookmall.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		//cart #1
		CartVo cart1 = new CartVo();
		cart1.setMember_no(1L);
		cart1.setBook_no(1L);
		cart1.setQty(3L);
		cart1.setPayment(15000*3L);
		insert_cart(cart1);
				
		//cart #2
		CartVo cart2 = new CartVo();
		cart2.setMember_no(1L);
		cart2.setBook_no(2L);
		cart2.setQty(1L);
		cart2.setPayment(35000*1L);
		insert_cart(cart2);
	}
	 
	//cart insert
		public static void insert_cart(CartVo vo) {
			new CartDao().insert(vo);
		}
	public static void getListTest()
	{
		CartDao dao = new CartDao();
		List<CartVo> list =dao.getList();
		
		for(CartVo e:list) {
			System.out.println(e);
		}
	}

}
