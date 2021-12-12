package co.cindy.prj.service;

import java.util.List;

import co.cindy.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo); 
	int memberUpdate(MemberVO vo); 
	int memberDelete(MemberVO vo); 
	boolean isIdCheck(String str); // 아이디 중복 체크
	MemberVO memberLogin(MemberVO vo); // 로그인 메소드
}
