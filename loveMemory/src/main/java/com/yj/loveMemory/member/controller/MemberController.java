package com.yj.loveMemory.member.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.yj.loveMemory.member.model.service.MemberService;
import com.yj.loveMemory.member.model.vo.Member;

import jakarta.servlet.http.HttpSession;

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
		Member loginUser = mService.login(m);
		model.addAttribute("loginUser", loginUser);
		return "redirect:/";
	}
	
	@GetMapping("/signUpView")
	public String signUpView() {
		return "signUp";
	}
	
	@GetMapping("/signOut")
	public String signOut(SessionStatus status, HttpSession session) {
		if(session != null) {
			status.setComplete();
		}
		return "redirect:/";
	}
	
	@PostMapping("/signUp")
	public String signUp(@ModelAttribute Member m, @RequestParam("file") ArrayList<MultipartFile> file) {
		
		MultipartFile upload = file.get(0);
		if(!upload.getOriginalFilename().equals("")) {
			
			String[] fileNames = saveFile(upload);
			if(fileNames[1] != null) {
				m.setProfile(fileNames[1]);
			}
		}
		
		// 예외 처리
		int result = mService.signUp(m);
		
		return "redirect:/";
	}
	
	public String[] saveFile(MultipartFile file) {
		String savePath = null;
		savePath = "/Users/younjun/Desktop/WorkStation/uploadFiles/loveMemory";
		
		File folder = new File(savePath);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		// 2. 저장된 file rename 
		Date time = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		int ranNum = (int)(Math.random()*100000);
		
		String[] fileNames = new String[2];
		String originFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(time) + ranNum + originFileName.substring(originFileName.lastIndexOf("."));
		
		// 3. rename된 파일을 저장소에 저장
		String renamePath = folder + "/" + renameFileName;
		try {
			file.transferTo(new File(renamePath));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		fileNames[0] = originFileName;
		fileNames[1] = renameFileName;
		return fileNames;
	}

}
