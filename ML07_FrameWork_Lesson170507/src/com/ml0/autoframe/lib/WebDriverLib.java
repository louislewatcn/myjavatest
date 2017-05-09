package com.ml0.autoframe.lib;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.exam.report.entry.ReportEntry;



public class WebDriverLib {
	public static Logger logger = Logger.getLogger(WebDriverLib.class.getName());
	private WebDriver driver=null;
	ReportEntry re=new ReportEntry();
	private String browser=DataStore.D_Browser;
	private String baseUrl=DataStore.D_URL;	

		
		
		/**
	     * Constructor that takes in the instrumentation.
	     *
	     * @param instrumentation the {@link Instrumentation} instance
	     *
	     */
	  
	 public void newSetup(String p_Name)
	   
		
	 	{

	  
		 if (browser.equalsIgnoreCase("chrome")) {
				// System.setProperty("webdriver.chrome.driver","D:\\MyWorkplace\\webdriverServer\\chromedriver.exe");
				
				 driver = new ChromeDriver();

		}else if (browser.equalsIgnoreCase("ie")) {

				
					driver = new InternetExplorerDriver();
			
		}else if (browser.equalsIgnoreCase("safari")) {
				// System.setProperty("webdriver.safari.noinstall","C:\\Program Files\\Safari\\Safari.exe");
				Platform current = Platform.getCurrent();
				if (Platform.WINDOWS.is(current))
					driver = new SafariDriver();


		}else{
				   ProfilesIni pi = new ProfilesIni();
				   FirefoxProfile profile = pi.getProfile("default");
				   driver = new FirefoxDriver(profile);

			}
		     
            if (driver!=null)
            {
            	re.crateLog("d:\\Result\\"+p_Name+".html");
            	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    			driver.get(baseUrl);
    			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    			driver.manage().window().maximize();
    			logger.info(TextStore.T_Init + TextStore.T_Pass);
    			//logger.info("初始化成功");
            }
            
			
	 	}
	  
	  public void newTeardown(){
		  
		  logger.info("");	
		  re.closeLog();	 
		  driver.quit();	     
		 
			 

	  }
	    
	    public static By parseObject(String p_object) {
			String newObjecyt = null;

			if (p_object.startsWith(".//") || p_object.startsWith("//")) {
				return By.xpath(p_object);
			} else if (p_object.startsWith("link=") || p_object.startsWith("Link=")) {
				newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
				return By.linkText(newObjecyt);
			} else if (p_object.startsWith("xpath=")) {
				newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
				return By.xpath(newObjecyt);
			} else if (p_object.startsWith("id=")) {
				newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
				return By.id(newObjecyt);
			} else if (p_object.startsWith("css=")) {
				newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
				return By.cssSelector(newObjecyt);
			} else if (p_object.startsWith("class=")) {
				newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
				return By.className(newObjecyt);
			} else if (p_object.startsWith("tagName=")) {
				newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
				return By.tagName(newObjecyt);
			} else if (p_object.startsWith("name=")) {
				newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
				return By.name(newObjecyt);
			} else
				return null;

		}
		
		
		public void newClick(String p_id){
			
			CommonLib.sleep(DataStore.D_Wait_ShortTime);
			
			try {
				driver.findElement(parseObject(p_id)).click();
				logger.info(TextStore.T_ClickObject + p_id + TextStore.T_Pass);

			}

			catch (Exception e) {
				logger.severe(TextStore.T_Exception + "newClick(String p_id)"
						+ TextStore.T_DetailInfo + e.toString());

			}
			
			    
		}
	    
		public void newType(String p_id,String p_text){
			CommonLib.sleep(DataStore.D_Wait_ShortTime);
			
			try {
				driver.findElement(parseObject(p_id)).clear(); // 输入文字前，清除文本框中的文字
				driver.findElement(parseObject(p_id)).sendKeys(p_text);
				logger.info(TextStore.T_Input + p_text + TextStore.T_To + p_id
						+ TextStore.T_Pass);

			} catch (Exception e) {
				logger.severe(TextStore.T_Exception + "newType"
						+ TextStore.T_DetailInfo + e.toString());
			}
		}
			
		
	
	   
	   
	   public void newVerifyEquals(String p_message, Object p_expected,
				Object p_actual) throws Exception {

			if (p_expected.equals(p_actual)) {
			    re.write(p_message, p_expected.toString(), p_actual.toString());//写入html report or debug report
				logger.info("");
			
			} else {

				re.write(p_message, p_expected.toString(), p_actual.toString());//写入html report or debug report
				logger.severe("");
	

				
			}
		}
	   
	   public void newAssertEquals(String p_message, Object p_expected,
				Object p_actual) throws Exception {
	      
			if (p_expected.equals(p_actual)) {
			    re.write(p_message, p_expected.toString(), p_actual.toString());//写入html report or debug report
				logger.info("");
			
			} else {
				re.write(p_message, p_expected.toString(), p_actual.toString());//写入html report or debug report
				re.closeLog();
			    driver.quit();
				logger.severe("");
	

				
			}
		}
	   
	   
	   public void swithchToWindow(String p_windowName){
		   CommonLib.sleep(DataStore.D_Wait_ShortTime);
		   for (String s : driver.getWindowHandles()) {
				driver.switchTo().window(s);
				if (driver.getTitle().equals(p_windowName)) {
					{
						logger.info("切换到窗口：" + p_windowName + TextStore.T_Pass);
						break;
					}
					
				}
		    }
	   }
	   
	   
	   public void newRunScript(String p_script) {
		   
		   CommonLib.sleep(DataStore.D_Wait_ShortTime);

			try {
				((JavascriptExecutor) driver).executeScript(p_script);
				logger.info("执行jS代码：" + p_script + TextStore.T_Pass);

			} catch (Exception e) {
				logger.severe(TextStore.T_Exception
						+ "newRunScript(String p_script)" + TextStore.T_DetailInfo
						+ e.toString());

			}
	   
	   }
	   
}
