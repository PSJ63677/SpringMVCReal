package com.kh.spring.member.service;

import com.kh.spring.member.domain.Member;

public interface MemberService {
	
	/**
	 * 멤버 등록 Service
	 * @param member
	 * @return int
	 */
	public int insertMember(Member member);
	
	/**
	 * 멤버 정보 수정 Service
	 * @param member
	 * @return int
	 */
	public int updateMember(Member member);
	
	/**
	 * 멤버 탈퇴 Service
	 * @param memberId
	 * @return int
	 */
	public int deleteMember(String memberId);

	/**
	 * 멤버 로그인 Service
	 * @param mParam
	 * @return Member
	 */
	public Member checkMemberLogin(Member member);
	
	/**
	 * 아이디로 멤버 조회 Service
	 * @param memberId
	 * @return Member
	 */
	public Member selectOneById(String memberId);

}
