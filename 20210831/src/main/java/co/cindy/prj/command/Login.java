package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.cindy.prj.common.Command;
import co.cindy.prj.member.vo.MemberVO;
import co.cindy.prj.service.MemberService;
import co.cindy.prj.serviceImpl.MemberServiceImpl;

public class Login implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 과정 처리
		MemberService memberDao = new MemberServiceImpl(); // 모델 호출
		MemberVO member = new MemberVO();
		HttpSession session = request.getSession(); // 서버가 가지고 있는 session 객체를 불러온다
		
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		
		member = memberDao.memberLogin(member);
		String message = null;
		if(member.getName() != null) {
			message = member.getName() + "님 환영합니다!";
			session.setAttribute("id", member.getId()); // 색션객체의 아이디와 권한 담는다
			session.setAttribute("password", member.getPassword());
			session.setAttribute("auth", member.getAuth());
		} else {
			message = member.getId() + "는 존재하지 않거나 패스워드가 틀렸습니다.";
		}
		
		request.setAttribute("message", message);
		return "member/loginResult";
	}

}
