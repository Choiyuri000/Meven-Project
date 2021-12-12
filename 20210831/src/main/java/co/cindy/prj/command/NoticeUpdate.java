package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.notice.service.NoticeService;
import co.cindy.prj.notice.serviceImpl.NoticeServiceImpl;
import co.cindy.prj.notice.vo.NoticeVO;

public class NoticeUpdate implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 글 수정
		NoticeService noticeDao = new NoticeServiceImpl();
		System.out.println("===>" +request.getParameter("contents"));
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.valueOf(request.getParameter("id")));
		vo.setContents(request.getParameter("contents"));
		
		int n = noticeDao.noticeUpdate(vo); // 수정이 일어남
		String page = null;
		if(n != 0) {
			vo = noticeDao.noticeSelect(vo);
			request.setAttribute("notices", vo);
			page = "notices/noticeSelect";
		} else {
			request.setAttribute("message", "수정 실패");
			page = "notices/noticeInsertResult";
		}
		return page;
	}

}
