package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;

public class MainCommand implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 홈페이지 호출
		return "main/main";
	}

}
