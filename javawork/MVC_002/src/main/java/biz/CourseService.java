package biz;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.CourseDao;
import vo.CourseVo;

	

public class CourseService {
	
	CourseDao dao = new CourseDao();
	
	public ArrayList<CourseVo> courseList(){
		ArrayList<CourseVo> list = dao.courseList();
		return list;
	}
	
	
	public int courseInsert(CourseVo course) throws SQLException {
		int n = dao.CourseInsert(course);
		return n;
	}
	
	public CourseVo getCourse(String id) {
		CourseVo course = dao.getCourse(id);
		return course;
	}
	
	public int courseUpdate(CourseVo course) throws SQLException {
		int n = dao.courseUpdate(course);
		return n;
	}
	
	public int courseDelete(String id) {
		int n = dao.courseDelete(id);
		return n;
	}
}
