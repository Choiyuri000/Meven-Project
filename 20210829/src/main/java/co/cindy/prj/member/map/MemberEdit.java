package co.cindy.prj.member.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.member.service.MemberService;
import co.cindy.prj.member.serviceImpl.MemberServiceImpl;
import co.cindy.prj.member.vo.MemberVO;

public class MemberEdit implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 회원 정보 수정
		MemberService memberDao = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member.setName(request.getParameter("name"));
		member.setAddress(request.getParameter("address"));

		int n = memberDao.memberUpdate(member);
		String page = null;
		if (n != 0) {
			request.setAttribute("member",member);
			page = "member/memberSelect"; // 상세보기로 보낸다.
		} else {
			request.setAttribute("message", "수정 불가");
			page = "member/memberError";
		}
		return page;
	}

}
