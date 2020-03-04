package com.pk.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pk.model.Part;
import com.pk.service.PartService;
import com.pk.view.PartExcelView;
import com.pk.view.PartPdfView;

@Controller
@RequestMapping("/part")
public class PartController {

	@Autowired
	private PartService service;
	
	@GetMapping("/register") // GET
	public String ShowPart(Model model) {
		// form backing object
		model.addAttribute("Part", new Part());
		return "PartRegister";
	}

	@PostMapping(value = "/save")
	public String savePart(@ModelAttribute Part Part, Model model) {
		int id = 0;
		String msg = null;
		// using service
		id = service.savePart(Part);
		// read msg
		msg = "WhUser type'" + id + "'saved";
		// save data in model attribute
		model.addAttribute("msg", msg);
		// form backing object
		model.addAttribute("Part", new Part());
		return "PartRegister";

	}

	@GetMapping("/all")
	public String getAllParts(Model model) {
		List<Part> list = null;

		// use service
		list = service.getAllParts();
		// set attributes
		model.addAttribute("list", list);
		System.out.println(list);
		return "PartData";

	}

	@RequestMapping("/delete") // GET
	public String deletePart(@RequestParam("pid") Integer id, Model model) {
		String msg = null;
		List<Part> list = null;

		// USE SERVICE
		service.deletePart(id);
		// read msg
		msg = "OrderMethod Type '" + id + "' Deleted";
		// add model Attributes
		model.addAttribute("msg", msg);

		// fetch new data
		// use service
		list = service.getAllParts();
		// set attributes
		model.addAttribute("list", list);
		return "PartData";

	}
	
	@GetMapping("/edit")
	public String ShowEditPage(@RequestParam("pid") Integer id,Model model) {
		
		Part pt=service.getOnePart(id);
		System.out.println(id);
		model.addAttribute("Part", pt);
		return "PartEdit";
		
	}
	
	@PostMapping("/update")
	public String updatePart(@ModelAttribute Part Part, Model model) {
		System.out.println(Part.toString());
		service.updatePart(Part);
		
		
		String msg="Part '"+Part.getPartId()+"'Updated";
		System.out.println("update"+msg);
		model.addAttribute("msg", msg);
		//fetch all data
		List<Part> list=service.getAllParts();
		model.addAttribute("list", list);
		return "PartData";
		
	}
	
	@GetMapping("/view")
	public String ShowOnePArt(@RequestParam("pid")Integer id,Model model) {
		Part pt=service.getOnePart(id);
		model.addAttribute("ob", pt);
		return "PartView";
		
	}
	
	@GetMapping("/excel")
	public ModelAndView ShowExcel(@RequestParam(value="id",required = false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new PartExcelView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<Part> list=service.getAllParts();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			Part pt=service.getOnePart(id);
			m.addObject("list",Arrays.asList(pt));
		}
		return m;
		
	}
	
	@GetMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="id",required = false)Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new PartPdfView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<Part> list=service.getAllParts();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			Part pt=service.getOnePart(id);
			m.addObject("list",Arrays.asList(pt));
		}
		return m;
	}
}
