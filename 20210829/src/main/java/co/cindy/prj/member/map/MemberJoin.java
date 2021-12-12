package co.cindy.prj.member.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.member.service.MemberService;
import co.cindy.prj.member.serviceImpl.MemberServiceImpl;
import co.cindy.prj.member.vo.MemberVO;


public class MemberJoin implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id"));
		
		
		int n = memberDao.memberInsert(member);
		
		if(n != 0) {
			request.setAttribute("message", "성공적으로 가입되었습니다");
		} else {
			request.setAttribute("message", "가입이 실패되었습니다.");
		}
		return "member/memberJoinResult";
	}

}
