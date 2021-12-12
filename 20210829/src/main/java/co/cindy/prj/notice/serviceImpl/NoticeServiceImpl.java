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
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<NoticeVO> noticeSelectList() {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo;
		String sql = "select * from notice";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new NoticeVO();
				vo.setId(rs.getInt("id"));
				vo.setWriter(rs.getString("writer"));
				vo.setWriteDate(rs.getDate("writeDate"));
				vo.setTitle(rs.getString("title"));
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
	public NoticeVO noticeSelect(NoticeVO vo) {
		String sql = "select * from notice where id=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo.setId(rs.getInt("id"));
				vo.setWriter(rs.getString("writer"));
				vo.setWriteDate(rs.getDate("writeDate"));
				vo.setTitle(rs.getString("title"));
				vo.setHit(rs.getInt("hit"));

				hitCountUpdate(vo.getId()); // 조회수 증가 메소드 호출
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	private void hitCountUpdate(int id) { // 조회수 증가 메소드 (내부적으로 사용)
		String sql = "update notice set hit  = hit+1 where id=?";
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
	public int noticeInsert(NoticeVO vo) {
		int n = 0;
		String sql = "insert into notice(id,writer,writeDate,title,contents) " + "values(?,?,?,?,?)";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			psmt.setString(2, vo.getWriter());
			psmt.setDate(3, vo.getWriteDate());
			psmt.setString(4, vo.getTitle());
			psmt.setString(5, vo.getContents());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		int n = 0;
		try {
			String sql = "update notice set writeDate=?,title=?,contents=? where id=?";
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setDate(1, vo.getWriteDate());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContents());
			psmt.setInt(4, vo.getId());
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
		String sql = "delete from notice wherd id=?";
		try {
			conn = dao.getConnection();
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
