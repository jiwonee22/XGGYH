package service.face;

import javax.servlet.http.HttpServletRequest;

import dto.XMem;

//로그인, ID/PW찾기, 회원가입
public interface MemberService {

	/**
	 * req를 XMem객체로 반환
	 * @param req - 전달 받은 요청 파라미터
	 * @return req에 있는 정보를 담은 XMem객체
	 */
	public XMem getLoginMem(HttpServletRequest req);

	/**
	 * mem을 DB 정보와 조회하여 로그인을 시도하여 boolean 데이터 타입으로 반환
	 * @param mem - DB와 대조할 XMem객체
	 * @return 로그인 시도 성공 시 true, 실패 시 false
	 */
	public boolean loginMem(XMem mem);

	/**
	 * mem의 memid와 일치하는 XMem객체를 조회하여 반환
	 * @param mem
	 * @return DB에 저장되어 있던 정보를 담은 XMem객체
	 */
	public XMem getMem(XMem mem);
	
	/**
	 * 회원가입 정보 추출하기
	 * 
	 * @param req - 요청정보 객체
	 * @return XMem - 추출한 회원가입 정보
	 */
	public XMem getJoinMember(HttpServletRequest req);

	/**
	 * 회원가입 처리
	 * 
	 * @param param - 회원가입 정보 객체
	 */
	public void join(XMem param);
	
	/**
	 * 아이디 중복체크
	 * 
	 * @param memid - 입력된 아이디
	 * @return boolean - 아이디 중복 여부
	 */
	public boolean checkId(String memid);

	/**
	 * 닉네임 중복체크
	 * 
	 * @param memnick - 입력된 닉네임
	 * @return boolean - 닉네임 중복 여부
	 */
	public boolean checkNick(String memnick);	
	
	/**
	 * 이메일 중복체크
	 * 
	 * @param memmail - 입력된 이메일
	 * @return boolean - 이메일 중복 여부
	 */
	public boolean checkEmail(String memmail);

	/**
	 * 
	 * @param parameter
	 */
	public String getMemid(String parameter);

	/**
	 * @param uuidPw2 
	 * 
	 */
	public void setMempwUpdate(String mailForPw, String uuidPw);

	/**
	 * 유저정보 가져오기
	 * 
	 * @param 
	 * @return 
	 */
	public XMem getMyInfo(String memid);

	/**
	 * 유저정보 가져오기
	 * 
	 * @param memid
	 * @return
	 */
	public XMem getUpdate(String memid);

	/**
	 * 
	 * @param req
	 */
	public int updateMem(HttpServletRequest req);

	/**
	 * 
	 * @param memId
	 */
	public void setMemDelete(XMem memId);

	/**
	 * 
	 * @param kakaoemail
	 * @return
	 */
	public boolean loginMemByKakao(String kakaoemail);

	/**
	 * 
	 * @param kakaoemail
	 * @return
	 */
	public XMem getMemByKakao(String kakaoemail);

	/**
	 * 소셜 로그인 동의하였는 지 확인
	 * @param kakaoemail
	 * @return
	 */
	public boolean getKakaoAgree(String kakaoemail);

	/**
	 * 
	 * @param req
	 */
	public void setKakaoByMemmail(String kakaoagree);

	/**
	 * 
	 * @param mem
	 */
	public void setMemWithKakao(XMem mem);

}