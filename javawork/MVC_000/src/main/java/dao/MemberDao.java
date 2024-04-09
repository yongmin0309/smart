package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtils;
import vo.MemberRankVo;
import vo.MemberVo;
import vo.MentoVo;

public class MemberDao {
	public ArrayList<MemberVo> memberList() {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select artist_id, artist_name,\r\n"
					+ "substr(a.artist_birth,1,4) ||'년'||substr(a.artist_birth,5,2)||'월'|| substr(a.artist_birth,7,2)||'일' as artist_birth ,\r\n"
					+ " decode(a.artist_gender,'M','남','F','여') as gender, decode(a.talent,'1','보컬','2','댄스','3','랩') as talent, a.agency \r\n"
					+ " from tbl_artist_201905 a \r\n"
					+ " order by a.artist_id");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_birth(rs.getString("artist_birth"));
				vo.setArtist_gender(rs.getString("gender"));
				vo.setTalent(rs.getString("talent"));
				vo.setAgency(rs.getString("agency"));
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
	
	public ArrayList<MentoVo> mentoList() {
		ArrayList<MentoVo> list = new ArrayList<MentoVo>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" select c.serial_no, a.artist_name, \r\n"
					+ "	substr(a.artist_birth,1,4) ||'년'|| substr(a.artist_birth,5,2)||'월'|| substr(a.artist_birth,7,2)||'일' as artist_birth, c.point,\r\n "
					+ "	case when c.point >=90 then 'A'\r\n"
					+ "			when c.point >=80 then 'B'\r\n"
					+ "			when c.point >=70 then 'C'\r\n"
					+ "			when c.point >=60 then 'D'\r\n"
					+ "			else 'F' end as point_rank ,\r\n"
					+ "	b.mento_name\r\n"
					+ " from tbl_artist_201905 a, tbl_mento_201905 b, tbl_point_201905 c\r\n"
					+ " where a.artist_id = c.artist_id and b.mento_id = c.mento_id ");
							
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MentoVo vo = new MentoVo();
				vo.setSerial_no(rs.getString("serial_no"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_birth(rs.getString("artist_birth"));
				vo.setPoint(rs.getInt("point"));
				System.out.println(rs.getString("point_rank"));
				vo.setPoint_rank(rs.getString("point_rank"));
				vo.setMento_name(rs.getString("mento_name"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps,rs);
		}
		
		return list;
	}
	public ArrayList<MemberRankVo> memberRankList() {
		ArrayList<MemberRankVo> list = new ArrayList<MemberRankVo>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" select a.artist_name, sum(b.point) as point_sum, "
					+ " round(avg(b.point),2) as point_avg, RANK() OVER(order by sum(b.point) desc) as point_rk \r\n"
					+ " from tbl_artist_201905 a, tbl_point_201905 b\r\n"
					+ " where a.artist_id = b.artist_id\r\n"
					+ " group by a.artist_name\r\n"
					+ " order by sum(b.point) desc ");
							
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberRankVo vo = new MemberRankVo();
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setPoint_sum(rs.getInt("point_sum"));
			
				vo.setPoint_avg(rs.getInt("point_avg"));
				vo.setPoint_rk(rs.getInt("point_rk"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps,rs);
		}
		
		return list;
}	
	public int memberInsert(MemberVo member) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps =  conn.prepareStatement("Insert into tbl_artist_201905 values(?,?,?,?,?,?)");
			ps.setString(1, member.getArtist_id());
			ps.setString(2, member.getArtist_name());
			ps.setString(3, member.getArtist_birth());
			ps.setString(4, member.getArtist_gender());
			ps.setString(5, member.getTalent());
			ps.setString(6, member.getAgency());
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
}
