package co.cindy.prj.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.notice.service.NoticeService;
import co.cindy.prj.notice.serviceImpl.NoticeServiceImpl;
import co.cindy.prj.notice.vo.NoticeVO;

public class MainCommand implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항리스트 뿌리기
		NoticeService noticeDao = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		list = noticeDao.noticeSelectList();
		
		request.setAttribute("notices", list);
		
		return "home/home";
	}
}
