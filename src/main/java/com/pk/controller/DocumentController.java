package com.pk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.pk.model.Document;
import com.pk.service.DocumentService;

@Controller
@RequestMapping("/doc")
public class DocumentController {

	@Autowired
	private DocumentService service;
	
	/**
	 * show document upload page
	 */
	@GetMapping("/show")
	public String showUploadPage(Model model) {
		List<Object[]> list=service.getFileIdAndName();
		model.addAttribute("list", list);
		return "Document";
	}
	
	/**
	 * upload data into DB
	 */
	@PostMapping("/upload")
	public String doUpload(@RequestParam ("fileId")Integer fileId,
			             @RequestParam ("fileOb") CommonsMultipartFile fileOb,
			             Model model) {
	
		if(fileOb!=null) {
			Document doc= new Document();
			doc.setFileId(fileId);
			System.out.println(fileId);
			doc.setFileName(fileOb.getOriginalFilename());
			doc.setFileData(fileOb.getBytes());
			//use service
			service.saveDocument(doc);
			//messgae
			String msg=fileId +"is Uploaded";
			model.addAttribute("message",msg);
		}
		return "redirect:show";	
	}
	
	@GetMapping("/download")
	public void doDownload(@RequestParam Integer fid,HttpServletResponse resp) {
		//read one object based on id
		Document doc= service.getOneDocument(fid);
		resp.addHeader("Content-Disposition", "attachment;filename="+doc.getFileName());
		try {
			//copy data to output Stream
			FileCopyUtils.copy(doc.getFileData(), resp.getOutputStream());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
