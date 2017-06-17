package com.kmc.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kmc.domain.BoardVO;
import com.kmc.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Inject
	BoardService service;
	
	private static final Logger logger = Logger.getLogger(BoardController.class);
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception
	{
//		model.addAttribute("msg", "success");
		logger.info("regist get............");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception
	{
		//Model은 URI 로 쿼리전송
		//RedirectAttributes 는 숨김데이터
		logger.info("regist post............"); 
		logger.info(board.toString());
		
		service.regist(board);
		
//		model.addAttribute("msg", "success");
		rttr.addFlashAttribute("msg", "success");
		
		//매핑주소
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listGET(Model model) throws Exception
	{
		logger.info("list get............");
		
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void readGET(@RequestParam("bno") int bno, Model model) throws Exception
	{
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception
	{
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception
	{
		service.modify(board);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board/read?bno=" + board.getBno();
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String removePOST(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception
	{
		System.out.println("remove bno : " + bno);
		service.remove(bno);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board/list";
	}
}