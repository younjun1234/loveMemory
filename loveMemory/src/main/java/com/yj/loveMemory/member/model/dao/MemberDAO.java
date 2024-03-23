package com.yj.loveMemory.member.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yj.loveMemory.member.model.vo.Couple;
import com.yj.loveMemory.member.model.vo.Member;

@Mapper
public interface MemberDAO {

	public Member login(Member m);

	public int signUp(Member m);

	public Member getPartner(String partner);

	public Couple getCouple(Member loginUser);

}
