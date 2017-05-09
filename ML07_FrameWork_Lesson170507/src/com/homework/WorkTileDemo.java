package com.homework;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class WorkTileDemo {
	
	  private AndroidDriver driver;

	    @Before
	    public void setUp() throws Exception {
	        
	    	 DesiredCapabilities capabilities = new DesiredCapabilities();
		        capabilities.setCapability("platformName", "Android");
		        //capabilities.setCapability("deviceName", "192.168.249.101:5555");
		        capabilities.setCapability("deviceName", "192.168.249.101:5555");
		        //capabilities.setCapability("deviceName", "f97f0457d73");
		        //capabilities.setCapability("platformVersion", "4.3");
		        //capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		        capabilities.setCapability("noReset", "true");
		        capabilities.setCapability("unicodeKeyboard","true"); //输入中文
		        capabilities.setCapability("resetKeyboard","true");   //输入中文
		        capabilities.setCapability("appPackage", "com.worktile"); //worktile的包
		        capabilities.setCapability("appActivity", ".ui.external.WelcomeActivity"); //启动的activity  .ui.external.WelcomeActivity
		        try {
					//driver = new AndroidDriver<MobileElement>(new URL("http://192.168.31.225:4723/wd/hub"), capabilities);
					//driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
					driver = new AndroidDriver<MobileElement>(new URL("http://192.168.1.104:4723/wd/hub"), capabilities);
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					driver.quit();
					System.err.println("launch Android driver fail！"+e.toString());
				}
	    }

	    @After
	    public void tearDown() throws Exception {
	        driver.quit();
	    }

	    @Test
	    public void testCase1(){
	    	
	    	
	    	//启动activity
	    	driver.startActivity("com.worktile", "com.worktile.ui.main.PhotoUploadActivity");
	    	//driver.startActivity("com.android.camera", ".Camera");
	    	
	    	mySleep(3);
	    	driver.startActivity("com.worktile", "com.worktile.ui.main.MainActivity");
	    	
	    	/* 
	    	 //调用相机，切换应用
	       	driver.findElement(By.id("actionbar_add")).click();
	       	driver.findElement(By.name("拍照上传")).click();
	       	mySleep(3);

	       	//driver.findElementById("com.android.camera:id/v6_btn_cancel").click();//切换到相机，注意包com.android.camerea
	       	driver.findElement(By.id("v6_shutter_button_internal")).click();
	    	//driver.findElementById( "com.android.camera:id/v6_shutter_button_internal").click();
	     	mySleep(3);
	     	driver.findElementById("com.android.camera:id/v6_btn_done").click();
	     	mySleep(5);
	    	driver.findElement(By.id("com.worktile:id/btn_cancel")).click(); //切换回worktile ，注意包com.worktile
	    	*/
	    	
	    	
	    }
	    
	    
	    public void mySwipeUP(By by,int p_time){
	    	
	    	int LeftTop_x= driver.findElement(by).getLocation().getX();
	    	int LeftTop_y= driver.findElement(by).getLocation().getY();
	    	int Obj_height= driver.findElement(by).getSize().getHeight();
	    	int Obj_width= driver.findElement(by).getSize().getWidth();
	    	
	    	driver.swipe(LeftTop_x+Obj_width/2,  LeftTop_y+Obj_height, LeftTop_x+Obj_width/2, LeftTop_y, p_time);

	
	    }
	    
	    //截屏
	    public void screenshot(String p_path){
	    	File screen = driver.getScreenshotAs(OutputType.FILE);
			File screenFile = new File(p_path);
			try {
				FileUtils.copyFile(screen, screenFile); //commons-io-2.0.1.jar中的api
			} catch (IOException e) {
				e.printStackTrace();
			} 
	    }
	  
	    
	    public void mySleep(int p_time) {
		    try {
				Thread.sleep(1000*p_time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  }
	    
	    //判断文字是否在页面中出现
	    public boolean isTextPresent(String p_word, int p_time) {
			try {		
				driver.manage().timeouts().implicitlyWait(p_time, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[contains(.,'" + p_word + "')]"));	
				return true;

			} catch (Exception e) {

				return false;
			}

		}
	    
	    
	    //滑屏到页面中某个文字处,等价于3.2 jar 中的 scrollto
	    public String scrollToByText(String text) {
	        String uiScrollables =myUiScrollable("new UiSelector().descriptionContains(\"" + text + "\")") +
	        					  myUiScrollable("new UiSelector().textContains(\"" + text + "\")");
	        return uiScrollables;
	       
	      }
	    
	    private String myUiScrollable(String uiSelector) {
	    	//new UiScrollabl是UIautomator中的api
	    	
	        return "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ".instance(0));";
	      }
	    

	    
	


}
