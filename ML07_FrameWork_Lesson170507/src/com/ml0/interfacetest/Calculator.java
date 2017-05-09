package com.ml0.interfacetest;

public class Calculator {
	//方法 divide 是用来 计算两个 整数相除
	//参数 a 和b 为int 类型，为要做运算的两个整数，被除数为0时返回-1
	//返回值 为  a 除以b的结果,

    public  int divide(int a, int b) {
    	
    	if (a>1000)
    		return -2;
    	
    	if (b!=0)
        return a / b;
    	else 
    	return -1;	
    }
}
