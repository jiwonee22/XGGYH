package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.XAsk;
import dto.XComment;
import util.Paging;

public interface AdminAskService {

	/**
	 * 페이징 객체 생성
	 * 
	 * 요청 파라미터 curPage를 구함
	 * XAsk 테이블과 curPage값을 이용하여 Paging 객체를 구하여 반환
	 * 
	 * @param req - 요청 정보 객체
	 * @return 페이징 계산이 완료된 Paging 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	/**
	 * 게시판의 게시글 리스트 조회 paging처리
	 * 
	 * @param paging - paging 객체
	 * @return 게시글 리스트 반환
	 */
	public List<XAsk> getAskList(Paging paging);

	/**
	 * 문의 askNo 구함
	 * 
	 * @param req - 요청 정보 객체
	 * @return XAsk
	 */
	public XAsk getAskNo(HttpServletRequest req);

	/**
	 * 선택한 ask_no에 맞는 게시글 상세 조회
	 * 
	 * @param xaskno - 선택한 ask_no
	 * @return 해당 ask_no에 맞는 XAsk 내용
	 */
	public XAsk getAskDetail(XAsk xaskno);

	/**
	 * XAsk 객체의 mem_id를 이용한 닉네임 조회
	 * 
	 * @param - 조회할 게시글 정보
	 * @return - 게시글 작성자의 닉네임
	 */
	public String getNick(XAsk xask);

	/**
	 * ask_no을 통해서 해당 ask_no에 맞는 문의에 댓글 작성
	 * 
	 * @param req - 요청 객체
	 * @param xaskno - 문의 번호
	 */
	public XComment setCommentWrite(HttpServletRequest req, XAsk xaskno);

	/**
	 * ask_no을 통해서 해당 ask_no에 맞는 댓글 조회
	 * @param xaskno - ask_no
	 * @return List<XComment>
	 */
	public XComment getComment(XAsk xaskno);

	/**
	 * ask_no int로 가져오기
	 * 
	 * @param req - 요청 객체
	 * @return int ask_no
	 */
	public int getAskNoInt(HttpServletRequest req);

	/**
	 * ask_no로 댓글 삭제하기
	 * 
	 * @param xaskno - XAsk ask_no
	 */
	public void deleteComment(XAsk xaskno);

	/**
	 * 답변이 null이 아니면 y로 변경
	 * 
	 * @param xaskno - 해당 ask_no
	 */
	public void updateAskStatetoY(XAsk xask);

	/**
	 * 답변이 null이면 n로 변겨
	 * 
	 * @param xask - 해당 ask_no
	 */
	public void updateAskStatetoN(XAsk xask);

	/**
	 * comment_no 구함
	 * 
	 * @param req - 요청 정보 객체
	 * @return int
	 */
	public int getCommentNo(HttpServletRequest req);

	/**
	 * comment_no을 통해 해당 comment 수정
	 * 
	 * @param req - 요청 정보 객체
	 * @param commentno - comment_no
	 * @return XComment
	 */
	public XComment setCommentUpdate(HttpServletRequest req, int commentno);


}
