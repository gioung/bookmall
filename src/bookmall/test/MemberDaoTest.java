package bookmall.test;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;



public class MemberDaoTest {

	public static void main(String[] args) {
				//멤버1
				MemberVo member1 = new MemberVo();
				
				member1.setName("남기웅");
				member1.setPwd("2345");
				member1.setTel("010-9958-9833");
				member1.setEmail("ska2253@naver.com");
				member1.setAddress("경기도 포천시");
				insert_member(member1);
				
				//멤버2
				MemberVo member2 = new MemberVo();
				
				member2.setName("김둘리");
				member2.setPwd("5678");
				member2.setTel("010-5252-5252");
				member2.setEmail("duli@michol.com");
				member2.setAddress("외계행성");
				insert_member(member2);

	}
		//member insert
		public static void insert_member(MemberVo member) {
			MemberDao memberdao = new MemberDao();
			memberdao.insert(member);
		}
	
}
