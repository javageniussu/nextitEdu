package kr.or.nextit.member;

import java.util.HashMap;

public interface MemberService {

	/**
	 * HashMap 회원가입
	 * @param params
	 */
	public void insertUserInfo(HashMap<String, Object> params);

	public MemberVo insertUserInfo(
			 String userId, 
			 HashMap<String, Object> params );
	
}
