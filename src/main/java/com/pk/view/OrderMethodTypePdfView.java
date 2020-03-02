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
import com.pk.model.OrderMethodType;

public class OrderMethodTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
			                         Document document,
			                         PdfWriter writer,
			                         HttpServletRequest request, 
			                         HttpServletResponse response) throws Exception {
		
		  //download files
				response.addHeader("Content-Disposition", "attachment;filename=ordermethod.pdf");
				//create element
				Paragraph p=new Paragraph("Welcome to orderMehod Type");
				//add element to document
				document.add(p);
				//read data from model
				List<OrderMethodType> list=(List<OrderMethodType>) model.get("list");
				//create table from no of columns
				PdfPTable t=new PdfPTable(6);
				t.addCell("ID");
				t.addCell("MODE");
				t.addCell("CODE");
				t.addCell("TYPE");
				t.addCell("ACCEPT");
				t.addCell("NOTE");
				
				//add data to table
				for(OrderMethodType omt:list) {
					t.addCell(omt.getId().toString());
					t.addCell(omt.getOrderMode());
					t.addCell(omt.getOrderCode());
					t.addCell(omt.getOrderType());
					t.addCell(omt.getOrderAcpt().toString());
					t.addCell(omt.getOrderDesc());
				}
				//add table to document
				document.add(t);
				//print date and time
				document.add(new Paragraph(new Date().toString()));

	}

}
