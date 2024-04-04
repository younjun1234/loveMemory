package com.yj.loveMemory.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yj.loveMemory.diary.model.service.DiaryService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DiaryController {
	
	@Autowired
	private DiaryService dService;
	
	@GetMapping("/diary")
	public String diaryView(HttpSession session) {
		
		return "diary";
	}
	
}
