package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.notice.service.NoticeService;
import co.cindy.prj.notice.serviceImpl.NoticeServiceImpl;
import co.cindy.prj.notice.vo.NoticeVO;

public class NoticeSelect implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 글 상세보기
		NoticeService noitceDao = new NoticeServiceImpl();
		NoticeVO notice = new NoticeVO();
		notice.setId(Integer.valueOf(request.getParameter("id")));
		
		notice = noitceDao.noticeSelect(notice);
		request.setAttribute("notice", notice);
		return "notices/noticeSelect";
	}

}
