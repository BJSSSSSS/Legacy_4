package com.byeon.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	
	//list
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws Exception{
		//ModelAndView
		//매개변수로 선언
		//메서드내에서 객체 생성
		//ModelAndView modelAndView = new ModelAndView();
		List<BankBookDTO> ar = bankBookService.list();
		mv.addObject("list", ar);
		mv.setViewName("bankbook/list");
		
		return mv;
		
	}
	
	//detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(Model model, BankBookDTO bankBookDTO) throws Exception{
		bankBookDTO = bankBookService.detail(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}
	
	//add form 이동
	@RequestMapping(value = "add", method = RequestMethod.GET )
	public void add() throws Exception{
		
	}
	
	//DB에 insert
	@RequestMapping(value = "add", method = RequestMethod.POST )
	public String add(BankBookDTO bankBookDTO) throws Exception{
		int result = bankBookService.add(bankBookDTO);
		//String path = "";
		return "redirect:./list";
	}
	
}

