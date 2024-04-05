package com.yj.loveMemory.calendar.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.loveMemory.calendar.model.dao.CalendarDAO;
import com.yj.loveMemory.calendar.model.vo.Event;
import com.yj.loveMemory.member.model.vo.Couple;

@Service
public class CalendarServiceImpl implements CalendarService{

	@Autowired
	private CalendarDAO cDAO; 
	
	@Override
	public int addEvent(Event e) {
		if(e.getAllDay().equals("on")) {
			e.setAllDay("Y");
		} else {
			e.setAllDay("N");
		}
		return cDAO.addEvent(e);
	}

	@Override
	public ArrayList<Event> getEvents(Couple couple) {
		return cDAO.getEvents(couple);
	}

}
