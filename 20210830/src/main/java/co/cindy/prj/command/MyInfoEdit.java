package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.cindy.prj.common.Command;
import co.cindy.prj.member.vo.MemberVO;
import co.cindy.prj.service.MemberService;
import co.cindy.prj.serviceImpl.MemberServiceImpl;

public class MyInfoEdit implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 개인 정보 수정
		MemberService memberDao = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		HttpSession session = request.getSession(); // 세션객체 가져오기
		member.setId((String)session.getAttribute("id")); // 세션이 가지고 있는 사용자 id
		
		member = memberDao.memberSelect(member);
		request.setAttribute("member", member);
		
		return "member/memberInfo";
	}

}
