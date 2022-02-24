package com.byeon.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws Exception{
		
		List<NoticeDTO> ar = noticeService.list();
		mv.addObject("list", ar);
		mv.setViewName("notice/list");
		return mv;
		
	}
	
	//detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(ModelAndView mv, NoticeDTO noticeDTO) throws Exception{
		noticeDTO = noticeService.detail(noticeDTO);
		mv.addObject("dto", noticeDTO);
		mv.setViewName("notice/detail");
		return mv;
	}
	
	//add form 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception{	
	}
	
	
	//add에서 insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.add(noticeDTO);
		return "redirect:./list";
	}
	
	
	//delete
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.delete(noticeDTO);
		return "redirect:./list"; 
	}
	
	//update form 이동
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(NoticeDTO noticeDTO, Model model) throws Exception{
		noticeDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}
	
	//DB에 update
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception{
		
		int result = noticeService.update(noticeDTO);
		return "redirect:./list";
	}
	

}







