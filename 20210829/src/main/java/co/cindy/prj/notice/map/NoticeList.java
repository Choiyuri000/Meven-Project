package co.cindy.prj.notice.map;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.notice.service.NoticeService;
import co.cindy.prj.notice.serviceImpl.NoticeServiceImpl;
import co.cindy.prj.notice.vo.NoticeVO;

public class NoticeList implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 목록보기
		NoticeService noticeDao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		
		notices = noticeDao.noticeSelectList();
		request.setAttribute("notices", notices);
		
		return "notice/noticeList";
	}

}
