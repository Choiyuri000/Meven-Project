package co.cindy.test.member.service;

import java.util.List;

import co.cindy.test.member.vo.MemberVO;

public interface MemberService {
	 List<MemberVO> memberSelectList();
	 MemberVO memberSelect(MemberVO vo);
	 MemberVO memberLoginCheck(MemberVO vo);
	 int memberInsert(MemberVO vo);
	 
}
