package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead_71;
import com.training.readexcel.ReadExcel;


public class LoginDataProviders_71 {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getMail(); 
			obj[2] = temp.getSubject();
			obj[3] = temp.getMessage();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName = "C:\\Sneha\\Selenium Training\\Project\\TestData.xlsx"; 
		String SheetName="RETC_071_072";
		return new ApachePOIExcelRead_71().getExcelContent(fileName,SheetName); 
	}

	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName = "C:\\Sneha\\Selenium Training\\Project\\TestData.xlsx";
		String SheetName="RETC_074";
		return new ApachePOIExcelRead_71().getExcelContent(fileName,SheetName); 
	}

	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
