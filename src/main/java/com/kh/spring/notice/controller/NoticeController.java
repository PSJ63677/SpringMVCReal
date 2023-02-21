package com.kh.spring.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.notice.domain.Notice;
import com.kh.spring.notice.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService nService;
	
	// 공지사항 등록 화면
	@RequestMapping(value="/notice/writeView.kh", method=RequestMethod.GET)
	public String WriteView() {
		return "notice/write";
	}
	
	// 공지사항 등록
	@RequestMapping(value="/notice/write.kh", method=RequestMethod.POST)
	public String noticeRegister(
			@ModelAttribute Notice notice
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			, HttpServletRequest request
			, Model model) {
		try {
			// 파일이 있을 경우
			if(!uploadFile.getOriginalFilename().equals("")) {
				// 파일복사(지정한 경로에 업로드)
				String filePath = saveFile(uploadFile, request);
				if(filePath != null) {
					notice.setNoticeFilename(uploadFile.getOriginalFilename());
					notice.setNoticeFilepath(filePath);
				}
			}
			int result = nService.insertNotice(notice);
			if(result > 0) {
				return "redirect:/notice/list.kh";
			} else {
				model.addAttribute("msg", "공지사항 등록이 완료되지 않았습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	// 지정 경로로 파일 업로드(파일 복사)
	private String saveFile(MultipartFile uploadFile, HttpServletRequest request) {
		// 내가 원하는 경로 : 프로젝트 경로
		try {
			String root = request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "\\nuploadFiles";
			// 폴더가 없을 경우 자동 생성
			File folder = new File(savePath);
			if(!folder.exists()) {
				folder.mkdir();
			}
			// 실제 파일저장
			String filePath = savePath + "\\" + uploadFile.getOriginalFilename();
			File file = new File(filePath);
			uploadFile.transferTo(file);
			return filePath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 공지사항 목록
	@RequestMapping(value="/notice/list.kh", method=RequestMethod.GET)
	public String noticeListView(Model model) {
		List<Notice> nList = nService.selectNoticeList();
		model.addAttribute("nList", nList);
		return "notice/list";
	}
	
	// 공지사항 상세
	@RequestMapping(value="/notice/detail.kh", method=RequestMethod.GET)
	public String noticeDetailView(@RequestParam("noticeNo") int noticeNo, Model model) {
		try {
			Notice notice = nService.selectOneById(noticeNo);
			model.addAttribute("notice", notice);
			return "notice/detail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}	
	
	@RequestMapping(value="/notice/remove.kh", method=RequestMethod.GET)
	public String noticeRemove(@RequestParam("noticeNo") int noticeNo, Model model) {
		try {
			int result = nService.deleteNotice(noticeNo);
			if(result > 0) {
				return "redirect:/notice/list.kh";
			} else {
				model.addAttribute("msg", "삭제가 완료되지 않았습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
}
