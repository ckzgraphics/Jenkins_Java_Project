package com.bs.Jenkins_Java_Project;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SampleBrowserStackTest {

	static String USERNAME = "chinmaykaradkar3"; // System.getenv("BROWSERSTACK_USERNAME");
	static String AUTOMATE_KEY = "4p6PFPsWM9acCnnGfCuD"; // System.getenv("BROWSERSTACK_USERNAME");
	static String HUB_URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) {

		WebDriver webDriver = null;
		String AUT_URL = "https://the-internet.herokuapp.com/windows";
		
		URL URLObj = null;
		DesiredCapabilities caps = null;

		try {

			URLObj = new URL(HUB_URL);
			caps = new DesiredCapabilities();
			
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("browser", "Chrome");
//			caps.setCapability("browser_version", "75.0");
			
			caps.setCapability("project", "Test Run");
			caps.setCapability("build", "Support Automate");
			caps.setCapability("name", "Test: Jenkins Sample");			
			
			caps.setCapability("browserstack.selenium_version", "3.14.0");
			caps.setCapability("browserstack.debug", "true");
			
			webDriver = new RemoteWebDriver(URLObj, caps);
			
			webDriver.get(AUT_URL);
			System.out.println(webDriver.getTitle());
			take_screenshot(webDriver);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(webDriver != null){
				webDriver.quit();
			}
		}
	} // MAIN END
	
	public static void take_screenshot(WebDriver webDriver){
		try {
			TakesScreenshot scrShot =((TakesScreenshot)webDriver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//			File DestFile=new File("/Users/test.png");
//			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	} // FUNC END
} // CLASS END
