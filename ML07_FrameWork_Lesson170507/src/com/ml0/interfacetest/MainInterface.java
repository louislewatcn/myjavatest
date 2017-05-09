package com.ml0.interfacetest;

public class MainInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator ca=new Calculator();
		myEquals(true,ca.divide(10, 2));


	}
	
	
	public static boolean  myEquals(Object a,Object b){
		if (a.equals(b))
			return true;
			else 
				return false;
		
	}

}
