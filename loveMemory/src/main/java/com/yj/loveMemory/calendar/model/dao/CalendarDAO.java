package com.yj.loveMemory.calendar.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.yj.loveMemory.calendar.model.vo.Event;
import com.yj.loveMemory.member.model.vo.Couple;

@Mapper
public interface CalendarDAO {

	int addEvent(Event e);

	ArrayList<Event> getEvents(Couple couple);

	int updateEvent(Event e);

	int deleteEvent(String eventNo);

}
