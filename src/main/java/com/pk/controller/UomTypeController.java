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

import com.pk.model.UomType;
import com.pk.service.UomTypeService;
import com.pk.util.UomTypeUtil;
import com.pk.view.UomTypeExcelView;
import com.pk.view.UomTypePdfView;

@Controller
@RequestMapping("/uom")
public class UomTypeController {

	@Autowired
	private UomTypeService service;
	
	@Autowired
	private ServletContext context;

	@Autowired
	private UomTypeUtil util;

	
	@GetMapping("/uomreg" ) //GET
	public String ShowRegPage(Model model) {
		//form backing object
	    model.addAttribute("uomType", new UomType());
		return "UomTypeRegister";
	}
	

	@PostMapping(value="/save")
	public String saveUom(@ModelAttribute UomType uomType, Model model) {
		int id=0;
		String msg=null;
		//using service
		id=service.saveUomType(uomType);
		//read msg
		 msg="Uom type'"+id+"'saved";
		//save data in model attribute
		model.addAttribute("msg",msg);
		//form backing object
	    model.addAttribute("uomType", new UomType());
		return "UomTypeRegister";
				
	}
	
	@GetMapping("/alluom")
	public String getAllUomTypes(Model model) {
		List<UomType> list=null;
		
		//use service
		list=service.getAllUomTypes();
		//set attributes
		model.addAttribute("list",list);
		return "UomTypeData";
		
	}
	
	@RequestMapping("/delete") //GET
	public String deleteUomType(@RequestParam("uid") Integer id,Model model ) {
		String msg=null;
		List<UomType> list=null;
		
		//USE SERVICE
		service.deleteUomType(id);
		//read msg
		msg="Uom Type '"+id+"' Deleted";
		//add model Attributes
		model.addAttribute("msg",msg);
		
		//fetch new data
		//use service
		list=service.getAllUomTypes();
		//set attributes
		model.addAttribute("list",list);
		return "UomTypeData";
		
	}
	
	@GetMapping("/edit")
	public String ShowEditPage(@RequestParam("uid") Integer id,Model model) {
		UomType ut=service.getOneUomType(id);
		System.out.println(id);
		model.addAttribute("UomType", ut);
		return "UomTypeEdit";
		
	}
	
	@PostMapping("/update")
	public String updateUomType(@ModelAttribute UomType uomType, Model model) {
		System.out.println(uomType.toString());
		service.updateUomType(uomType);
		String msg="Uom Type '"+uomType.getUomId()+"'Updated";
		model.addAttribute("msg", msg);
		//fetch all data
		List<UomType> list=service.getAllUomTypes();
		model.addAttribute("list", list);
		return "UomTypeData";
		
	}
	
	@GetMapping("/view")
	public String ShowOneUom(@RequestParam("uid")Integer id,Model model) {
		UomType ut=service.getOneUomType(id);
		model.addAttribute("ob", ut);
		return "UomTypeView";
	}
	
	@GetMapping("/excel")
	public ModelAndView ShowExcel(@RequestParam(value="uid",required = false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new UomTypeExcelView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<UomType> list=service.getAllUomTypes();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			UomType omt=service.getOneUomType(id);
			m.addObject("list",Arrays.asList(omt));
		}
		return m;	
	}
	
	@GetMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="uid",required = false)Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new UomTypePdfView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<UomType> list=service.getAllUomTypes();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			UomType omt=service.getOneUomType(id);
			m.addObject("list",Arrays.asList(omt));
		}
		return m;	
	}
	
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list = service.getUmoTypeAndCount();
		String path = context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "UomTypeCharts";
	}

}
