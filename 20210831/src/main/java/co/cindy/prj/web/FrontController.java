package co.cindy.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.command.LogOut;
import co.cindy.prj.command.Login;
import co.cindy.prj.command.LoginForm;
import co.cindy.prj.command.MainCommand;
import co.cindy.prj.command.MyInfoEdit;
import co.cindy.prj.command.MyInfoUpdate;
import co.cindy.prj.command.NoticeList;
import co.cindy.prj.command.NoticeSelect;
import co.cindy.prj.command.NoticeUpdate;
import co.cindy.prj.command.NoticeUpdateForm;
import co.cindy.prj.command.NoticeWrite;
import co.cindy.prj.command.NoticeWriteForm;
import co.cindy.prj.common.Command;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); // 홈
		map.put("/loginForm.do", new LoginForm()); // 로그인 폼 호출
		map.put("/login.do", new Login()); // 로그인
		map.put("/logOut.do", new LogOut()); // 로그아웃
		map.put("/myInfoEdit.do", new MyInfoEdit()); // 개인정보 수정
		map.put("/myInfoUpdate.do", new MyInfoUpdate());
		map.put("/noticeList.do", new NoticeList()); // 게시판 목록
		map.put("/noticeSelect.do", new NoticeSelect()); // 게시글 상세목록
		map.put("/noticeWriteForm.do", new NoticeWriteForm()); // 게시글 폼 호출
		map.put("/noticeWrite.do", new NoticeWrite()); // 게시글 작성
		map.put("/noticeUpdate.do", new NoticeUpdate()); // 게시글 수정
		map.put("/noticeUpdateForm.do", new NoticeUpdateForm()); // 게시글 수정 폼 호출
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());

		Command command = map.get(page); // "/main.do"
		String viewPage = command.excute(request, response);

		if (!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
