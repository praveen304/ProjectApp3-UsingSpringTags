package com.pk.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pk.model.PurchaseOrder;
import com.pk.service.PurchaseOrderService;
import com.pk.service.ShipmentTypeService;
import com.pk.service.WhUserTypeService;
import com.pk.util.CommonUtil;
import com.pk.view.PurchaseOrderExcelView;
import com.pk.view.PurchaseOrderPdfView;

@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService service;
	
	@Autowired
	private ShipmentTypeService shipService;
	
	@Autowired
	private WhUserTypeService whService;
	
	//it will show Drop downs at UI(Register/Edit)
	private void commonUi(Model model) {
		List<Object[]> shipList=shipService.getShipIdAndShipCode();
		Map<Integer,String> shipMap=CommonUtil.convert(shipList);
		model.addAttribute("shipMap",shipMap);
		
		List<Object[]> whVendorList=whService.getWhUserIdAndUserCode("Vendor");
		Map<Integer,String> whVendorMap=CommonUtil.convert(whVendorList);
		model.addAttribute("whVendorMap",whVendorMap);
	}
		
	@GetMapping("/register") // GET
	public String ShowPurchaseOrder(Model model) {
		PurchaseOrder po=new PurchaseOrder();
		po.setDefaultStatus("OPEN");
		// form backing object
		model.addAttribute("PurchaseOrder",po);
		commonUi(model);
		return "PurchaseOrderRegister";
	}

	@PostMapping(value = "/save")
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder PurchaseOrder, Model model) {
		int id = 0;
		String msg = null;
		// using service
		id = service.savePurchaseOrder(PurchaseOrder);
		// read msg
		msg = "WhUser type'" + id + "'saved";
		// save data in model attribute
		model.addAttribute("msg", msg);
		// form backing object
		model.addAttribute("PurchaseOrder", new PurchaseOrder());
		commonUi(model);
		return "PurchaseOrderRegister";

	}

	@GetMapping("/all")
	public String getAllPurchaseOrders(Model model) {
		List<PurchaseOrder> list = null;

		// use service
		list = service.getAllPurchaseOrders();
		// set attributes
		model.addAttribute("list", list);
		System.out.println(list);
		return "PurchaseOrderData";

	}

	@RequestMapping("/delete") // GET
	public String deletePurchaseOrder(@RequestParam("pid") Integer id, Model model) {
		String msg = null;
		List<PurchaseOrder> list = null;

		// USE SERVICE
		service.deletePurchaseOrder(id);
		// read msg
		msg = "OrderMethod Type '" + id + "' Deleted";
		// add model Attributes
		model.addAttribute("msg", msg);

		// fetch new data
		// use service
		list = service.getAllPurchaseOrders();
		// set attributes
		model.addAttribute("list", list);
		return "PurchaseOrderData";

	}
	
	@GetMapping("/edit")
	public String ShowEditPage(@RequestParam("pid") Integer id,Model model) {
		
		PurchaseOrder pt=service.getOnePurchaseOrder(id);
		System.out.println(id);
		model.addAttribute("PurchaseOrder", pt);
		commonUi(model);
		return "PurchaseOrderEdit";
		
	}
	
	@PostMapping("/update")
	public String updatePurchaseOrder(@ModelAttribute PurchaseOrder PurchaseOrder, Model model) {
		System.out.println(PurchaseOrder.toString());
		service.updatePurchaseOrder(PurchaseOrder);
		
		
		String msg="PurchaseOrder '"+PurchaseOrder.getPid()+"'Updated";
		System.out.println("update"+msg);
		model.addAttribute("msg", msg);
		//fetch all data
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		model.addAttribute("list", list);
		return "PurchaseOrderData";
		
	}
	
	@GetMapping("/view")
	public String ShowOnePurchaseOrder(@RequestParam("pid")Integer id,Model model) {
		PurchaseOrder pt=service.getOnePurchaseOrder(id);
		model.addAttribute("ob", pt);
		return "PurchaseOrderView";
		
	}
	
	@GetMapping("/excel")
	public ModelAndView ShowExcel(@RequestParam(value="id",required = false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new PurchaseOrderExcelView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<PurchaseOrder> list=service.getAllPurchaseOrders();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			PurchaseOrder pt=service.getOnePurchaseOrder(id);
			m.addObject("list",Arrays.asList(pt));
		}
		return m;
		
	}
	
	@GetMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="id",required = false)Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new PurchaseOrderPdfView());
		if(id==null) {
			//export all rows
			//fetch data from DB
			List<PurchaseOrder> list=service.getAllPurchaseOrders();
			m.addObject("list", list);
		}
		else {
			//export one row by id
			PurchaseOrder pt=service.getOnePurchaseOrder(id);
			m.addObject("list",Arrays.asList(pt));
		}
		return m;
	}
}
