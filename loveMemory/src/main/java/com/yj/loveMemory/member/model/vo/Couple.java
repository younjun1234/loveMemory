package com.yj.loveMemory.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Couple {
	private int coupleNo;
	private Date dateDate;
	private String mbId1;
	private String mbId2;
	
}
