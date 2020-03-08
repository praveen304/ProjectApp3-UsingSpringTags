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

import com.pk.model.Uom;
import com.pk.service.UomService;
import com.pk.util.UomUtil;
import com.pk.view.UomExcelView;
import com.pk.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private UomService service;
	
	@Autowired
	private ServletContext context;

	@Autowired
	private UomUtil util;

	
	@GetMapping("/uomreg" ) //GET
	public String ShowRegPage(Model model) {
		//form backing object
	    model.addAttribute("Uom", new Uom());
		return "UomRegister";
	}
	

	@PostMapping(value="/save")
	public String saveUom(@ModelAttribute Uom Uom, Model model) {
		int id=0;
		String msg=null;
		//using service
		id=service.saveUom(Uom);
		//read msg
		 msg="Uom type'"+id+"'saved";
		//save data in model attribute
		model.addAttribute("msg",msg);
		//form backing object
	    model.addAttribute("Uom", new Uom());
		return "UomRegister";
				
	}
	
	@GetMapping("/alluom")
	public String getAllUoms(Model model) {
		List<Uom> list=null;
		
		//use service
		list=service.getAllUoms();
		//set attributes
		model.addAttribute("list",list);
		return "UomData";
		
	}
	
	@RequestMapping("/delete") //GET
	public String deleteUom(@RequestParam("uid") Integer id,Model model ) {
		String msg=null;
		List<Uom> list=null;
		
		//USE SERVICE
		service.deleteUom(id);
		//read msg
		msg="Uom Type '"+id+"' Deleted";
		//add model Attributes
		model.addAttribute("msg",msg);
		
		//fetch new data
		//use service
		list=service.getAllUoms();
		//set attributes
		model.addAttribute("list",list);
		return "UomData";
		
	}
	
	@GetMapping("/edit")
	public String ShowEditPage(@RequestParam("uid") Integer id,Model model) {
		Uom ut=service.getOneUom(id);
		System.out.println(id);
		model.addAttribute("Uom", ut);
		return "UomEdit";
		
	}
	
	@PostMapping("/update")
	public String updateUom(@ModelAttribute Uom Uom, Model model) {
		System.out.println(Uom.toString());
		service.updateUom(Uom);
		String msg="Uom Type '"+Uom.getUomId()+"'Updated";
		model.addAttribute("msg", msg);
		//fetch all data
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list", list);
		return "UomData";
		
	}
	
	@GetMapping("/view")
	public String ShowOneUom(@RequestParam("uid")Integer id,Model model) {
		Uom ut=service.getOneUom(id);
		model.addAttribute("ob", ut);
		return "UomView";
	}
	
	@GetMapping("/excel")
	public ModelAndView ShowExcel(@RequestParam(value="uid",required = false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new UomExcelView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<Uom> list=service.getAllUoms();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			Uom omt=service.getOneUom(id);
			m.addObject("list",Arrays.asList(omt));
		}
		return m;	
	}
	
	@GetMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="uid",required = false)Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new UomPdfView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<Uom> list=service.getAllUoms();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			Uom omt=service.getOneUom(id);
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
		return "UomCharts";
	}

}
