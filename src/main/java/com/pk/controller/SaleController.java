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

import com.pk.model.Sale;
import com.pk.service.SaleService;
import com.pk.view.SaleExcelView;
import com.pk.view.SalePdfView;


@Controller
@RequestMapping("/sale")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping("/register") // GET
	public String ShowSale(Model model) {
		// form backing object
		model.addAttribute("Sale", new Sale());
		return "SaleRegister";
	}

	@PostMapping(value = "/save")
	public String saveSale(@ModelAttribute Sale Sale, Model model) {
		int id = 0;
		String msg = null;
		// using service
		id = service.saveSale(Sale);
		// read msg
		msg = "WhUser type'" + id + "'saved";
		// save data in model attribute
		model.addAttribute("msg", msg);
		// form backing object
		model.addAttribute("Sale", new Sale());
		return "SaleRegister";

	}

	@GetMapping("/all")
	public String getAllSales(Model model) {
		List<Sale> list = null;

		// use service
		list = service.getAllSales();
		// set attributes
		model.addAttribute("list", list);
		System.out.println(list);
		return "SaleData";

	}

	@RequestMapping("/delete") // GET
	public String deleteSale(@RequestParam("pid") Integer id, Model model) {
		String msg = null;
		List<Sale> list = null;

		// USE SERVICE
		service.deleteSale(id);
		// read msg
		msg = "OrderMethod Type '" + id + "' Deleted";
		// add model Attributes
		model.addAttribute("msg", msg);

		// fetch new data
		// use service
		list = service.getAllSales();
		// set attributes
		model.addAttribute("list", list);
		return "SaleData";

	}
	
	@GetMapping("/edit")
	public String ShowEditPage(@RequestParam("pid") Integer id,Model model) {
		
		Sale pt=service.getOneSale(id);
		System.out.println(id);
		model.addAttribute("Sale", pt);
		return "SaleEdit";
		
	}
	
	@PostMapping("/update")
	public String updateSale(@ModelAttribute Sale Sale, Model model) {
		System.out.println(Sale.toString());
		service.updateSale(Sale);
		
		
		String msg="Sale '"+Sale.getSaleId()+"'Updated";
		System.out.println("update"+msg);
		model.addAttribute("msg", msg);
		//fetch all data
		List<Sale> list=service.getAllSales();
		model.addAttribute("list", list);
		return "SaleData";
		
	}
	
	@GetMapping("/view")
	public String ShowOneSale(@RequestParam("pid")Integer id,Model model) {
		Sale pt=service.getOneSale(id);
		model.addAttribute("ob", pt);
		return "SaleView";
		
	}
	
	@GetMapping("/excel")
	public ModelAndView ShowExcel(@RequestParam(value="id",required = false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new SaleExcelView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<Sale> list=service.getAllSales();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			Sale pt=service.getOneSale(id);
			m.addObject("list",Arrays.asList(pt));
		}
		return m;
		
	}
	
	@GetMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="id",required = false)Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new SalePdfView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<Sale> list=service.getAllSales();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			Sale pt=service.getOneSale(id);
			m.addObject("list",Arrays.asList(pt));
		}
		return m;
	}
}
