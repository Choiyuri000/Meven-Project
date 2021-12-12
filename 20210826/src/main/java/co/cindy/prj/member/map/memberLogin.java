package co.cindy.prj.member.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.member.service.MemberService;
import co.cindy.prj.member.serviceImpl.MemberServiceImpl;
import co.cindy.prj.member.vo.MemberVO;

public class memberLogin implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));

		member = memberDao.memberLogin(member);
		String page = null;
		if (member.getName() != null) {
			request.setAttribute("message", "님 환영합니다");
			request.setAttribute("member", member);
			page = "member/memberLoginSuccess";

		} else {
			request.setAttribute("message", "id 또는 password가 일치하지 않습니다");
			page = "member/memberError";
		}

		return page;
	}

}
