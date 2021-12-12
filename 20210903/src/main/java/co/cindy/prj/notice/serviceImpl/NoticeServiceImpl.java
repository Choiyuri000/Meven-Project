package co.cindy.prj.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.cindy.prj.common.DataSource;
import co.cindy.prj.notice.map.NoticeMapper; 
import co.cindy.prj.notice.service.NoticeService;
import co.cindy.prj.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true); // 데이터 베이스 연결
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class); // mapper 연결

	@Override
	public List<NoticeVO> noticeSelectList() {
		// 게시글 목록
		return map.noticeSelectList();
		//return sqlSession.selectList("noticeSelectList"); // "mapper id"
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		// 세부 글 보기전 먼저 hit수를 증가 시킴
		map.noticeHitUpdate(vo.getId());
		return map.noticeSelect(vo);
		//sqlSession.update("noticeHitUpdate", vo.getId());
		//return sqlSession.selectOne("noticeSelect", vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// 게시글 추가
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// 게시글 수정
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		// 게시글 삭제
		return map.noticeDelete(vo);
	}

}
