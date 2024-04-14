package com.yj.loveMemory.calendar.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yj.loveMemory.calendar.model.service.CalendarService;
import com.yj.loveMemory.calendar.model.vo.Event;
import com.yj.loveMemory.member.model.service.MemberService;
import com.yj.loveMemory.member.model.vo.Couple;
import com.yj.loveMemory.member.model.vo.Member;

import jakarta.servlet.http.HttpSession;

@Controller
public class CalendarController {
	
	@Autowired
	private CalendarService cService;
	
	@Autowired
	private MemberService mService;
	
	@GetMapping("calendar")
	public String goToCalendar(HttpSession session, Model model) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		Couple couple = mService.getCouple(loginUser);
		ArrayList<Event> eList = cService.getEvents(couple);
		model.addAttribute("eList", eList);
		return "calendar";
	}
	
	@PostMapping("addEvent")
	public String addEvent(@RequestParam("eventTitle") String eventTitle, @RequestParam("startDate") String startDate,
						   @RequestParam("startTime") String startTime, @RequestParam("endDate") String endDate,
						   @RequestParam("endTime") String endTime, @RequestParam("repeat") String eventRepeat,
						   @RequestParam("scheduleType") String eventType, @RequestParam("memo") String eventContent,
						   @RequestParam(value="isAllDay", defaultValue="off") String allDay, HttpSession session,
						   @RequestParam("eventNo") int eventNo) {
		Date eventStartDate = null;
		Date eventEndDate = null;
		int result;
        try {
        	SimpleDateFormat dateTimeformatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        	SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        	if(!startTime.equals("")) {
        		eventStartDate = dateTimeformatter.parse(startDate + " " + startTime);
        	} else {
        		eventStartDate = dateformatter.parse(startDate);
        	}
        	if(!endTime.equals("")) {
        		eventEndDate = dateTimeformatter.parse(endDate + " " + endTime);
        	} else {
        		eventEndDate = dateformatter.parse(endDate);
        	}
		} catch (ParseException e) {
			e.printStackTrace();
		}
        Member loginUser = (Member)session.getAttribute("loginUser");
		Couple couple = mService.getCouple(loginUser);
		System.out.println(allDay);
		if(allDay.equals("off")) {
			allDay = "N";
		} else {
			allDay = "Y";
		}
		System.out.println(allDay);
        Event e = new Event(eventNo, eventTitle, eventContent, eventType, loginUser.getMbId(), eventStartDate, eventEndDate, eventRepeat, allDay, couple.getCoupleNo());
        System.out.println(e);
        if(eventNo == 0) {
        	result = cService.addEvent(e);
        } else {
        	result = cService.updateEvent(e);
        }
        	
		
		return "redirect:/calendar";
	}
	
	@GetMapping("deleteEvent")
	public String deleteEvent(@RequestParam("eventNo") String eventNo) {
		int result = cService.deleteEvent(eventNo);
		
		return "redirect:/calendar";
	}
}
