package co.cindy.prj.notice.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.cindy.prj.common.DataSource;
import co.cindy.prj.notice.service.NoticeService;
import co.cindy.prj.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	private DataSource dao = DataSource.getInstance(); // 싱글톤 객체
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<NoticeVO> noticeSelectList() { // 전체조회 join이용
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo;
		String sql = "select a.*,b.name from notice a, member b where a.writer = b.id";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new NoticeVO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setWriteDate(rs.getDate("writeDate"));
				vo.setContents(rs.getString("contents"));
				vo.setHit(rs.getInt("hit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) { // 세부 내용 보기
		String sql = "select a.*,b.name from notice a, member b where a.writer = b.id and a.id=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setWriteDate(rs.getDate("writeDate"));
				vo.setHit(rs.getInt("hit"));
				
				noticeHitUpdate(vo.getId()); // 조회수 증가 메소드
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	private void noticeHitUpdate(int id) { // 조회수 증가
		String sql = "update notice set hit = hit + 1 where id= ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int noticeInsert(NoticeVO vo) { // 게시글 삽입
		int n = 0;
		String sql ="insert into notice(id, writer, writeDate, title, contents) values(n_id.nextval,?,?,?,?)";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getWriter());
			psmt.setDate(2, vo.getWriteDate());
			psmt.setString(3, vo.getTitle());
			psmt.setString(4, vo.getContents());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		int n = 0;
		String sql = "update notice set contents =? where id =?";
		try {
			conn = dao.getConnection();
			psmt =conn.prepareStatement(sql);
			psmt.setString(1, vo.getContents());
			psmt.setInt(2, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		int n = 0;
        String sql = "delete from notice where id = ?";
        try {
			conn =dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
