package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.MemberService;
import vo.MemberVo;

public class MemberInsertController implements Controller{
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getMethod());
		
		if(req.getMethod().equals("POST")) {
			return  processInsertServic(req, resp);
		}else if (req.getMethod().equals("GET")) {
			
			return "memberInput";
		}
		return "redirect::/";
	}
	
	private String processInsertServic(HttpServletRequest req, HttpServletResponse resp) {
		String artist_id = req.getParameter("artist_id");
		String artist_name = req.getParameter("artist_name");
		String artist_birth = req.getParameter("artist_birth");
		String artist_gender = req.getParameter("artist_gender");
		System.out.println(artist_gender);
		String talent = req.getParameter("talent");
		String agency = req.getParameter("agency");
		
		MemberVo member = new MemberVo();
		member.setArtist_id(artist_id);
		member.setArtist_name(artist_name);
		member.setArtist_birth(artist_birth);
		member.setArtist_gender(artist_gender);
		member.setTalent(talent);
		member.setAgency(agency);
		
		MemberService service = new MemberService();
		int  n = 0;	
		try {
			n = service.memberInsert(member);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(n>0) {
			return "redirect::memberList"; 
		}else {
			return "memberInput";
		}
	}

		
}	
		

