package co.cindy.prj.member.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.member.service.MemberService;
import co.cindy.prj.member.serviceImpl.MemberServiceImpl;

public class IdCheck implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 아이디 중복 체크
		MemberService memberDao = new MemberServiceImpl();
		String str = request.getParameter("id");
		boolean b = memberDao.isIdCheck(str);
		if (!b) {
			request.setAttribute("message", str + "는 이미 존제하는 아이디");
		} else {
			request.setAttribute("message", str + "는 사용가능한 아이디");
		}
		return "member/idCheck";
	}

}
