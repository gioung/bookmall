package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bookmall.main.DBConn;
import bookmall.vo.MemberVo;

public class MemberDao {
	//insert
	public Boolean insert(MemberVo vo) {
		Boolean result = false;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		try {
				conn = DBConn.getConnection();
				String sql="insert into member values(null,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,vo.getName());
				pstmt.setString(2,vo.getPwd());
				pstmt.setString(3,vo.getTel());
				pstmt.setString(4,vo.getEmail());
				pstmt.setString(5,vo.getAddress());
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
	public List<MemberVo> getList(){
		List<MemberVo> result = new ArrayList<>();
		
		Connection conn = null; 
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
				conn=DBConn.getConnection();
				
				String sql = "select no,name,tel,email,address from member"; 
				
				
				//PreparedStatement 객체 생성 
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			// 결과 가져오기
				while(rs.next()) {
					Long no = rs.getLong(1);
					String name = rs.getString(2);
					String tel = rs.getString(3);
					String email = rs.getString(4);
					String address = rs.getString(5);
					
					MemberVo vo = new MemberVo();
					vo.setNo(no);
					vo.setName(name);
					vo.setTel(tel);
					vo.setEmail(email);
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
	

}

