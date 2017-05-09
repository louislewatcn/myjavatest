package com.ml0.interfacetest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class NetWorkDemo {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub	
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//HttpGet httpget = new HttpGet("http://localhost:8081/yourAPI");
		//HttpGet httpget = new HttpGet("https://www.baidu.com");
		HttpGet httpget = new HttpGet("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=13478800355");
		CloseableHttpResponse response=null;
		response = httpclient.execute(httpget);
		System.out.println(response.getStatusLine());
		response.close();

	}

}
