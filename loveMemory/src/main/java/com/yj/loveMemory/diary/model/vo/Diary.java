package com.yj.loveMemory.diary.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Diary {
	private int diaryNo;
	private String diaryTitle;
	private Date diaryDate;
	private String diaryContent;
	private String mbId;
}
