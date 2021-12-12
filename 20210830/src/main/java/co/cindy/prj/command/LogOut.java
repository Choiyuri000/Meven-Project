package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.cindy.prj.common.Command;

public class LogOut implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 로그 아웃
		HttpSession session = request.getSession();
		session.invalidate(); // 섹션 전체를 삭제
		
		return "main.do";
	}

}
