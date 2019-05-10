package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookmall.main.DBConn;
import bookmall.vo.OrderVo;
import bookmall.vo.OrdersBookVo;

public class OrderDao {
	
	public Long insertOrder(OrderVo vo) {
		Boolean result = false;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		Long no = 0L;
		try {
				conn = DBConn.getConnection();
				String sql="insert into orders values(null,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, vo.getMember_no());
				pstmt.setString(2, vo.getAddress());
				int count = pstmt.executeUpdate();
				result = (count == 1);
				
				//최근쿼리 받기.
				sql ="SELECT LAST_INSERT_ID()";
				stmt = conn.createStatement();
				rs=stmt.executeQuery(sql);
				
				if(rs.next()) {
					no = rs.getLong(1);
				}
				
				
				
		}catch (SQLException e) {
				// TODO Auto-generated catch block
			 System.out.println("error" + e);
			}
		finally {
				try {
					if(conn!=null)
						conn.close();
					if(pstmt!=null)
						pstmt.close();
					if(stmt!=null)
						stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
		}return no;
	}
	
	public Boolean insertOrderBook(List<OrdersBookVo> list) {
		Boolean result = false;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		int count=0;
		try {
			conn = DBConn.getConnection();
			for(OrdersBookVo vo:list) {
			String sql="insert into orders_book values(?,?,?,?)";
			//pk of orders , Long book_no , Long qty , Long payment
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, vo.getOrder_no());
			pstmt.setLong(2, vo.getBook_no());
			pstmt.setLong(3, vo.getQty());
			pstmt.setLong(4, vo.getPayment());
			count = pstmt.executeUpdate();
			}
			result = (count == 1);
			
			
			
	}catch (SQLException e) {
			// TODO Auto-generated catch block
		 System.out.println("error" + e);
		}
	finally {
			try {
				if(conn!=null)
					conn.close();
				if(pstmt!=null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return result;
	}
	
	//orders select
	public List<OrderVo> getOrderList(Long member_number){
		List<OrderVo> result = new ArrayList<>();
		
		Connection conn = null; 
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
				conn=DBConn.getConnection();
				
				String sql = "select no,member_no,address from orders where member_no="+member_number; 
				
				
				//PreparedStatement 객체 생성 
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			// 결과 가져오기
				while(rs.next()) {
					
					Long no = rs.getLong(1);
					Long member_no = rs.getLong(2);
					String address = rs.getString(3);
					
					OrderVo vo = new OrderVo();
					vo.setNo(no);
					vo.setMember_no(member_no);
					vo.setAddress(address);
					result.add(vo);
				}
				
		}catch (SQLException e) {
				// TODO Auto-generated catch block
			 System.out.println("error" + e);
			}
		finally {
				try {
					if(conn!=null)
						conn.close();
					if(rs!=null)
							rs.close();
					if(pstmt!=null)
							pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return result;
	}
	//booklist select
	public List<OrdersBookVo> getOrderBookList(Long order_num){
		List<OrdersBookVo> result = new ArrayList<>();
		
		Connection conn = null; 
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
				conn=DBConn.getConnection();
				
				String sql = "select order_no,book_no,qty,payment from orders_book where order_no="+order_num; 
				
				
				//PreparedStatement 객체 생성 
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			// 결과 가져오기
				while(rs.next()) {
					//pk of orders , Long book_no , Long qty , Long payment
					Long order_no = rs.getLong(1);
					Long book_no = rs.getLong(2);
					Long qty = rs.getLong(3);
					Long payment = rs.getLong(4);
					
					OrdersBookVo vo = new OrdersBookVo();
					vo.setOrder_no(order_no);
					vo.setBook_no(book_no);
					vo.setQty(qty);
					vo.setPayment(payment);
					result.add(vo);
				}
				
		}catch (SQLException e) {
				// TODO Auto-generated catch block
			 System.out.println("error" + e);
			}
		finally {
				try {
					if(conn!=null)
						conn.close();
					if(rs!=null)
							rs.close();
					if(pstmt!=null)
							pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return result;
	}
	
}
