package com.yj.loveMemory.member.model.service;

import com.yj.loveMemory.member.model.vo.Couple;
import com.yj.loveMemory.member.model.vo.Member;

public interface MemberService {

	public Member login(Member m);

	public int signUp(Member m);

	public Member getPartner(String partner);

	public Couple getCouple(Member loginUser);
}
