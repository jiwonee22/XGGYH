package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.JjimDao;
import dto.XShow;
import util.Paging;

public class JjimDaoImpl implements JjimDao {
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<XShow> selectAllByMemid(Connection conn, Paging paging, String memid) {
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, X.* FROM (";
		sql += "		SELECT";
		sql += "			mem_id";
		sql += "		FROM xjjim";
		sql += "		WHERE mem_id = ?";
		sql += "		ORDER BY jjim_no DESC";
		sql += "	) X";
		sql += " ) XSHOW";
		sql += " WHERE rnum BETWEEN ? AND ?";

		List<XShow> jjimlist = new ArrayList<>(); 
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, memid);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				XShow s = new XShow();

				s.setShowNo(rs.getInt("show_no"));
				s.setAdminId(rs.getString("admin_id"));
				s.setShowTitle(rs.getString("show_title"));
				s.setShowDate(rs.getDate("show_date"));
				s.setShowStart(rs.getDate("show_start"));
				s.setShowEnd(rs.getDate("show_end"));
				
				jjimlist.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return jjimlist;
	}

	@Override
	public int selectCntByMemId(Connection conn, String memid) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM xjjim";
		sql += " WHERE mem_id = ?";
				
		//총 게시글 수
		int count = 0;
				
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, memid);
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
}