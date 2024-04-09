package biz;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.MemberDao;
import vo.MemberRankVo;
import vo.MemberVo;
import vo.MentoVo;

public class MemberService {

		MemberDao dao = new MemberDao();
		
		public ArrayList<MemberVo> memberList(){
			ArrayList<MemberVo> list = dao.memberList();
			return list;
		}
			
		public ArrayList<MentoVo> mentoList() {
			ArrayList<MentoVo> list = dao.mentoList();
			return list;
		}
		
		public ArrayList<MemberRankVo> memberRankList() {
			ArrayList<MemberRankVo> list = dao.memberRankList();
			return list;
		}
		
		public int memberInsert(MemberVo member) throws SQLException {
			int n = dao.memberInsert(member);
			return n;
		}
}
