package com.ml0.projectlib;

import com.ml0.autoframe.lib.DataStore;





public class BussinessLib extends WebdriverLibExtension{
	
	//删除Log目录中的文件，为了满足report打包发送功能
	


	public void login() {

		try {
			super.newClick(ObjectStore.Login_LoginEntry);
			super.newClick(ObjectStore.Login_LoginFreeLink);
			//super.swithchToWindow(ObjectStore.Login_LoginTab_Windowname);
			super.newType(ObjectStore.Login_LoginTab_Username,
					DataStore.D_Username);
			super.newType(ObjectStore.Login_LoginTab_Password,
					DataStore.D_Password);
			super.newClick(ObjectStore.Login_LoginTab_LoginButton);
		
		}

		catch (Exception ex) {
//			System.out.println(TextStore.T_Login + TextStore.T_Fail);
//			HTMLReport.logWriter(TextStore.T_Exception + TextStore.T_Login, "",
//					"", "Fail");
			ex.printStackTrace();
		}
	}
	
	// 登录，需要登录的用户名和密码
		public void login(String p_name,String p_password) {
				
			try {
				super.newClick(ObjectStore.Login_LoginLink);
				super.newClick(ObjectStore.Login_LoginFreeLink);
				//super.swithchToWindow(ObjectStore.Login_LoginTab_Windowname);
				super.newType(ObjectStore.Login_LoginTab_Username,
						p_name);
				super.newType(ObjectStore.Login_LoginTab_Password,
						p_password);
				super.newClick(ObjectStore.Login_LoginTab_LoginButton);
					

			}

			catch (Exception ex) {
				
//				HTMLReport.logWriter(TextStore.T_Exception + TextStore.T_Login, "",
//						"", "Fail");
				ex.printStackTrace();

			}
		}
	
	// 退出，不需要参数
	public void logout() {

	

	}
	
	public void createTask(String p_taskname,String p_assignto){
		
	}

	
	
	

			
	
}

