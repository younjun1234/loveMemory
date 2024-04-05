package com.yj.loveMemory.diary.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.loveMemory.diary.model.dao.DiaryDAO;

@Service
public class DiaryServiceImpl implements DiaryService{
	
	@Autowired
	private DiaryDAO dDAO;
	
	
}
