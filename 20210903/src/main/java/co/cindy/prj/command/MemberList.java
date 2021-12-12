package co.cindy.prj.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.member.service.MemberService;
import co.cindy.prj.member.serviceImpl.MemberServiceImpl;
import co.cindy.prj.member.vo.MemberVO;

public class MemberList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl();
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = memberDao.memberSelectList();
		
		request.setAttribute("members", list);
		
		return "member/memberList";
	}

}
