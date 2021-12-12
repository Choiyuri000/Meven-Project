package co.cindy.prj.member.map;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.cindy.prj.common.Command;
import co.cindy.prj.member.service.MemberService;
import co.cindy.prj.member.serviceImpl.MemberServiceImpl;
import co.cindy.prj.member.vo.MemberVO;

public class MemberList implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// member List
		MemberService memberDao = new MemberServiceImpl(); // DB 연결하고, 값을 가져오는 model을 생성
		List<MemberVO> members = new ArrayList<MemberVO>(); // 리스트 타입으로 결과를 받아오기 위해
		members = memberDao.MemberSelectList(); // 모델을 호출해서 결과를 받음
		
		request.setAttribute("members", members); // 결과를 jsp페이지에 전달하기 위해
		return "member/memberList"; // 보여줄 것을 선택하는 것
		
	}

}
