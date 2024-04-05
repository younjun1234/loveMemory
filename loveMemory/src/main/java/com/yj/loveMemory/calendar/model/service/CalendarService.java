package com.yj.loveMemory.calendar.model.service;

import java.util.ArrayList;

import com.yj.loveMemory.calendar.model.vo.Event;
import com.yj.loveMemory.member.model.vo.Couple;
import com.yj.loveMemory.member.model.vo.Member;

public interface CalendarService {

	int addEvent(Event e);

	ArrayList<Event> getEvents(Couple couple);

}
