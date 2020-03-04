package com.pk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pk.model.Sale;

public class SaleExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		//file name
		response.addHeader("Content-Disposition", "attachment;filename=Sale.xlsx");
        Sheet s=workbook.createSheet("Sale");
        //construct row-0
        setHeader(s);
        //read model data
        List<Sale> list=(List<Sale>) model.get("list");
        setBody(s,list);
	}

	private void setHeader(Sheet s) {
		Row r=s.createRow(0); 
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("ORDER-CODE");
		r.createCell(2).setCellValue("SHIPMNT-CODE");
		r.createCell(3).setCellValue("CUSTOMER");
		r.createCell(4).setCellValue("REF-NUMBER");
		r.createCell(5).setCellValue("STOKE-MODE");
		r.createCell(6).setCellValue("STOKE-SOURCE");
		r.createCell(7).setCellValue("DEFAULT-STATUS");
		r.createCell(10).setCellValue("DESCRIPTION");
	}
	
    private void setBody(Sheet s, List<Sale> list) {
		int count=1;
		for(Sale pt:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(pt.getSaleId());
			r.createCell(1).setCellValue(pt.getOrderCode());
			r.createCell(2).setCellValue(pt.getShipCode());
			r.createCell(3).setCellValue(pt.getCustomer());
			r.createCell(4).setCellValue(pt.getRefNumber());
			r.createCell(5).setCellValue(pt.getStokeMode());
			r.createCell(6).setCellValue(pt.getStokeSource());
			r.createCell(7).setCellValue(pt.getDfltStatus());
			r.createCell(8).setCellValue(pt.getSaleDesc());
		}
	}

}
