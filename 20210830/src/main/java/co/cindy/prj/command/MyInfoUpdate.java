package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.member.vo.MemberVO;
import co.cindy.prj.service.MemberService;
import co.cindy.prj.serviceImpl.MemberServiceImpl;

public class MyInfoUpdate implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 변경된 값 저장하는 메소드
		MemberService memberDao = new MemberServiceImpl();
	    MemberVO member = new MemberVO();
	    member.setId(request.getParameter("id"));
	    member.setPassword(request.getParameter("password"));
	    member.setName(request.getParameter("name"));
	   member.setAddress(request.getParameter("address"));
	   member.setAuth(request.getParameter("auth"));
	    
	    int n = memberDao.memberUpdate(member);
	    if(n != 0) {
	    	request.setAttribute("message","정상적으로 수정되었다.");
	    } else {
	    	request.setAttribute("message","수정이 실패하였다.");
	    }
	    
	    
		return "member/memberEditResult";
	}

}
