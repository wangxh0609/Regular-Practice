package com.hust.downAuto;

import java.io.*;
import java.net.*;
import java.util.*;


public class DownAUTO {
	
	
	public static void main(String[] args) {
		while(true){
			writeLog("开始下载",filePath);
			String postUrl = "http://120.77.53.50:8888/down";
			String paramData = "doc=https://wenku.baidu.com/view/375844ab541810a6f524ccbff121dd36a32dc4c6&kami=abc5588";	
			String result=PostWebRequest(postUrl,paramData);	
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	private static String filePath=String.format("C:\\Users\\ty\\Desktop\\test.log");
	
	public static void writeLog(String logMsg,String filePath){
		File file=new File(filePath);
		try {
			if(!file.exists()){			
				file.createNewFile();			
			}
			  
           // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件   
            FileWriter writer = new FileWriter(filePath, true);   
            writer.write(logMsg);          
            writer.close();   
		        
	      } catch (Exception e) {
	    	  System.out.println(e.getMessage());
         
      }
		
	}
	
	public static void method2(String fileName, String content) {   
        
    }   
	
	public static String PostWebRequest(String postUrl, String paramData)
    {
		String result = "";// 访问返回结果
        BufferedReader read = null;// 读取访问结果
        try
        {        

        	URLConnection conn =new URL(postUrl).openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36");
            //发送POST请求必须设置下面两行
            conn.setDoInput(true);
            conn.setDoOutput(true);
            try (
                //获取URLConnection对象对应的输出流
                PrintWriter out = new PrintWriter(conn.getOutputStream());) {
                out.print(paramData);//发送请求参数(key1=value1&key2=value2)
                out.flush();//flush输出流的缓冲
            } catch (Exception e) {}
            //获取响应头字段        	       
            Map<String, List<String>> map = conn.getHeaderFields();
			// 遍历所有的响应头字段，获取到cookies等
			for (String key : map.keySet()) {
				String str=key + "--->" + map.get(key);
				
				writeLog(str,filePath);
			}
			// 定义 BufferedReader输入流来读取URL的响应
			read = new BufferedReader(new InputStreamReader(conn.getInputStream(), "gb2312"));
			String line;// 循环读取
			while ((line = read.readLine()) != null) {
				result += line;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (read != null) {// 关闭流
				try {
					read.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    	writeLog(result,filePath);
        return result;
    }

}
