package com.hust.downAuto;

import java.io.*;
import java.net.*;
import java.util.*;


public class DownAUTO {
	
	
	public static void main(String[] args) {
		while(true){
			writeLog("��ʼ����",filePath);
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
			  
           // ��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�   
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
		String result = "";// ���ʷ��ؽ��
        BufferedReader read = null;// ��ȡ���ʽ��
        try
        {        

        	URLConnection conn =new URL(postUrl).openConnection();
            //����ͨ�õ���������
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36");
            //����POST�������������������
            conn.setDoInput(true);
            conn.setDoOutput(true);
            try (
                //��ȡURLConnection�����Ӧ�������
                PrintWriter out = new PrintWriter(conn.getOutputStream());) {
                out.print(paramData);//�����������(key1=value1&key2=value2)
                out.flush();//flush������Ļ���
            } catch (Exception e) {}
            //��ȡ��Ӧͷ�ֶ�        	       
            Map<String, List<String>> map = conn.getHeaderFields();
			// �������е���Ӧͷ�ֶΣ���ȡ��cookies��
			for (String key : map.keySet()) {
				String str=key + "--->" + map.get(key);
				
				writeLog(str,filePath);
			}
			// ���� BufferedReader����������ȡURL����Ӧ
			read = new BufferedReader(new InputStreamReader(conn.getInputStream(), "gb2312"));
			String line;// ѭ����ȡ
			while ((line = read.readLine()) != null) {
				result += line;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (read != null) {// �ر���
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
