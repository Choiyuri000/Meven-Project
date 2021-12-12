package co.cindy.prj.member.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.member.service.MemberService;
import co.cindy.prj.member.serviceImpl.MemberServiceImpl;
import co.cindy.prj.member.vo.MemberVO;

public class MemberEditForm implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 회원 수정 폼을 돌려준다. 회원 정보를 가지고 가서 수정
		MemberService memberDao = new MemberServiceImpl();
		MemberVO member  = new MemberVO();
		member.setId(request.getParameter("id"));
		member = memberDao.memberSelect(member);
		request.setAttribute("member", member);
		
		return "member/memberEditForm";
	}

}
