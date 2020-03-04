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
import com.pk.model.PurchaseOrder;

public class PurchaseOrderPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		 //download files
		response.addHeader("Content-Disposition", "attachment;filename=PurchaseOrder.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome to PurchaseOrder");
		//add element to document
		document.add(p);
		//read data from model
		List<PurchaseOrder> list=(List<PurchaseOrder>) model.get("list");
		//create table from no of columns
		PdfPTable t=new PdfPTable(8);
		t.addCell("ID");
		t.addCell("ORDER-CODE");
		t.addCell("SGIPMENT-CODE");
		t.addCell("VENDOR");
		t.addCell("RefNUMBER");
		t.addCell("QUNTATYCHECK");
		t.addCell("STATUS");
		t.addCell("NOTE");
		
		//add data to table
		for(PurchaseOrder po:list) {
			t.addCell(po.getPid().toString());
			t.addCell(po.getOrderCode());
			t.addCell(po.getShipCode());
			t.addCell(po.getVendor());
			t.addCell(po.getRefNum());
			t.addCell(po.getQntyCheck());
			t.addCell(po.getDefaultStatus());
			t.addCell(po.getDesc());
			
		}
		//add table to document
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));

	}
	

}
