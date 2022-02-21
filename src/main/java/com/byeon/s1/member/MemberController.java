package com.byeon.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//join form
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception{
	}

	//join insert
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO) throws Exception{
		int result = memberService.join(memberDTO);
		return "redirect:../";
	}
	
	//login form
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login() throws Exception{
	}
	
	//login selectOne
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(MemberDTO memberDTO) throws Exception{
		memberDTO = memberService.login(memberDTO);
//		mv.addObject("login", memberDTO);
//		mv.setViewName("redirect:../");
		String path = "redirect:./login";
		if(memberDTO != null) {
			path = "redirect:../";
		}
		return path;
	}
	
}








