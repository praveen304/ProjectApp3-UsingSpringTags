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

import com.pk.model.ShipmentType;
import com.pk.service.ShipmentTypeService;
import com.pk.util.ShipmentTypeUtil;
import com.pk.view.ShipmentTypeExcelView;
import com.pk.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private ShipmentTypeService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private ShipmentTypeUtil util;

	/**
	 * this method is used to display shipment type register page on URL:
	 * /register,GET
	 */

	/*
	 * method format:
	 *    public String<anyMenthodName>(){
	 *    return "pageName";
	 *    }
	 */
	@GetMapping("/register") // GET
	public String ShowRegPage(Model model) {
		// form backing object
		model.addAttribute("shipmentType", new ShipmentType());
		return "shipmentTypeRegister";
	}

	@PostMapping(value = "/save")
	public String saveShipment(@ModelAttribute ShipmentType shipmentType, Model model) {
		int id = 0;
		String msg = null;
		// using service
		id = service.saveShipmentType(shipmentType);
		// read msg
		msg = "Sgipment type'" + id + "'saved";
		// save data in model attribute
		model.addAttribute("msg", msg);
		// form backing object
		model.addAttribute("shipmentType", new ShipmentType());
		return "shipmentTypeRegister";

	}

	@GetMapping("/all")
	public String getAllShipmentTypes(Model model) {
		List<ShipmentType> list = null;

		// use service
		list = service.getAllShipmentTypes();
		// set attributes
		model.addAttribute("list", list);
		return "ShipmentTypeData";

	}

	@RequestMapping("/delete") // GET
	public String deleteShipmetType(@RequestParam("sid") int id, Model model) {
		String msg = null;
		List<ShipmentType> list = null;

		// USE SERVICE
		service.deleteShipmentType(id);
		// read msg
		msg = "Shipment Type '" + id + "' Deleted";
		// add model Attributes
		model.addAttribute("msg", msg);

		// fetch new data
		// use service
		list = service.getAllShipmentTypes();
		// set attributes
		model.addAttribute("list", list);
		return "ShipmentTypeData";

	}

	@GetMapping("/edit")
	public String ShowEditPage(@RequestParam("sid") Integer id, Model model) {
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("shipmentType", st);
		return "ShipmentTypeEdit";

	}

	@PostMapping("/update")
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType, Model model) {
		System.out.println(shipmentType.toString());
		service.updateShipmentType(shipmentType);

		String msg = "Shipment Type '" + shipmentType.getShipId() + "'Updated";
		model.addAttribute("msg", msg);
		// fetch all data
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";

	}

	@GetMapping("/view")
	public String ShowOneShipment(@RequestParam("sid") Integer id, Model model) {
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("ob", st);
		return "ShipmentTypeView";

	}

	@GetMapping("/excel")
	public ModelAndView ShowExcel(@RequestParam(value = "sid", required = false) Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		if (id == null) {
			// export all rows
			// fetch data from DB
			List<ShipmentType> list = service.getAllShipmentTypes();
			m.addObject("list", list);
		} else {
			// export one row by id
			ShipmentType omt = service.getOneShipmentType(id);
			m.addObject("list", Arrays.asList(omt));
		}
		return m;

	}

	@GetMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value = "sid", required = false) Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypePdfView());
		if (id == null) {
			// export all rows
			// fetch data from DB
			List<ShipmentType> list = service.getAllShipmentTypes();
			m.addObject("list", list);
		} else {
			// export one row by id
			ShipmentType st = service.getOneShipmentType(id);
			m.addObject("list", Arrays.asList(st));
		}
		return m;
	}

	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list = service.getShipmentModeCount();
		String path = context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "ShipmentTypeCharts";
	}

}
