package co.cindy.prj.member.map;

import java.util.List;

import co.cindy.prj.member.vo.MemberVO;

public interface MemberMapper { // sql Mapping을 위한 인터페이스
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
}
	