package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.notice.service.NoticeService;
import co.cindy.prj.notice.serviceImpl.NoticeServiceImpl;
import co.cindy.prj.notice.vo.NoticeVO;

public class NoticeSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 세부 글 보기
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setId(9);;
		
		request.setAttribute("notice", noticeDao.noticeSelect(vo));
		return "notice/noticeSelect";
	}

}
