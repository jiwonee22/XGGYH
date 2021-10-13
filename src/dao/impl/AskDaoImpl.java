package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.AskDao;
import dto.XAsk;
import util.Paging;

public class AskDaoImpl implements AskDao {
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<XAsk> selectAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT * FROM xask";
		sql += " ORDER BY ask_no DESC";
		
		List<XAsk> askList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				XAsk ask = new XAsk();
				
				ask.setAskNo( rs.getInt("askNo") );
				ask.setMemId( rs.getString("MemId") );
				ask.setAskTitle( rs.getString("askTitle") );
				ask.setAskContent( rs.getString("askContent") );
				ask.setAskDate( rs.getDate("askDate") );
				ask.setAskKind( rs.getString("askKind") );
				ask.setAskState( rs.getString("askState") );
				
				askList.add(ask);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return askList;
	}
	
	@Override
	public List<XAsk> selectAll(Connection conn, Paging paging) {
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, X.* FROM (";
		sql += "		SELECT";
		sql += "			ask_no, mem_id, ask_title, ask_content";
		sql += "			, ask_date, ask_kind, ask_state";
		sql += "		FROM xask";
		sql += "		ORDER BY ask_no DESC";
		sql += "	) X";
		sql += " ) XASK";
		sql += " WHERE rnum BETWEEN ? AND ?";

		List<XAsk> askList = new ArrayList<>(); 
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				XAsk ask = new XAsk();
				
				ask.setAskNo( rs.getInt("ask_no") );
				ask.setMemId( rs.getString("Mem_id") );
				ask.setAskTitle( rs.getString("ask_title") );
				ask.setAskContent( rs.getString("ask_content") );
				ask.setAskDate( rs.getDate("ask_date") );
				ask.setAskKind( rs.getString("ask_kind") );
				ask.setAskState( rs.getString("ask_state") );

				askList.add(ask);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return askList;
	}

	@Override
	public int selectCntAll(Connection conn) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM xask";
		
		//총 게시글 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return count;
	}
		
	@Override
	public int selectNextAskNo(Connection conn) {
		
		String sql = "";
		sql += "SELECT xask_seq.nextval FROM dual";
		
		int nextAskNo = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				nextAskNo = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextAskNo;
	}
	
	@Override
	public int insert(Connection conn, XAsk ask) {
		
		String sql = "";
		sql += "INSERT INTO xask(ASK_NO, MEM_ID, ASK_TITLE, ASK_CONTENT, ASK_KIND, ASK_STATE)";
		sql += " VALUES (?, ?, ?, ?, ?, ?)";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, ask.getAskNo());
			ps.setString(2, ask.getMemId());
			ps.setString(3, ask.getAskTitle());
			ps.setString(4, ask.getAskContent());
			ps.setString(5, ask.getAskKind());
			ps.setString(6, ask.getAskState());

			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}


}