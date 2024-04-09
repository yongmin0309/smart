package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.CourseService;
import vo.CourseVo;

public class CourseListController implements Controller{
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		CourseService service = new CourseService();
		ArrayList<CourseVo> list = service.courseList();
		
		req.setAttribute("list", list);
		return "list";
	}
}
