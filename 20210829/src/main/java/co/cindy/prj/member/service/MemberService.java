package co.cindy.prj.member.service;

import java.util.List;

import co.cindy.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> MemberSelectList();
	MemberVO memberSelect(MemberVO vo); // 전제 목록
	int memberInsert(MemberVO vo);		// 멤버 추가
	int memberUpdate(MemberVO vo);		// 멤버 정보 수정
	int memberDelete(MemberVO vo);		// 멤버 정보 삭제
	
	MemberVO memberLogin(MemberVO vo); 	// 로그인 처리
	boolean isIdCheck(String str); 		// 아이디 중복체크
}
