package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;

public class LoginForm implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 폼만 호출
		return "member/loginForm";
	}

}

