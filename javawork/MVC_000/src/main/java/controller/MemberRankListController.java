package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.MemberService;
import vo.MemberRankVo;
import vo.MentoVo;

public class MemberRankListController implements Controller{
	
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		MemberService service = new MemberService();
		ArrayList<MemberRankVo> list = service.memberRankList();
		
		req.setAttribute("list", list);
		return "memberRankList";
	}
}
