package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.CourseService;
import vo.CourseVo;

public class CourseupdateController implements Controller{
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getMethod());
		
		if(req.getMethod().equals("POST")) {
			return  processUpdateServic(req, resp);
		}else if (req.getMethod().equals("GET")) {
			return processInsertView(req, resp);
		}
		return "redirect::/";
	}
	
	private String processUpdateServic(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		int credit = Integer.parseInt(req.getParameter("credit"));
		String lecturer = req.getParameter("lecturer");
		System.out.println(lecturer);
		String week = req.getParameter("week");
		int start_hour = Integer.parseInt(req.getParameter("start_hour"));
		int end_hour = Integer.parseInt(req.getParameter("end_hour"));
		
		
		CourseVo course = new CourseVo();
		course.setId(id);
		course.setName(name);
		course.setCredit(credit);
		course.setLecturer(lecturer);
		course.setWeek(week);
		course.setStart_hour(start_hour);
		course.setEnd_hour(end_hour);
		
		
		
		CourseService service = new CourseService();
		int  n = 0;	
		try {
			n = service.courseUpdate(course);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(n>0) {
			return "redirect::courseList"; 
		}else {
			return "update";
		}
	}
	
private String processInsertView(HttpServletRequest req, HttpServletResponse resp) {
		
			String id = req.getParameter("id");
			
			CourseService service = new CourseService();
			CourseVo course = service.getCourse(id);
			req.setAttribute("course", course);
			
			return "update";
	}
}
