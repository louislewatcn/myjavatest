package com.ml0.interfacetest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InterfaceDemo {
	
	Calculator ca=new Calculator();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		assertEquals(2,ca.divide(10, 5));
	}
	
	@Test
	public void test2() {
		assertEquals(0,ca.divide(0, 5));
	}
	
	
	
	@Test
	public void test3() {
		assertEquals(-1,ca.divide(5,0));
	}
	
	
//	@Test
//	public void test4() {
//		assertEquals(0,ca.divide(10, 2.5));
//	}

}
