package co.cindy.test.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import co.cindy.test.common.DAO;
import co.cindy.test.member.service.MemberService;
import co.cindy.test.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private DAO dao = DAO.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
			

	@Override
	public List<MemberVO> memberSelectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO memberLoginCheck(MemberVO vo) {
		// 로그인 체크
		
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	} 
}
