package com.pk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pk.model.OrderMethodType;

public class OrderMethodTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
		                             	Workbook workbook, 
		                             	HttpServletRequest request,
		                             	HttpServletResponse response) throws Exception {
		
		//file name
				response.addHeader("Content-Disposition", "attachment;filename=orderMethod.xlsx");
		        Sheet s=workbook.createSheet("OrderMethod types");
		        //construct row-0
		        setHeader(s);
		        //read model data
		        List<OrderMethodType> list=(List<OrderMethodType>) model.get("list");
		        setBody(s,list);
			}

			private void setHeader(Sheet s) {
				Row r=s.createRow(0); 
				r.createCell(0).setCellValue("ID");
				r.createCell(1).setCellValue("MODE");
				r.createCell(2).setCellValue("CODE");
				r.createCell(3).setCellValue("TYPE");
				r.createCell(4).setCellValue("ACCEPT");
				r.createCell(5).setCellValue("NOTE");
			}
			
		    private void setBody(Sheet s, List<OrderMethodType> list) {
				int count=1;
				for(OrderMethodType omt:list) {
					Row r=s.createRow(count++);
					r.createCell(0).setCellValue(omt.getId());
					r.createCell(1).setCellValue(omt.getOrderMode());
					r.createCell(2).setCellValue(omt.getOrderCode());
					r.createCell(3).setCellValue(omt.getOrderType());
					r.createCell(4).setCellValue(omt.getOrderAcpt().toString());
					r.createCell(5).setCellValue(omt.getOrderDesc());
				}
				

	}

}
