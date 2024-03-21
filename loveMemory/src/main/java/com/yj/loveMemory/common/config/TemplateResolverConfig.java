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
}
