package com.yj.loveMemory.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	
	private String mbId;
	private String mbPwd;
	private String mbNickName;
	private String birthday;
	private String profile;
	
	
}
