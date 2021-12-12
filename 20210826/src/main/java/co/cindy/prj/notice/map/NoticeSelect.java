package co.cindy.prj.notice.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.notice.service.NoticeService;
import co.cindy.prj.notice.serviceImpl.NoticeServiceImpl;
import co.cindy.prj.notice.vo.NoticeVO;

public class NoticeSelect implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO notice = new NoticeVO();
		
		notice.setId(Integer.valueOf(request.getParameter("id")));
		notice = noticeDao.noticeSelect(notice);
		//notice.setId(request.getParameter("id"));
		request.setAttribute("notice", notice);
		
	
		return "notice/noticeSelect";
	}

}
