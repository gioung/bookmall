package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bookmall.main.DBConn;
import bookmall.vo.CategoryVo;


public class CategoryDao {
  //insert
	public Boolean insert(CategoryVo vo) {
		Boolean result = false;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		try {
				conn = DBConn.getConnection();
				String sql="insert into category values(?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,vo.getCategory());
				int count = pstmt.executeUpdate();
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
				};
		}return result;
	}
	
	//select
	public List<CategoryVo> getList(){
		List<CategoryVo> result = new ArrayList<>();
		
		Connection conn = null; 
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
				conn=DBConn.getConnection();
				String sql = "select * from category"; 
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
		
				while(rs.next()) {
					
					String category = rs.getString(1);
					CategoryVo vo = new CategoryVo();
					vo.setCategory(category);
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
