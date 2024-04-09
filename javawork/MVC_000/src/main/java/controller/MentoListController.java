package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.MemberService;
import vo.MentoVo;

public class MentoListController implements Controller{
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		MemberService service = new MemberService();
		ArrayList<MentoVo> list = service.mentoList();
		
		req.setAttribute("list", list);
		return "mentoList";
	}
}
