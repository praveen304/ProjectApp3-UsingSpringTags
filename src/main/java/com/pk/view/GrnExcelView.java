package com.pk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pk.model.Grn;

public class GrnExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//file name
				response.addHeader("Content-Disposition", "attachment;filename=Grn.xlsx");
		        Sheet s=workbook.createSheet("Grn");
		        //construct row-0
		        setHeader(s);
		        //read model data
		        List<Grn> list=(List<Grn>) model.get("list");
		        setBody(s,list);
			}

			private void setHeader(Sheet s) {
				Row r=s.createRow(0); 
				r.createCell(0).setCellValue("ID");
				r.createCell(1).setCellValue("GNE-CODE");
				r.createCell(2).setCellValue("GNE-TYPE");
				r.createCell(3).setCellValue("Order-CODE");
				r.createCell(4).setCellValue("DESCRIPTION");
			}
			
		    private void setBody(Sheet s, List<Grn> list) {
				int count=1;
				for(Grn pt:list) {
					Row r=s.createRow(count++);
					r.createCell(0).setCellValue(pt.getGrnid());
					r.createCell(1).setCellValue(pt.getGrnCode());
					r.createCell(2).setCellValue(pt.getGrnType());
					r.createCell(3).setCellValue(pt.getOrderCode());
					r.createCell(4).setCellValue(pt.getGrnDesc());
				}
			}

}
