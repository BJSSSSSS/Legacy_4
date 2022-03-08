package com.byeon.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.byeon.s1.board.BoardDTO;
import com.byeon.s1.board.notice.NoticeDTO;
import com.byeon.s1.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String board(){
		return "qna";
	}
	
	//reply form 이동
//	뭐든 상관없다 boardDTO나 qnaDTO나
	@RequestMapping(value="reply", method = RequestMethod.GET)
	public ModelAndView reply(QnaDTO qnaDTO, ModelAndView mv) throws Exception{
		mv.addObject("dto", qnaDTO);//부모 글번호
		mv.setViewName("board/reply");
		return mv;
	}
	
	//reply DB
	@RequestMapping(value="reply", method = RequestMethod.POST)
	public ModelAndView reply(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.reply(qnaDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	
	
	
	
	//list
	@RequestMapping(value ="list", method = RequestMethod.GET)
	public String list(Pager pager, Model model) throws Exception{
		
		List<BoardDTO> ar = qnaService.list(pager);
		model.addAttribute("list", ar);
		
		return "board/list";
	}
	
	
	//detail
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String detail(QnaDTO qnaDTO, Model model) throws Exception{
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/detail";
		
	}
	
	//add form 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception{
		return "board/add";
	}
	
	//add에서 insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(QnaDTO qnaDTO) throws Exception{
		int result = qnaService.add(qnaDTO);
		return "redirect:./list";
	}
	
	//delete
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(QnaDTO qnaDTO) throws Exception{
		int result = qnaService.delete(qnaDTO);
		return "redirect:./list"; 
	}
	
	//update form 이동
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(QnaDTO qnaDTO, Model model) throws Exception{
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/update";
	}
	
	//update
	@RequestMapping(value ="update", method = RequestMethod.POST)
	public ModelAndView update(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.update(qnaDTO);
		mv.setViewName("redirect:./list");
		return mv; 
	}
	
	
	
	
	
	
	
}
