package com.pk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pk.model.Part;

public class PartExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//file name
		response.addHeader("Content-Disposition", "attachment;filename=part.xlsx");
        Sheet s=workbook.createSheet("Part");
        //construct row-0
        setHeader(s);
        //read model data
        List<Part> list=(List<Part>) model.get("list");
        setBody(s,list);
	}

	private void setHeader(Sheet s) {
		Row r=s.createRow(0); 
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("WIDTH");
		r.createCell(3).setCellValue("LENGTH");
		r.createCell(4).setCellValue("HEIGHT");
		r.createCell(5).setCellValue("COST");
		r.createCell(6).setCellValue("CURRENCY");
		r.createCell(7).setCellValue("UOM");
		r.createCell(8).setCellValue("SALE");
		r.createCell(9).setCellValue("PURCHASE");
		r.createCell(10).setCellValue("NOTE");
	}
	
    private void setBody(Sheet s, List<Part> list) {
		int count=1;
		for(Part pt:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(pt.getPartId());
			r.createCell(1).setCellValue(pt.getPartCode());
			r.createCell(2).setCellValue(pt.getPartWidth());
			r.createCell(3).setCellValue(pt.getPartlength());
			r.createCell(4).setCellValue(pt.getPartHeight());
			r.createCell(5).setCellValue(pt.getPartBaseCost());
			r.createCell(6).setCellValue(pt.getBaseCurrency());
			r.createCell(7).setCellValue(pt.getPartUmo());
			r.createCell(8).setCellValue(pt.getPartSale());
			r.createCell(9).setCellValue(pt.getPartPurchase());
			r.createCell(10).setCellValue(pt.getPartDesc());
		}
		

}

}
