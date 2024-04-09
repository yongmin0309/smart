package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.CourseService;
import vo.CourseVo;



public class CourseInsertController implements Controller{
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getMethod());
		
		if(req.getMethod().equals("POST")) {
			return  processInsertServic(req, resp);
		}else if (req.getMethod().equals("GET")) {
			
			return "insert";
		}
		return "redirect::/";
	}
	
	private String processInsertServic(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		int credit = Integer.parseInt(req.getParameter("credit"));
		int lecturer = Integer.parseInt(req.getParameter("lecturer"));
		System.out.println(lecturer);
		String week = req.getParameter("week");
		int start_hour = Integer.parseInt(req.getParameter("start_hour"));
		int end_hour = Integer.parseInt(req.getParameter("end_hour"));
		
		
		CourseVo course = new CourseVo();
		course.setId(id);
		course.setName(name);
		course.setCredit(credit);
		course.setLecturer_insert(lecturer);
		course.setWeek(week);
		course.setStart_hour(start_hour);
		course.setEnd_hour(end_hour);
		
		
		
		CourseService service = new CourseService();
		int  n = 0;	
		try {
			n = service.courseInsert(course);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(n>0) {
			return "redirect::courseList"; 
		}else {
			return "insert";
		}
	}
}
