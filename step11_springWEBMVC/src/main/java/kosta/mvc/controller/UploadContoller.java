package kosta.mvc.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.domain.FileDTO;

@Controller
public class UploadContoller {
	/**
	 * 매개변수로 MultipartFile을 주립 받으려면..
	 * xml문서에 CommonsMultipartResolver 설정이 필요하다
	 * @param name
	 * @param file
	 * @return
	 */
	@RequestMapping("/upload.do")
	public ModelAndView aa(String name, MultipartFile file, HttpSession session) {
		String path= session.getServletContext().getRealPath("/WEB-INF/save");
		//저장할 파일 이름
		String fileName = file.getOriginalFilename();
		
		//업로드하기
		try {
			file.transferTo(new File(path + "/" + fileName));
		}catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("uploadResult");
		mv.addObject("name", name);
		mv.addObject("fileName", fileName);
		mv.addObject("fileSize", file.getSize());
		mv.addObject("path", path);
		return mv;
	}
	
	@PostMapping("/upload2.do")
	public String bb(FileDTO dto, HttpSession session) {
		MultipartFile file = dto.getFile();
		String path = session.getServletContext().getRealPath("/WEB-INF/save");
		String fileName = file.getOriginalFilename();
		dto.setFileName(fileName);
		dto.setFileSize(file.getSize());
		dto.setPath(path);
		session.setAttribute("dto", dto);
		try {
			file.transferTo(new File(dto.getPath() + "/" + dto.getFileName()));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "uploadResult";
	}
	
	/**
	 * 다운로드 목록 가져오기
	 */
	@RequestMapping("downList.do")
	public ModelAndView cc(HttpSession session) {
		//save폴더 안에는 모든 목록(파일이름)을 가져온다.
		String path = session.getServletContext().getRealPath("/WEB-INF/save");
		String[] list = null;
		File file = new File(path);
		if(file.exists()) {
			list = file.list();
		}
		return new ModelAndView("downList","fileNames",list);
	}
	
	/**
	 * 다운로드 하기
	 */
	@RequestMapping("down.do")
	public ModelAndView dd(String fname, HttpSession session) {
		String path = session.getServletContext().getRealPath("/WEB-INF/save");
		ModelAndView mv = new ModelAndView();
		mv.addObject("fname", new File(path + "/" + fname));
		mv.setViewName("downLoadView");
		return mv;
	}
}
