package com.yj.loveMemory.member.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yj.loveMemory.member.model.vo.Member;

@Mapper
public interface MemberDAO {

	public Member login(Member m);

}
