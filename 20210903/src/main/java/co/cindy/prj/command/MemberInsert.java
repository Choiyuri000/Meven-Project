package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.member.service.MemberService;
import co.cindy.prj.member.serviceImpl.MemberServiceImpl;
import co.cindy.prj.member.vo.MemberVO;

public class MemberInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 멤버 추가
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId("shady");
		vo.setPassword("1234");
		vo.setName("신디");
		vo.setAddress("대구광역시 동구");
		// 여기에 폼화면서 넘어온 값을 vo에
		memberDao.memberInsert(vo);
		
		return "memberList.do";
	}

}
