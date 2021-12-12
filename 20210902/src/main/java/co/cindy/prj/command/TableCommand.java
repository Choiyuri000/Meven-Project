package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;

public class TableCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 테이블 페이지 돌려주기
		return "home/tables";
	}

}
