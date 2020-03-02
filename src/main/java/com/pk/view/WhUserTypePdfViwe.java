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
import com.pk.model.WhUserType;

public class WhUserTypePdfViwe extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			                          Document document,
			                          PdfWriter writer,
			                          HttpServletRequest request, 
			                          HttpServletResponse response) throws Exception {
		
		
        //download files
		response.addHeader("Content-Disposition", "attachment;filename=whuser.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome to whuser Type");
		//add element to document
		document.add(p);
		//read data from model
		List<WhUserType> list=(List<WhUserType>) model.get("list");
		//create table from no of columns
		PdfPTable t=new PdfPTable(9);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("CODE");
		t.addCell("USER-FOR");
		t.addCell("MAIL");
		t.addCell("CONTACT");
		t.addCell("ID-TYPE");
		t.addCell("OTHER");
		t.addCell("ID-NUMBER");
		
		//add data to table
		for(WhUserType wht:list) {
			t.addCell(wht.getUserId().toString());
			t.addCell(wht.getUserType());
			t.addCell(wht.getUserCode());
			t.addCell(wht.getUserFor());
			t.addCell(wht.getMail());
			t.addCell(wht.getContact().toString());
			t.addCell(wht.getUserIdType());
			t.addCell(wht.getIfOther());
			t.addCell(wht.getIdNumber().toString());
			
		}
		//add table to document
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
		

	}

}
