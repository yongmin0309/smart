package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtils;
import vo.MemberMoneyVo;
import vo.MemberVo;

public class MemberDao {
	
	
	public ArrayList<MemberVo> memberList() {
		
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select custno, custname, phone, "
	+ " address, joindate, decode(grade,'A','VIP','B','일반','C','직원') grade, city \r\n"
	+ " from member_tbl_02 order by custno");
			rs = ps.executeQuery();
			System.out.println(100);
			while(rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
				list.add(vo);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return list;
	}
	public ArrayList<MemberMoneyVo> memberMoneyList(){
		ArrayList<MemberMoneyVo> list = new ArrayList<MemberMoneyVo>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select A.custno, A.custname, "
			+ "decode(A.grade,'A','VIP','B','일반','C','직원') grade, sum(B.PRICE) price \r\n"
			+ " from member_tbl_02 A, money_tbl_02 B"
			+ " where A.custno = B.custno \r\n"
			+ " group by A.custno, A.custname, A.grade \r\n"
			+ " order by price desc");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberMoneyVo vo = new MemberMoneyVo();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getNString("custname"));
				vo.setGrade(rs.getString("grade"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return list;
	}
	
	public int getMaxCustNo() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int custno = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select max(custno)+1 custno from member_tbl_02");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				custno = rs.getInt("custno");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return custno;
	}
	
	public int memberInsert(MemberVo member) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("insert into member_tbl_02 values(?,?,?,?,?,?,?)");
			ps.setInt(1, member.getCustno());
			ps.setString(2, member.getCustname());
			ps.setString(3, member.getPhone());
			ps.setString(4, member.getAddress());
			ps.setDate(5, member.getJoindate());
			ps.setString(6, member.getGrade());
			ps.setString(7, member.getCity());
			n = ps.executeUpdate();
			if(n>0) {
				conn.commit();
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			DBUtils.close(conn, ps);
		}
		return n;
	}
	
	public MemberVo getMember(int custno) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVo vo = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select custno, custname, phone, address, joindate, grade, city \r\n"
					+ "from member_tbl_02 where custno =?");
					ps.setInt(1, custno);
					rs = ps.executeQuery();
					
					while(rs.next()) {
						vo = new MemberVo();
						vo.setCustno(rs.getInt("custno"));
						vo.setCustname(rs.getString("custname"));
						vo.setPhone(rs.getString("phone"));
						vo.setAddress(rs.getString("address"));
						vo.setJoindate(rs.getDate("joindate"));
						vo.setGrade(rs.getString("grade"));
						vo.setCity(rs.getString("city"));
					}
			}catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				DBUtils.close(conn, ps,rs);
			}
		return vo;
	}
		public int memberUpdate(MemberVo member) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			int n = 0;
			
			try {
				conn = DBUtils.getConnection();
				ps = conn.prepareStatement("Update member_tbl_02 set custname=?, phone=?,"
						+ " address=?, joindate=?, grade=?, city=? where custno=?");
				ps.setString(1, member.getCustname());
				ps.setString(2, member.getPhone());
				ps.setString(3, member.getAddress());
				ps.setDate(4, member.getJoindate());
				ps.setString(5, member.getGrade());
				ps.setString(6, member.getCity());
				ps.setInt(7, member.getCustno());
				n = ps.executeUpdate();
				if(n>0) {
					conn.commit();
				}
			}catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			}
			finally {
				DBUtils.close(conn, ps);
			}
			return n;
		}
}
