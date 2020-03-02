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

import com.pk.model.OrderMethodType;
import com.pk.service.OrderMethodTypeService;
import com.pk.util.OrderMethodTypeUtil;
import com.pk.view.OrderMethodTypeExcelView;
import com.pk.view.OrderMethodTypePdfView;


@Controller
@RequestMapping("/order")
public class OrderMethodTypeController {
	@Autowired
	private OrderMethodTypeService service;
	
	@Autowired
	private ServletContext context;

	@Autowired
	private OrderMethodTypeUtil util;

	@GetMapping("/register") // GET
	public String ShowWhPage(Model model) {
		// form backing object
		model.addAttribute("OrderMethodType", new OrderMethodType());
		return "OrderMethodTypeRegister";
	}

	@PostMapping(value = "/save")
	public String saveWhUser(@ModelAttribute OrderMethodType OrderMethodType, Model model) {
		int id = 0;
		String msg = null;
		// using service
		id = service.saveOrderMethodType(OrderMethodType);
		// read msg
		msg = "WhUser type'" + id + "'saved";
		// save data in model attribute
		model.addAttribute("msg", msg);
		// form backing object
		model.addAttribute("OrderMethodType", new OrderMethodType());
		return "OrderMethodTypeRegister";

	}

	@GetMapping("/all")
	public String getAllOrderMethodTypes(Model model) {
		List<OrderMethodType> list = null;

		// use service
		list = service.getAllOrderMethodTypes();
		// set attributes
		model.addAttribute("list", list);
		System.out.println(list);
		return "OrderMethodTypeData";

	}

	@RequestMapping("/delete") // GET
	public String deleteOrderMethodType(@RequestParam("oid") Integer id, Model model) {
		String msg = null;
		List<OrderMethodType> list = null;

		// USE SERVICE
		service.deleteOrderMethodType(id);
		// read msg
		msg = "OrderMethod Type '" + id + "' Deleted";
		// add model Attributes
		model.addAttribute("msg", msg);

		// fetch new data
		// use service
		list = service.getAllOrderMethodTypes();
		// set attributes
		model.addAttribute("list", list);
		return "OrderMethodTypeData";

	}
	
	@GetMapping("/edit")
	public String ShowEditPage(@RequestParam("oid") Integer id,Model model) {
		
		OrderMethodType omt=service.getOneOrderMethodType(id);
		System.out.println(id);
		model.addAttribute("OrderMethodType", omt);
		return "OrderMethodTypeEdit";
		
	}
	
	@PostMapping("/update")
	public String updateOrderMethodType(@ModelAttribute OrderMethodType orderMethodType, Model model) {
		System.out.println(orderMethodType.toString());
		service.updateOrderMethodType(orderMethodType);
		
		
		String msg="WhUser Type '"+orderMethodType.getId()+"'Updated";
		System.out.println("update"+msg);
		model.addAttribute("msg", msg);
		//fetch all data
		List<OrderMethodType> list=service.getAllOrderMethodTypes();
		model.addAttribute("list", list);
		return "OrderMethodTypeData";
		
	}
	
	@GetMapping("/view")
	public String ShowOneWhUser(@RequestParam("oid")Integer id,Model model) {
		OrderMethodType omt=service.getOneOrderMethodType(id);
		model.addAttribute("ob", omt);
		return "OrderMethodTypeView";
		
	}
	
	@GetMapping("/excel")
	public ModelAndView ShowExcel(@RequestParam(value="id",required = false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodTypeExcelView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<OrderMethodType> list=service.getAllOrderMethodTypes();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			OrderMethodType omt=service.getOneOrderMethodType(id);
			m.addObject("list",Arrays.asList(omt));
		}
		return m;
		
	}
	
	@GetMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="id",required = false)Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new OrderMethodTypePdfView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<OrderMethodType> list=service.getAllOrderMethodTypes();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			OrderMethodType omt=service.getOneOrderMethodType(id);
			m.addObject("list",Arrays.asList(omt));
		}
		return m;
	}
	
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list = service.getOrderMethodModeCount();
		String path = context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "OrderMethodTypeCharts";
	}
}
