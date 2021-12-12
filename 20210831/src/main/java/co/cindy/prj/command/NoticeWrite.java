package co.cindy.prj.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.notice.service.NoticeService;
import co.cindy.prj.notice.serviceImpl.NoticeServiceImpl;
import co.cindy.prj.notice.vo.NoticeVO;

public class NoticeWrite implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 저장
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setWriter(request.getParameter("writer"));
		vo.setWriteDate(Date.valueOf(request.getParameter("writeDate")));
		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));
		
		int n = noticeDao.noticeInsert(vo);
		if(n != 0) {
			request.setAttribute("message", "정상적으로 저장 되었습니다.");
		} else {
			request.setAttribute("message", "입력이 실패했습니다.");
		}
		return "notices/noticeInsertResult";
	}

}
