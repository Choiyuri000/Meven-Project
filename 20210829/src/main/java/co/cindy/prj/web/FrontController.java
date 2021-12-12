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

import co.cindy.prj.command.MainCommand;
import co.cindy.prj.common.Command;
import co.cindy.prj.member.map.IdCheck;
import co.cindy.prj.member.map.MemberDelete;
import co.cindy.prj.member.map.MemberEdit;
import co.cindy.prj.member.map.MemberEditForm;
import co.cindy.prj.member.map.MemberJoin;
import co.cindy.prj.member.map.MemberJoinForm;
import co.cindy.prj.member.map.MemberList;
import co.cindy.prj.member.map.MemberLogin;
import co.cindy.prj.member.map.MemberLoginForm;
import co.cindy.prj.member.map.MemberSelect;
import co.cindy.prj.notice.map.NoticeList;
import co.cindy.prj.notice.map.NoticeSelect;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException { // 요청 Command 정의하는 부분
		map.put("/main.do", new MainCommand()); // 처음페이지 호출 , 계속추가하여 호출
		map.put("/memberLogin.do", new MemberLogin()); // 로그인
		map.put("/memberLoginForm.do", new MemberLoginForm()); // 로그인폼 호출
		map.put("/memberList.do", new MemberList()); // 멤버 목록
		map.put("/memberSelect.do", new MemberSelect()); // 멤버 세부 정보
		map.put("/memberDelete.do", new MemberDelete()); // 멤버 정보 삭제
		map.put("/memberJoin.do", new MemberJoin()); // 회원가입
		map.put("/memberJoinForm.do", new MemberJoinForm()); // 회원가입폼 호출
		map.put("/idCheck.do", new IdCheck()); // 아이디 중복 체크
		map.put("/memberEdit.do", new MemberEdit()); // 멤버 정보 수정
		map.put("/memberEditForm.do", new MemberEditForm()); // 멤버 정보 수정폼 호출
		map.put("/noticeList.do", new NoticeList()); // 게시글 목록
		map.put("/noticeSelect.do", new NoticeSelect()); // 게시글 세부 정보
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // 실제 처리하는 부분 (요청을 분석하고, 실행하는 부분)
		request.setCharacterEncoding("utf-8"); // 한글 처리
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		String viewPage = null;

		Command command = map.get(path); // 요청 command 찾기
		viewPage = command.excute(request, response); // 요청 command 실행

		if (viewPage != null) { // view Resolve
			if (!viewPage.endsWith(".do")) {
				viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
