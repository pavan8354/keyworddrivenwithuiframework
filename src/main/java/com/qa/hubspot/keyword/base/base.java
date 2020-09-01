package com.qa.hubspot.keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(String browsername) {
		
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\JAVALEARN\\filewriting\\chromedriver.exe");	
		if(prop.getProperty("headless").equals("yes")) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			
		}else {
				driver = new ChromeDriver();
				
			}
		
	
			
			}
		return driver;
	
	}
	public Properties init_properties() {
		
		prop = new Properties();
		
		try {
			FileInputStream fip = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\keyworddatadrivenhubspot\\src\\main\\java\\com\\qa\\hubsopt\\keyword\\config\\config.properties");
			prop.load(fip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;

		
	}

}
