package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtils;
import vo.CourseVo;


public class CourseDao {
	public int CourseInsert(CourseVo course) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps =  conn.prepareStatement("Insert into course_tbl values(?,?,?,?,?,?,?)");
			ps.setString(1, course.getId());
			ps.setString(2, course.getName());
			ps.setInt(3, course.getCredit());
			ps.setInt(4, course.getLecturer_insert());
			ps.setString(5, course.getWeek());
			ps.setInt(6, course.getStart_hour());
			ps.setInt(7, course.getEnd_hour());
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
	
	
	public ArrayList<CourseVo> courseList() {
		ArrayList<CourseVo> list = new ArrayList<CourseVo>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" select id, name, credit,\r\n "
					+ " decode(lecturer,'1','김교수','2','이교수','3','박교수','4','우교수','5','최교수','6','임교수') lecturer ,\r\n "
					+ " decode(week ,'1','월요일' ,'2','화요일' ,'3','수요일' ,'4','목요일' ,'5','금요일') week,\r\n "
					+ " start_hour, end_hour\r\n "
					+ " from course_tbl order by id ");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CourseVo vo = new CourseVo();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setCredit(rs.getInt("credit"));
				vo.setLecturer(rs.getString("lecturer"));
				vo.setWeek(rs.getString("week"));
				vo.setStart_hour(rs.getInt("start_hour"));
				vo.setEnd_hour(rs.getInt("end_hour"));
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
	
	public CourseVo getCourse(String id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CourseVo  vo = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" select id, name, credit, lecturer, week, "
					+ " start_hour, end_hour "
					+ " from course_tbl where id = ?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				vo = new CourseVo();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setCredit(rs.getInt("credit"));
				vo.setLecturer(rs.getString("lecturer"));
				vo.setWeek(rs.getString("week"));
				vo.setStart_hour(rs.getInt("start_hour"));
				vo.setEnd_hour(rs.getInt("end_hour"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		return vo;
	}
	
	public int courseUpdate(CourseVo course) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0 ;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" Update course_tbl set name=?, credit=?, lecturer=? ,"
					+ " week=?, start_hour=?, end_hour=? where id=? ");
			ps.setString(1, course.getName());
			ps.setInt(2, course.getCredit());
			ps.setString(3, course.getLecturer());
			ps.setString(4, course.getWeek());
			ps.setInt(5, course.getStart_hour());
			ps.setInt(6, course.getEnd_hour());
			ps.setString(7, course.getId());
			n = ps.executeUpdate();
			if(n>0) {
				conn.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			DBUtils.close(conn, ps);
		}
		return n;
	}
	
	public int courseDelete(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			String sql = " Delete from course_tbl where id=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			n = ps.executeUpdate();
			if(n>0) {		
				DBUtils.commit(conn);
			}
		}catch(Exception e) {
			e.printStackTrace();
			DBUtils.rollack(conn);
		} finally {
			DBUtils.close(conn, ps);
		}
		return n;
	}
}
