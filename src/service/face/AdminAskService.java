package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.XAsk;
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

	public XAsk getAsk_no(HttpServletRequest req);

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


}