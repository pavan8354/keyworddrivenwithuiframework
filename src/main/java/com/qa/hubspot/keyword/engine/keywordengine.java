package com.qa.hubspot.keyword.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.keyword.base.base;


public class keywordengine {

	public WebDriver driver;
	public Properties prop;
	public static Workbook book;
	public static Sheet sheet;
	public base basePage;
	//	public KeyWordElementActions keyWordEleActions;
	public WebElement element;


	public final String scenario_path = "C:\\Users\\Dell\\eclipse-workspace\\keyworddatadrivenhubspot\\src\\main\\java\\com\\qa\\hubspot\\keyword\\scenarios\\hubspot_scenarios.xlsx";

	public void startexecution(String sheetname) {
		String locatorValue = null;
		String locatorName = null;
		FileInputStream file = null;
		try {
			file = new FileInputStream(scenario_path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetname);
		int k=0;

		for(int i=0;i<sheet.getLastRowNum();i++) {

			try {
				String locatortype = sheet.getRow(i+1).getCell(k+1).toString().trim();
				String locatorvalue = sheet.getRow(i+1).getCell(k+2).toString().trim();	
				String action = sheet.getRow(i+1).getCell(k+3).toString().trim();
				String value = sheet.getRow(i + 1).getCell(k + 4).toString().trim();

				switch (action) {
				case "open browser":

					basePage = new base();
					basePage = new com.qa.hubspot.keyword.base.base();
					prop = basePage.init_properties();
					if (value.isEmpty() || value.equals("NA")) {
						driver = basePage.init_driver("browser");
					}else {			
						driver = basePage.init_driver(value);		
					}		
					break;

				case "enter url":
					if (value.isEmpty() || value.equals("NA")) {

						driver.get(prop.getProperty("url"));

					}else {
						driver.get(value);
					}
					break;
				case "quit":
					driver.quit();
					break;
				default:
					System.out.println("No Action is defined");
					break;
				}
				switch (locatortype) {
				case "id":
					WebElement element = driver.findElement(By.id(locatorvalue));
					if(action.equalsIgnoreCase("sendkeys")) {

						element.sendKeys(value);
					}else if(action.equalsIgnoreCase("click")) {
						element.click();
					}	
					locatortype = null;
					break;

				case "linkText":

					element = driver.findElement(By.linkText(locatorValue));
					element.click();
					break;

				default:
					break;
				}	

			}catch(Exception e) {
			}
		}

	}}
