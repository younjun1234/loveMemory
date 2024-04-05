package com.yj.loveMemory.calendar.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
	private int eventNo;
	private String eventTitle;
	private String eventContent;
	private String eventType;
	private String mbId;
	private Date eventStartDate;
	private Date eventEndDate;
	private String eventRepeat;
	private String allDay;
	private int coupleNo;
}
