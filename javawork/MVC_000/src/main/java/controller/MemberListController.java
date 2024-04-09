package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.MemberService;
import vo.MemberVo;

public class MemberListController implements Controller{
	
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		MemberService service = new MemberService();
		ArrayList<MemberVo> list = service.memberList();
		
		req.setAttribute("list", list);
		return "memberList";
	}
		
	
}	