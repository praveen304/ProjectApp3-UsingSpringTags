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

import com.pk.model.Grn;
import com.pk.service.GrnService;
import com.pk.view.GrnExcelView;
import com.pk.view.GrnPdfView;

@Controller
@RequestMapping("/grn")
public class GrnController {

	@Autowired
	private GrnService service;
	
	@GetMapping("/register") // GET
	public String ShowGrn(Model model) {
		// form backing object
		model.addAttribute("Grn", new Grn());
		return "GrnRegister";
	}

	@PostMapping(value = "/save")
	public String saveGrn(@ModelAttribute Grn Grn, Model model) {
		int id = 0;
		String msg = null;
		// using service
		id = service.saveGrn(Grn);
		// read msg
		msg = "WhUser type'" + id + "'saved";
		// save data in model attribute
		model.addAttribute("msg", msg);
		// form backing object
		model.addAttribute("Grn", new Grn());
		return "GrnRegister";

	}

	@GetMapping("/all")
	public String getAllGrns(Model model) {
		List<Grn> list = null;

		// use service
		list = service.getAllGrns();
		// set attributes
		model.addAttribute("list", list);
		System.out.println(list);
		return "GrnData";

	}

	@RequestMapping("/delete") // GET
	public String deleteGrn(@RequestParam("pid") Integer id, Model model) {
		String msg = null;
		List<Grn> list = null;

		// USE SERVICE
		service.deleteGrn(id);
		// read msg
		msg = "OrderMethod Type '" + id + "' Deleted";
		// add model Attributes
		model.addAttribute("msg", msg);

		// fetch new data
		// use service
		list = service.getAllGrns();
		// set attributes
		model.addAttribute("list", list);
		return "GrnData";

	}
	
	@GetMapping("/edit")
	public String ShowEditPage(@RequestParam("pid") Integer id,Model model) {
		
		Grn pt=service.getOneGrn(id);
		System.out.println(id);
		model.addAttribute("Grn", pt);
		return "GrnEdit";
		
	}
	
	@PostMapping("/update")
	public String updateGrn(@ModelAttribute Grn Grn, Model model) {
		System.out.println(Grn.toString());
		service.updateGrn(Grn);
		
		
		String msg="Grn '"+Grn.getGrnid()+"'Updated";
		System.out.println("update"+msg);
		model.addAttribute("msg", msg);
		//fetch all data
		List<Grn> list=service.getAllGrns();
		model.addAttribute("list", list);
		return "GrnData";
		
	}
	
	@GetMapping("/view")
	public String ShowOneGrn(@RequestParam("pid")Integer id,Model model) {
		Grn pt=service.getOneGrn(id);
		model.addAttribute("ob", pt);
		return "GrnView";
		
	}
	
	@GetMapping("/excel")
	public ModelAndView ShowExcel(@RequestParam(value="id",required = false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new GrnExcelView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<Grn> list=service.getAllGrns();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			Grn pt=service.getOneGrn(id);
			m.addObject("list",Arrays.asList(pt));
		}
		return m;
		
	}
	
	@GetMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="id",required = false)Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new GrnPdfView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<Grn> list=service.getAllGrns();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			Grn pt=service.getOneGrn(id);
			m.addObject("list",Arrays.asList(pt));
		}
		return m;
	}
}
