package com.pk.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.pk.model.WhUserType;
import com.pk.service.WhUserTypeService;
import com.pk.util.WhUserTypeUtil;
import com.pk.view.WhUserTypeExcelView;
import com.pk.view.WhUserTypePdfViwe;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {

	@Autowired
	private WhUserTypeService service;
	
	@Autowired
	private ServletContext context;

	@Autowired
	private WhUserTypeUtil util;

	@GetMapping("/create") // GET
	public String ShowWhPage(Model model) {
		// form backing object
		model.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeRegister";
	}

	@PostMapping(value = "/save")
	public String saveWhUser(@ModelAttribute WhUserType whUserType, Model model) {
		int id = 0;
		String msg = null;
		// using service
		id = service.saveWhUserType(whUserType);
		// read msg
		msg = "WhUser type'" + id + "'saved";
		// save data in model attribute
		model.addAttribute("msg", msg);
		// form backing object
		model.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeRegister";

	}

	@GetMapping("/all")
	public String getAllWhUserTypes(Model model) {
		List<WhUserType> list = null;

		// use service
		list = service.getAllWhUserTypes();
		// set attributes
		model.addAttribute("list", list);
		System.out.println(list);
		return "WhUserTypeData";

	}

	@RequestMapping("/delete") // GET
	public String deleteWhUserType(@RequestParam("whid") Integer id, Model model) {
		String msg = null;
		List<WhUserType> list = null;

		// USE SERVICE
		service.deleteWhUserType(id);
		// read msg
		msg = "WhUser Type '" + id + "' Deleted";
		// add model Attributes
		model.addAttribute("msg", msg);

		// fetch new data
		// use service
		list = service.getAllWhUserTypes();
		// set attributes
		model.addAttribute("list", list);
		return "WhUserTypeData";

	}
	
	@GetMapping("/edit")
	public String ShowEditPage(@RequestParam("whid") Integer id,Model model) {
		
		WhUserType wht=service.getOneWhUserType(id);
		System.out.println(id);
		model.addAttribute("WhUserType", wht);
		return "WhUserTypeEdit";
		
	}
	
	@PostMapping("/update")
	public String updateWhUserType(@ModelAttribute WhUserType whUserType, Model model) {
		System.out.println(whUserType.toString());
		service.updateWhUserType(whUserType);
		
		
		String msg="WhUser Type '"+whUserType.getUserId()+"'Updated";
		System.out.println("update"+msg);
		model.addAttribute("msg", msg);
		//fetch all data
		List<WhUserType> list=service.getAllWhUserTypes();
		model.addAttribute("list", list);
		return "WhUserTypeData";
		
	}
	
	@GetMapping("/view")
	public String ShowOneWhUser(@RequestParam("whid")Integer id,Model model) {
		WhUserType wht=service.getOneWhUserType(id);
		model.addAttribute("ob", wht);
		return "WhUserTypeView";
		
	}
	
	@GetMapping("/excel")
	public ModelAndView ShowExcel(@RequestParam(value="whid",required = false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypeExcelView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<WhUserType> list=service.getAllWhUserTypes();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			WhUserType omt=service.getOneWhUserType(id);
			m.addObject("list",Arrays.asList(omt));
		}
		return m;	
		
	}
	
	@GetMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="whid",required = false)Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new WhUserTypePdfViwe());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<WhUserType> list=service.getAllWhUserTypes();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			WhUserType omt=service.getOneWhUserType(id);
			m.addObject("list",Arrays.asList(omt));
		}
		return m;	
	}
	
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list = service.getWhUserTypeAndCount();
		String path = context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "WhUserTypeCharts";
	}

	
}
