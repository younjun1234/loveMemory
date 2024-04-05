package com.yj.loveMemory.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class TemplateResolverConfig {
	
	@Bean
	public ClassLoaderTemplateResolver memberResolver() {
		ClassLoaderTemplateResolver member = new ClassLoaderTemplateResolver();
		member.setPrefix("templates/views/member/");
		member.setSuffix(".html");
		member.setTemplateMode(TemplateMode.HTML);
		member.setCharacterEncoding("UTF-8");
		member.setOrder(2);
		member.setCacheable(false);
		member.setCheckExistence(true);
		
		return member;
	}
	
	@Bean
	public ClassLoaderTemplateResolver diaryResolver() {
		ClassLoaderTemplateResolver diary = new ClassLoaderTemplateResolver();
		diary.setPrefix("templates/views/diary/");
		diary.setSuffix(".html");
		diary.setTemplateMode(TemplateMode.HTML);
		diary.setCharacterEncoding("UTF-8");
		diary.setOrder(2);
		diary.setCacheable(false);
		diary.setCheckExistence(true);
		
		return diary;
	}
	
	@Bean
	public ClassLoaderTemplateResolver calendarResolver() {
		ClassLoaderTemplateResolver calendar = new ClassLoaderTemplateResolver();
		calendar.setPrefix("templates/views/calendar/");
		calendar.setSuffix(".html");
		calendar.setTemplateMode(TemplateMode.HTML);
		calendar.setCharacterEncoding("UTF-8");
		calendar.setOrder(2);
		calendar.setCacheable(false);
		calendar.setCheckExistence(true);
		
		return calendar;
	}
}
