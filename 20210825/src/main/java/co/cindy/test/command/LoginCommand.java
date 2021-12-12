package co.cindy.test.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.test.common.Command;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 타자치지 않음, 로그인 처리과정을 기술하고 결과 페이지를 설정
		return "member/loginResult";
	}

}
