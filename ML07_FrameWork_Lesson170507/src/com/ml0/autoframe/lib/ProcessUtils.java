package com.ml0.autoframe.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeoutException;


public class ProcessUtils {
    
   
    public static int executeCommand( String command, long timeout) throws InterruptedException, TimeoutException, IOException {
        Process process = Runtime.getRuntime().exec(command);
        System.out.println("开始执行命令："+command+" ...");
        Worker worker = new Worker(process);
        worker.start();
        try {
        	
            worker.join(timeout);
            if (worker.exit != null){
            	System.out.println("在"+timeout/1000+"秒内完成执行命令："+command+" 成功。");
                return worker.exit;
            } else{
            	//System.out.println("在"+timeout/1000+"秒内执行命令："+command+" 失败。");
                throw new TimeoutException();
            }
        } catch (InterruptedException ex) {
            worker.interrupt();
            Thread.currentThread().interrupt();
            throw ex;
        } finally {
            process.destroy();
        }
    }
     
  
    private static class Worker extends Thread {
        private final Process process;
        private Integer exit;
  
        private Worker(Process process) {
            this.process = process;
        }
  
		public void run() {
            try {
            	//#### 捕获错误信息，防止程序stderr信息输出填满缓冲区，造成阻塞 ####
               InputStream stderr = process.getErrorStream();   
     		   InputStreamReader isr = new InputStreamReader(stderr);  
     		   BufferedReader br = new BufferedReader(isr);    
     		   String line=null;
     		    while ((line = br.readLine()) != null)  {
     		    	// System.out.println(line);  
     		    	 line+=line;
     		    }  
     		    
     		   //#### 捕获错误信息，防止程序stderr信息输出填满缓冲区，造成阻塞 ####
     		   
     		    exit = process.waitFor(); 
	
               
            } catch (Exception e) {
            	e.printStackTrace();
                return;
            }
        }
    }
  
}