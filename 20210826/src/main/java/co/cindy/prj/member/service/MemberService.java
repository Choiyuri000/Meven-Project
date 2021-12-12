package co.cindy.prj.member.service;

import java.util.List;

import co.cindy.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> MemberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	
	MemberVO memberLogin(MemberVO vo); 	// 로그인 처리
	boolean isIdCheck(String str); 		//아이디 중복체크
}
