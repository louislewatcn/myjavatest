package com.ml0.testcase.websetting;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;

public class WorkDemoLesson {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	ProfilesIni pi = new ProfilesIni();
	FirefoxProfile profile = pi.getProfile("default");  
	driver = new FirefoxDriver(profile);  
    baseUrl = "https://worktile.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testWorkDemoLesson() throws Exception {
	 
	//****　用例1 登陆  　****
	  driver.get(baseUrl + "/");
	  //driver.findElement(By.cssSelector("button.btn.btn-login")).click();
	  //driver.findElement(By.cssSelector("button.btn.btn-login")).click();
	driver.findElement(By.linkText("基础版")).click();
    driver.findElement(By.linkText("登录基础版")).click();
    driver.findElement(By.name("login_name")).clear();
    driver.findElement(By.name("login_name")).sendKeys("ml0tester");
    driver.findElement(By.name("login_password")).clear();
    driver.findElement(By.name("login_password")).sendKeys("123456");
    driver.findElement(By.xpath("//button[@type='button']")).click();
    
    Thread.sleep(5000);
    
     //验证已经登陆成功，依据是能否找到新页面中的元素
    assertEquals(true,isElementPresent(By.xpath("//*[@id='btn_leftmenu_shortcut_create']/i")));
   
 //****　用例２ 创建任务  　****
    
    driver.findElement(By.xpath("//*[@id='btn_leftmenu_shortcut_create']/i")).click();
   
    driver.findElement(By.xpath("(//a[contains(text(),'任务')])[9]")).click();
    driver.findElement(By.name("taskName")).clear();
    driver.findElement(By.name("taskName")).sendKeys("ml0tester七期");
    driver.findElement(By.cssSelector("b")).click();
    driver.findElement(By.xpath("//li[@id='ui-select-choices-row-0-6']/div/div")).click();
    new Select(driver.findElement(By.name("selectEntry"))).selectByVisibleText("在做");
    driver.findElement(By.cssSelector("span.o")).click();
    driver.findElement(By.name("search_user_input")).clear();
    driver.findElement(By.name("search_user_input")).sendKeys("ml");
    driver.findElement(By.linkText("ml0tester(ml0tester)")).click();
    driver.findElement(By.xpath("//html[@id='ng-app']/body/div/div/div/div/div[2]/form/div[4]/button")).click();
    Thread.sleep(5000);
    driver.findElement(By.cssSelector("i.wtfont.wtf-dashboard")).click();
    assertEquals("","");
    
    
    //****　用例3 在我的 tab页中 验证创建任务成功  　****
    Thread.sleep(5000);
    assertEquals(true,isElementPresent(By.xpath("//*[contains(.,'ml0tester七期')]"))); //当前页面是否包含文字'ml0tester七期'
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
