package com.ml0.autoframe.lib;


//与外部文件的一个接口
public class DataStore {	
	public static String D_Username="ml0tester";
	public static String D_Username2=CommonLib.readINIFile("./config.ini", "base", "username");
	public static String D_Password="123456";
	public static String D_URL="http://www.worktile.com";
	public static String D_Browser="FireFox";
	public static String D_Browser2=CommonLib.readINIFile("./config.ini", "browser", "useBrowser");
	public static int D_Wait_ShortTime=Integer.parseInt(CommonLib.readINIFile("./config.ini", "waitTime", "shortTime"));
	public static int D_Wait_MediumTime=3;
	public static int D_Wait_LongTime=10;

	



}
