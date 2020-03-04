package com.pk.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.pk.model.Sale;

public class SalePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 //download files
		response.addHeader("Content-Disposition", "attachment;filename=Sale.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome to Sale");
		//add element to document
		document.add(p);
		//read data from model
		List<Sale> list=(List<Sale>) model.get("list");
		//create table from no of columns
		PdfPTable t=new PdfPTable(9);
		t.addCell("ID");
		t.addCell("ORDER-CODE");
		t.addCell("SHIPMENT-CODE");
		t.addCell("CUSTOMER");
		t.addCell("Ref-NUMBER");
		t.addCell("STOKE-MODE");
		t.addCell("STOKE-SOURCE");
		t.addCell("DEFAULT-STATUS");
		t.addCell("DESCREPTION");
		
		
		//add data to table
		for(Sale pt:list) {
			t.addCell(pt.getSaleId().toString());
			t.addCell(pt.getOrderCode());
			t.addCell(pt.getShipCode());
			t.addCell(pt.getCustomer());
			t.addCell(pt.getRefNumber());
			t.addCell(pt.getStokeMode());
			t.addCell(pt.getStokeSource());
			t.addCell(pt.getDfltStatus());
			t.addCell(pt.getSaleDesc());
			
		}
		//add table to document
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));

	
	}

}
