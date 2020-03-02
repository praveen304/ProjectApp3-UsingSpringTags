package com.pk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pk.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			                               Workbook workbook, 
			                               HttpServletRequest request,
			                               HttpServletResponse response) throws Exception {
		
		//file name
				response.addHeader("Content-Disposition", "attachment;filename=whUser.xlsx");
		        Sheet s=workbook.createSheet("WhUser types");
		        //construct row-0
		        setHeader(s);
		        //read model data
		        List<WhUserType> list=(List<WhUserType>) model.get("list");
		        setBody(s,list);
			}

			private void setHeader(Sheet s) {
				Row r=s.createRow(0); 
				r.createCell(0).setCellValue("ID");
				r.createCell(1).setCellValue("TYPE");
				r.createCell(2).setCellValue("CODE");
				r.createCell(3).setCellValue("USER-FOR");
				r.createCell(4).setCellValue("MAIL");
				r.createCell(5).setCellValue("CONTACT");
				r.createCell(6).setCellValue("ID-TYPE");
				r.createCell(7).setCellValue("IF-OTHER");
				r.createCell(8).setCellValue("ID_NUMBER");
			}
			
		    private void setBody(Sheet s, List<WhUserType> list) {
				int count=1;
				for(WhUserType st:list) {
					Row r=s.createRow(count++);
					r.createCell(0).setCellValue(st.getUserId());
					r.createCell(1).setCellValue(st.getUserType());
					r.createCell(2).setCellValue(st.getUserCode());
					r.createCell(3).setCellValue(st.getUserFor());
					r.createCell(4).setCellValue(st.getMail());
					r.createCell(5).setCellValue(st.getContact());
					r.createCell(5).setCellValue(st.getUserIdType());
					r.createCell(5).setCellValue(st.getIfOther());
					r.createCell(5).setCellValue(st.getIdNumber());
				}

	}

}
