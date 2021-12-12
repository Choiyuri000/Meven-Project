package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;

public class NoticeWriteForm implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 입력 폼 호출
		return "notices/noticeWriteForm";
	}

}
