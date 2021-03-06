package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.XJjim;
import dto.XShow;
import util.Paging;

public interface JjimDao {

	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return int - XJjim테이블 전체 행 수 조회 결과
	 */
	public int selectCntByMemId(Connection conn, String memid);
	
	/**
	 * XJjim 테이블에 정보 삽입
	 * @param conn - DB 연결 객체
	 * @param jjim - XJjim 테이블에 들어갈 정보
	 * @return 정보 넣는데 성공 했는지 아닌지 여부
	 */
	public int insertJjim(Connection conn, XJjim jjim);
	
	/**
	 * 
	 * @param connection - DB 연결 객체
	 * @param memId - 검색할 회원 정보
	 * @param showNo - 검색할 공연 번호
	 * @return XJjim 테이블의 정보를 삭제 했는지 아닌지 여부
	 */
	public int deleteJjim(Connection conn, String memId, String showNo);
	
	/**
	 * @param connection - DB 연결 객체
	 * @param memId - 유저 아이디
	 * @param showNo - 공연 번호
	 * @return memId와 showNo로 DB를 조회한 결과가 있는지 여부
	 */
	public boolean selectXJjimByMemIdShowNo(Connection conn, String memId, int showNo);

	/**
	 * 
	 * @param connection
	 * @param paging
	 * @param memid
	 * @return
	 */
	public List<XShow> selectShowByMemId(Connection conn, Paging paging, String memid);

	
	/**
	 * paging없이 리스트 받기
	 * 
	 * @param conn
	 * @param memid
	 * @return List<XShow>
	 */
	public List<XShow> selectShowByMemId(Connection conn, String memid);

}
