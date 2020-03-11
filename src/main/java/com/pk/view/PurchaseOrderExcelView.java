package com.pk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pk.model.PurchaseOrder;

public class PurchaseOrderExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		//file name
				response.addHeader("Content-Disposition", "attachment;filename=PurchaseOrder.xlsx");
		        Sheet s=workbook.createSheet("PurchaseOrder");
		        //construct row-0
		        setHeader(s);
		        //read model data
		        List<PurchaseOrder> list=(List<PurchaseOrder>) model.get("list");
		        setBody(s,list);
			}

			private void setHeader(Sheet s) {
				Row r=s.createRow(0); 
				r.createCell(0).setCellValue("ID");
				r.createCell(1).setCellValue("OrderCODE");
				r.createCell(2).setCellValue("ShipCODE");
				r.createCell(3).setCellValue("VENDOR");
				r.createCell(4).setCellValue("RefNUMBER");
				r.createCell(5).setCellValue("QUNTATYCHECK");
				r.createCell(6).setCellValue("STATUS");
				r.createCell(7).setCellValue("NOTE");
			}
			
		    private void setBody(Sheet s, List<PurchaseOrder> list) {
				int count=1;
				for(PurchaseOrder po:list) {
					Row r=s.createRow(count++);
					r.createCell(0).setCellValue(po.getPid());
					r.createCell(1).setCellValue(po.getOrderCode());
					r.createCell(2).setCellValue(po.getShipmentOb().getShipCode());
					r.createCell(3).setCellValue(po.getVendorOb().getUserType());
					r.createCell(4).setCellValue(po.getRefNum());
					r.createCell(5).setCellValue(po.getQntyCheck());
					r.createCell(6).setCellValue(po.getDefaultStatus());
					r.createCell(7).setCellValue(po.getDesc());
				}
				
	}

}
