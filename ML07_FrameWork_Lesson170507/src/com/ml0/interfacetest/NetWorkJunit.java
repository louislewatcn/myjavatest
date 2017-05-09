package com.ml0.interfacetest;

import static org.junit.Assert.*;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class NetWorkJunit {
	
	CloseableHttpClient httpclient;
	CloseableHttpResponse response;
	HttpGet httpget;
	
	

	@Before
	public void setUp() throws Exception {
		httpclient = HttpClients.createDefault();
	}

	@After
	public void tearDown() throws Exception {
		response.close();
		
	}
	

	@Test
	public void testBaidu() throws ClientProtocolException, IOException {
		httpget = new HttpGet("https://www.baidu.com");
		response = httpclient.execute(httpget);
		//assertThat(response.getStatusLine().toString(), containsString( "200" ));
		assertTrue(response.getStatusLine().toString().contains("200"));
	}
	
	@Test
	public void testJD() throws ClientProtocolException, IOException {
		httpget = new HttpGet("http://www.jd.com");
		response = httpclient.execute(httpget);
		//assertThat(response.getStatusLine().toString(), containsString( "200" ));
		assertTrue(response.getStatusLine().toString().contains("200"));
	}
	
	@Test
	public void testGitHub() throws ClientProtocolException, IOException {
		httpget = new HttpGet("https://api.github.com/users/octocat/orgs");
		response = httpclient.execute(httpget);
		//assertThat(response.getStatusLine().toString(), containsString( "200" ));
		assertTrue(response.getStatusLine().toString().contains("200"));
		//assertTrue(sendRequest("https://api.github.com/users/octocat/orgs").contains("200"));
		
	}
	
	public String sendRequest(String p_request) throws ClientProtocolException, IOException{
		
		httpget = new HttpGet(p_request);
		response = httpclient.execute(httpget);
		return response.getStatusLine().toString();
		
	}
	
}
