package co.cindy.prj.member.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.member.service.MemberService;
import co.cindy.prj.member.serviceImpl.MemberServiceImpl;
import co.cindy.prj.member.vo.MemberVO;

public class MemberDelete implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 멤버 삭제
		MemberService memberDao = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id"));
		int n = memberDao.memberDelete(member);
		String page = null;
		if(n != 0 ) {
			page = "memberList.do";
		} else {
			request.setAttribute("msg", "회원정보 삭제시 오류 발생");
			page = "member/memberError";
		}
		
		return page;
	}

}
