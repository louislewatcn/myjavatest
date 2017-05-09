package com.ml0.testcase.websetting;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ml0.projectlib.BussinessLib;
import com.ml0.projectlib.ObjectStore;

import junit.framework.TestCase;




public class Case1 {

	M1BussinessLib bl = new M1BussinessLib();

	@Before
	public void setUp() throws Exception {

		bl.newSetup("测试登陆");

	}
   @Test
	public void test() throws Exception {
		
		
        
		    //登陆
		    String myCase1="验证登录";
		    //bl.newVerifyEquals("验证是否可访问主页","0","0");
			bl.login("ml0tester","123456");
			//bl.newClick(ObjectStore.Login_LoginTab_LoginButton);
			bl.newAssertEquals(myCase1,"云医院-我的云医院","云医院-我的云医院");
			//--------------------------------------------------------------------------------------------
			
			 String myCase2="验证登录2";
			    //bl.newVerifyEquals("验证是否可访问主页","0","0");
			    bl.newClick(ObjectStore.Home_ProductLink);
			    bl.newType("", "");
				bl.login("ml0tester","12345678");
				//bl.newClick(ObjectStore.Login_LoginTab_LoginButton);
				bl.newAssertEquals(myCase1,"云医院-我的云医院","云医院-我的云医院");
		        
				//bl.newGetURl("");
				//bl.assert();
			//bl.logout();  
					
		
	};
	@After
	public void tearDown() throws Exception {
		
		bl.newTeardown();
	}

}
