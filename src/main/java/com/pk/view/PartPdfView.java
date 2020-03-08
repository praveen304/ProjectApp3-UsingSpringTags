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
import com.pk.model.Part;

public class PartPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 //download files
		response.addHeader("Content-Disposition", "attachment;filename=part.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome to part");
		//add element to document
		document.add(p);
		//read data from model
		List<Part> list=(List<Part>) model.get("list");
		//create table from no of columns
		PdfPTable t=new PdfPTable(10);
		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("WIDTH");
		t.addCell("LENGTH");
		t.addCell("HEIGHT");
		t.addCell("COST");
		t.addCell("CURRENCY");
		t.addCell("UOM");
		t.addCell("SALE");
		t.addCell("PURCHASE");
		t.addCell("NOTE");
		
		//add data to table
		for(Part pt:list) {
			t.addCell(pt.getPartId().toString());
			t.addCell(pt.getPartCode());
			t.addCell(pt.getPartWidth().toString());
			t.addCell(pt.getPartlength().toString());
			t.addCell(pt.getPartHeight().toString());
			t.addCell(pt.getPartBaseCost().toString());
			t.addCell(pt.getBaseCurrency().toString());
			t.addCell(pt.getUomOb().toString());
			t.addCell(pt.getOmSaleOb().toString());
			t.addCell(pt.getOmPurchaseOb().toString());
			t.addCell(pt.getPartDesc());
			
		}
		//add table to document
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));

	}

}
