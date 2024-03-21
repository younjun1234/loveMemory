package com.yj.loveMemory.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yj.loveMemory.member.model.service.MemberService;
import com.yj.loveMemory.member.model.vo.Member;

@Controller
@SessionAttributes("loginUser")
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	@GetMapping("/loginView")
	public String loginView() {
		return "login";
	}
	
	@PostMapping("/logIn")
	public String login(@ModelAttribute Member m, Model model) {
		System.out.println(m);
		Member loginUser = mService.login(m);
		System.out.println(loginUser);
		model.addAttribute("loginUser", loginUser);
		return "redirect:/";
	}

}
