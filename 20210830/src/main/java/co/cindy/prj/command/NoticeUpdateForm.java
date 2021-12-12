package co.cindy.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.notice.service.NoticeService;
import co.cindy.prj.notice.serviceImpl.NoticeServiceImpl;
import co.cindy.prj.notice.vo.NoticeVO;

public class NoticeUpdateForm implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 수정할 수 있는 폼 호출
		NoticeService noitceDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.valueOf(request.getParameter("id")));
		vo= noitceDao.noticeSelect(vo);
		request.setAttribute("notice", vo);
		
		return "notices/noticeUpdateForm";
	}

}
