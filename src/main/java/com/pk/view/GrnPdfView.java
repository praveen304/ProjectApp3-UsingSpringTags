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
import com.pk.model.Grn;

public class GrnPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 //download files
		response.addHeader("Content-Disposition", "attachment;filename=Grn.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome to Grn");
		//add element to document
		document.add(p);
		//read data from model
		List<Grn> list=(List<Grn>) model.get("list");
		//create table from no of columns
		PdfPTable t=new PdfPTable(5);
		t.addCell("ID");
		t.addCell("GRN-CODE");
		t.addCell("GRN-TYPE");
		t.addCell("ORDER-CODE");
		t.addCell("DESCREPTION");
		
		
		//add data to table
		for(Grn pt:list) {
			t.addCell(pt.getGrnid().toString());
			t.addCell(pt.getGrnCode());
			t.addCell(pt.getGrnType());
			t.addCell(pt.getOrderCode());
			t.addCell(pt.getGrnDesc());
			
		}
		//add table to document
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));

	}

}
