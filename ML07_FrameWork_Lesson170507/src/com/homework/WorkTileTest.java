package com.homework;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WorkTileTest {
	
	  private AndroidDriver driver;

	    @Before
	    public void setUp() throws Exception {
	        // set up appium
//	        File classpathRoot = new File(System.getProperty("user.dir"));
//	        File appDir = new File(classpathRoot, "apps/ContactManager");
//	        File app = new File(appDir, "ContactManager.apk");
	        
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
	    	//case1    	
	   
	    
	    	//case01  登陆
	    	
	    	login("ml0tester","123456");
	    	assertTrue(driver.findElement(By.id("actionbar_add")).isDisplayed());
	    	
	    	//case02  创建任务
	    	driver.findElement(By.id("actionbar_add")).click();
	       	driver.findElement(By.name("新建任务")).click();
	    	mySleep(3); 

	    	driver.findElement(By.name("任务名称")).click();
	       	driver.findElement(By.name("任务名称")).sendKeys("appium");
	    	driver.findElement(By.name("项目")).click();
	    	driver.scrollTo("ML0七期练习").click();  //滑动选择某个元素
	    	driver.findElement(By.name("任务列表")).click();
	    	driver.findElement(By.name("待定")).click();
	    	driver.findElement(By.name("分配任务")).click();
	    	driver.scrollToExact("ml0tester").click(); //滑动选择某个元素
	    
	    	driver.findElement(By.name("确定")).click(); 
	    	driver.findElement(By.id("btn_finish")).click();	
	    	mySleep(10);
	    	//driver.findElement(By.className("android.widget.ImageButton")).click();	
	    	driver.pressKeyCode(AndroidKeyCode.BACK); //点击back键
	    	//driver.navigate().back();
	    	mySleep(5);
	    	
	    	//assertTrue(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'appium demo')]")).isDisplayed());
	    	assertTrue(driver.findElement(By.name("appium")).isDisplayed()); //验证创建任务是否成功！
	    	
	    	//case03 退出
	    	logout();
	    	assertTrue(driver.findElement(By.id("btn_login")).isDisplayed());
	    	
	    	
	    	
	    	
	    	
	   

	     	
	
	    	
	    	
	    	
	    }
	    
	    public void login(String p_user,String p_password){
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //设置为10 ，不想等待太久 
	   
           try{
        	   driver.findElement(By.name("稍后更新")).isDisplayed();
        	   driver.findElement(By.name("稍后更新")).click();
           }catch(Exception e){
	    	 	  
	    	}

           try{
        	   //*******判断是否登陆成功
        	   driver.findElement(By.id("actionbar_add")).isDisplayed();
        	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        	   return; //表示方法执行完毕
        	   //*******判断是否登陆成功
           }catch(Exception e){
	    	 	  
           }
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	    		driver.findElement(By.name("登录")).click();
		    	driver.findElement(By.id("et_username")).sendKeys(p_user);
		     	driver.findElement(By.id("et_password")).sendKeys(p_password);
		    
		     	driver.findElement(By.id("btn_login")).click();
		       
		       	mySleep(5);	
		       	
		        try{
		        	   driver.findElement(By.name("稍后更新")).isDisplayed();
		        	   driver.findElement(By.name("稍后更新")).click();
		           }catch(Exception e){
			    	 	  
			    	}
		        
		         //加code 对应是否需要评论
		      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);   //设置回60
	    	
	    }
	    
	    public void logout(){
	    	     //确保先回主页，执行back操作
	    	     // if driver.findElement(By.id("actionbar_more"))  else back 操作
	    	
	    		driver.findElement(By.id("actionbar_more")).click();
	    		driver.findElement(By.name("设置")).click();
	    		mySleep(2);	
	    		driver.scrollToExact("退出登录").click();
		    	//driver.findElement(By.name("退出登录")).click();	
	    	
	    }
	    
	    
	    public void mySwipeUP(By by,int p_time){
	    	
	    	int LeftTop_x= driver.findElement(by).getLocation().getX();
	    	int LeftTop_y= driver.findElement(by).getLocation().getY();
	    	int Obj_height= driver.findElement(by).getSize().getHeight();
	    	int Obj_width= driver.findElement(by).getSize().getWidth();
	    	
	    	driver.swipe(LeftTop_x+Obj_width/2,  LeftTop_y+Obj_height, LeftTop_x+Obj_width/2, LeftTop_y, p_time);
		    
	    }
	    
	    
	    public void screenshot(String p_path){
	    	File screen = driver.getScreenshotAs(OutputType.FILE);
			File screenFile = new File(p_path);
			try {
				FileUtils.copyFile(screen, screenFile); //commons-io-2.0.1.jar中的api
			} catch (IOException e) {
				e.printStackTrace();
			} 
	    }
	  
	    
	    private void mySleep(int p_time) {
		    try {
				Thread.sleep(1000*p_time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  }
	    
	    
	    private boolean isTextPresent(String p_word, int p_time) {
			try {		
				driver.manage().timeouts().implicitlyWait(p_time, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[contains(.,'" + p_word + "')]"));	
				return true;

			} catch (Exception e) {

				return false;
			}

		}
	  
	    

	    
	    

}
