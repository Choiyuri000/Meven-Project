package co.cindy.prj.member.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.member.service.MemberService;
import co.cindy.prj.member.serviceImpl.MemberServiceImpl;
import co.cindy.prj.member.vo.MemberVO;

public class MemberSelect implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl(); 
		MemberVO member = new MemberVO();  // VO 객체 생성
		member.setId(request.getParameter("id"));
		member = memberDao.memberSelect(member);
		
		request.setAttribute("member", member); // jsp에 결과를 전달하기 위해
		return "member/memberSelect";
	}

}