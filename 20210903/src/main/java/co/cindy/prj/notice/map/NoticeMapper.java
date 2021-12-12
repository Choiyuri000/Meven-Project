package co.cindy.prj.notice.map;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import co.cindy.prj.notice.vo.NoticeVO;

public interface NoticeMapper { // sql Mapping을 위한 인터페이스
//	@Select("select * from notice")
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);	
	
	@Update("update notice set hit = hit + 1 where id = #{id}") // 다이렉트로 동작은 동일
	void noticeHitUpdate(int id); //추가됨
}
