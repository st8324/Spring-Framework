package kr.green.spring.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.AccountService;
import kr.green.spring.service.BoardService;
import kr.green.spring.utils.UploadFileUtils;
import kr.green.spring.vo.AccountVo;
import kr.green.spring.vo.BoardVo;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	/* bean에 등록된 Resource 중에서 id가 uploadPath를 가져옴*/
	@Resource
	private String uploadPath;
	@Resource
	private AccountService accountService;
	@RequestMapping(value="/board/list", 
			method=RequestMethod.GET)
	public String boaldListGet(
	    HttpServletRequest request,
	    Model model, 
	    Criteria cri) {
		AccountVo user = accountService.getLoginUser(request);
		
		PageMaker pageMaker 
			= boardService.getPageMaker(cri, 10);
		
		ArrayList list = null;
		list = (ArrayList)boardService.getBoardLists(cri);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("user", user);
		return "board/list";
	}
	
	@RequestMapping(value="/board/register",
			method=RequestMethod.GET)
	public String boardRegisterGet(HttpServletRequest request,
			Model model) {
		HttpSession session = request.getSession();
		AccountVo user = (AccountVo)session.getAttribute("user");
		System.out.println("Contoller : " + user);
		if(user != null)
			model.addAttribute("author",user.getId());
		return "board/register";
	}
	@RequestMapping(value="/board/register",
			method=RequestMethod.POST)
	public String boardRegisterPost(BoardVo boardVo, MultipartFile files) throws Exception {
		if(files.getOriginalFilename() != null
				&& files.getOriginalFilename().length() !=0 ) {
			String filepath = UploadFileUtils.uploadFile(uploadPath, files.getOriginalFilename(),files.getBytes());
			boardVo.setFile(filepath);
		}
		boardService.registerBoard(boardVo);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/detail",
			method=RequestMethod.GET)
	public String boardDetailGet(Model model, Integer num, Criteria cri) {
		if(num == null)
			return "redirect:/board/list";
		BoardVo boardVo = boardService.getBoard(num);
		model.addAttribute("board", boardVo);
		model.addAttribute("cri", cri);
		return "board/detail";
	}
	@RequestMapping(value="/board/delete",
			method=RequestMethod.GET)
	public String boardDeleteGet(int num) {
		boardService.deleteBoard(num);
		return "redirect:/board/list";
	}
	@RequestMapping(value="/board/modify",
			method=RequestMethod.GET)
	public String boardModifyGet(Integer num, Integer page, Model model,String search) {
		//정상 경로로 수정페이지에 접근한게 아니면
		if(num == null) {
			return "redirect:/board/list";
		}
		if(page == null){
			page = 1;
		}
		BoardVo boardVo = boardService.getBoard(num);
		model.addAttribute("board",boardVo);
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		return "board/modify";
	}
	@RequestMapping(value="/board/modify",
			method=RequestMethod.POST)
	public String boardModifyPost(BoardVo boardVo, Model model, 
			MultipartFile files) throws Exception {
		String file;
		BoardVo tmp = boardService.getBoard(boardVo.getNum());
		if(files.getOriginalFilename() != null
				&& files.getOriginalFilename().length() != 0) {
			file = UploadFileUtils.uploadFile(uploadPath, files.getOriginalFilename(), files.getBytes());
			boardVo.setFile(file);
		}else {
			// 이전 첨부파일 경로
			boardVo.setFile(tmp.getFile());
		}
		boardService.updateBoard(boardVo);
		return "redirect:/board/list";
	}
	@ResponseBody
	@RequestMapping("/board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+fileName);
	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
}







