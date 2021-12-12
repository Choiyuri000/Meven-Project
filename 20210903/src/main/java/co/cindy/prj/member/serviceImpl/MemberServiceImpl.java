package co.cindy.prj.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.cindy.prj.common.DataSource;
import co.cindy.prj.member.map.MemberMapper;
import co.cindy.prj.member.service.MemberService;
import co.cindy.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true); // dao 연결
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class); // mapper 를 연결

	@Override
	public List<MemberVO> memberSelectList() {
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// 데이터를 입력
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// 데이터 갱신
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// 데이터 삭제
		return map.memberDelete(vo);
	}
	
}
