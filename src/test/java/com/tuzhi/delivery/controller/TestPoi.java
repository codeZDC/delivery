package com.tuzhi.delivery.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.propertyeditors.URLEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author codeZ
 * @date 2018年3月16日 上午9:04:29
 * 
 */
@Controller
@RequestMapping("poi")
public class TestPoi {

	@RequestMapping("get")
	public void test(HttpServletRequest request , HttpServletResponse response) {
		try {
			String[] title = new String[] { "序号", "名称", "年龄" };
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("zdcSheet");
			HSSFRow row = null;
			HSSFCell cell = null ;
			for (int i = 0; i < title.length; i++) {
				row = sheet.createRow(0);
				cell = row.createCell(0);
				cell.setCellValue(i + 1);
				cell = row.createCell(1);
				cell.setCellValue("郑德超"+i);
				cell = row.createCell(2);
				cell.setCellValue(20+i);
			}
			for (int i = 1; i < 15; i++) {
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue("100"+i);
				cell = row.createCell(1);
				cell.setCellValue("郑德超"+i);
				cell = row.createCell(2);
				cell.setCellValue(20+i);
			}
			
			response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode("学生信息.xls", "UTF-8"));
			ServletOutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			String[] title = new String[] { "序号", "名称", "年龄" };
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("zdcSheet");
			HSSFRow row = null;
			HSSFCell cell = null ;
			for (int i = 0; i < title.length; i++) {
				row = sheet.createRow(0);
				cell = row.createCell(i);
				cell.setCellValue(title[i]);
			}
			for (int i = 1; i < 15; i++) {
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue("100"+i);
				cell = row.createCell(1);
				cell.setCellValue("郑德超"+i);
				cell = row.createCell(2);
				cell.setCellValue(20+i);
			}
			
			workbook.write(new FileOutputStream(new File("E:/excel.xls")));
			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
