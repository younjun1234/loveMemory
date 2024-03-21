package com.yj.loveMemory.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.loveMemory.member.model.dao.MemberDAO;
import com.yj.loveMemory.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO mDAO;

	@Override
	public Member login(Member m) {
		return mDAO.login(m);
	}

}
