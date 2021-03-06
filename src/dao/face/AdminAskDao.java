package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.XAsk;
import dto.XComment;
import util.Paging;

public interface AdminAskDao {

	/**
	 * 페이지 수 구하기
	 * 
	 * @param connection - DB 정보 객체
	 * @return int
	 */
	public int selectCntAll(Connection conn);

	/**
	 * 게시판 리스트 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - paging 정보 객체
	 * @return List<XAsk> - XAsk 테이블 전체 조회 결과
	 */
	public List<XAsk> selectAskAll(Connection conn, Paging paging);

	/**
	 * ask_no을 통해서 해당 게시글 정보 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param xaskno - 게시글 조회를 위한 ask_no
	 * @return XAsk 객체
	 */
	public XAsk selectAskByAskNo(Connection conn, XAsk xaskno);

	/**
	 * id를 이용
	 * @param conn - DB 이용 객체
	 * @param xask - 조회할 id를 가진 객체
	 * @return String - 작성자 닉네임
	 */
	public String getNickByMemId(Connection conn, XAsk xask);

	/**
	 * 댓글 정보 저장
	 * 
	 * @param conn - DB 연결 객체
	 * @param comment - 전달된 댓글 정보
	 * @return - 1 or 0
	 */
	public int insertComment(Connection conn, XComment comment);

	/**
	 * 댓글 정보 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param xaskno - 전달된 ask_no
	 * @return XComment
	 */
	public XComment selectCommentByAskNo(Connection conn, XAsk xaskno);

	/**
	 * 댓글 정보 삭제
	 * 
	 * @param conn - DB 연결 객체
	 * @param xaskno - 전달된 ask_no
	 */
	public void deleteCommentByAskNo(Connection conn, XAsk xaskno);

	/**
	 * ask_state n으로 변경
	 * 
	 * @param conn - DB 연결 객체
	 * @param xask - ask_no
	 * @return int
	 */
	public int updateAskStateToN(Connection conn, XAsk xask);

	/**
	 * ask_state y로 변경
	 * 
	 * @param conn - DB 연결 객체
	 * @param xask - ask_no
	 * @return int
	 */
	public int updateAskStateToY(Connection conn, XAsk xask);

	/**
	 * comment 수정
	 * 
	 * @param conn - DB 연결 객체
	 * @param comment - 수정된 comment
	 * @return int
	 */
	public int updateComment(Connection conn, XComment comment);


}
