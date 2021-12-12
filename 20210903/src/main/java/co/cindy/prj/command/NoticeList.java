package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.notice.service.NoticeService;
import co.cindy.prj.notice.serviceImpl.NoticeServiceImpl;


public class NoticeList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeDao = new NoticeServiceImpl();
		request.setAttribute("notices", noticeDao.noticeSelectList());
		return "notice/noticeList";
	}

}
