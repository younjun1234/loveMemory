package com.yj.loveMemory.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yj.loveMemory.diary.model.service.DiaryService;

@Controller
public class DiaryController {
	
	@Autowired
	private DiaryService dService;
	
	
}
