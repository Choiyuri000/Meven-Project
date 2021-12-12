package co.cindy.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.cindy.prj.common.DataSource;
import co.cindy.prj.member.service.MemberService;
import co.cindy.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement pmst;
	private ResultSet rs;

	@Override
	public List<MemberVO> MemberSelectList() {
		// 회원 전체 리스트
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select * from member";
		MemberVO vo;
		try {
			conn = dao.getConnection();
			pmst = conn.prepareStatement(sql);
			rs = pmst.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	private void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pmst != null) {
				pmst.close();
			}if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// 회원 세부 정보
		String sql = "select * from member where id=?";
		try {
			conn = dao.getConnection();
			pmst = conn.prepareStatement(sql);
			pmst.setString(1, vo.getId());
			rs = pmst.executeQuery();
			if (rs.next()) {
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// 회원 정보 추가
		String sql = "insert into member valuses(?,?,?,?)";
		int n = 0;
		try {
			conn = dao.getConnection();
			pmst = conn.prepareStatement(sql);
			pmst.setString(1, vo.getId());
			pmst.setString(2, vo.getPassword());
			pmst.setString(3, vo.getName());
			pmst.setString(4, vo.getAddress());
			n = pmst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// 회원 정보 수정
		String sql = "update member set password=?, name=?, address=? where id=?";
		int n = 0;
		try {
			conn = dao.getConnection();
			pmst = conn.prepareStatement(sql);
			pmst.setString(1, vo.getPassword());
			pmst.setString(2, vo.getName());
			pmst.setString(3, vo.getAddress());
			pmst.setString(4, vo.getId());
			n = pmst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// 회원 정보 삭제
		String sql = "delect form member where id=?";
		int n = 0;
		try {
			conn = dao.getConnection();
			pmst = conn.prepareStatement(sql);
			pmst.setString(1, vo.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		// 로그인 처리
		String sql = "select name from member where id=? and password=?";
		try {
			conn = dao.getConnection();
			pmst = conn.prepareStatement(sql);
			pmst.setString(1, vo.getId());
			pmst.setString(2, vo.getPassword());
			rs = pmst.executeQuery();
			if (rs.next()) {
				vo.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public boolean isIdCheck(String str) {
		// 아이디 중복 체크 있으면 false값을 리턴
		boolean b = true;
		String sql = "select id from member where id=?";
		try {
			conn = dao.getConnection();
			pmst = conn.prepareStatement(sql);
			pmst.setString(1, str);
			rs = pmst.executeQuery();
			if(rs.next()) {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return b;
	}

}
