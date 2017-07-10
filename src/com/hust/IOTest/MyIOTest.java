package com.hust.IOTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MyIOTest {
	//字节流   InputStream  OutPutStream
	//字符流 Reader Writer
	public static void main(String[] args){
		//readerwriterTest();
	}
	public static void fileoutinputStreamTest(){
		InputStream input=null;
		OutputStream output=null;
		try {
			input=new FileInputStream("test.xml");
			int i=0;
			int size=0;
			//写入内容
			//output=new FileOutputStream("test2.xml");
			//追加写入
			output=new FileOutputStream("test2.xml",true);
			//一次读取一个字节
//			
//			while((i=input.read())!=-1){
//				System.out.print((char)i+"");
//			}
			//end
			//一次读一个字节数组		
//			byte[] buffer=new byte[2*1024];
//			while((i=input.read(buffer))!=-1){
//				 System.out.print(new String(buffer, 0, i));
//			}
			int offSet=0;
			int sizeL=2*1024;
			byte[] buffer=new byte[2*1024];
			while((i=input.read(buffer, offSet,sizeL))!=-1){
				output.write(buffer, offSet, i);				
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}finally{
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void bufferedoutinputStreamTest(){
		try {
			BufferedInputStream input=new BufferedInputStream(new FileInputStream("test.xml"));//装饰者设计模式设计的
			
			 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test2.xml"));
		       
		     
			 byte[] bs = new byte[20];
	        int len = 0;
	        while ((len = input.read(bs)) != -1) {
	        	bos.write(bs);
	            //System.out.print(new String(bs, 0, len));
	            // hello
	        }
	        // 关闭流
	        input.close();
	        bos.flush();
	        // 关闭流
	        bos.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//字符流测试
	
	public static void readerwriterTest(){
		  try {
			  InputStreamReader reader = new InputStreamReader(new FileInputStream("test.xml"));
			  int len;
	      
				while ((len = reader.read()) != -1) {
				    System.out.print((char) len);//爱生活，爱Android

				}
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        

	         //指定编码 
//	        InputStreamReader reader = new InputStreamReader(new FileInputStream("test.xml"),"utf-8");
//	        int len;
//	        while ((len = reader.read()) != -1) {
//	            System.out.print((char) len);//????????Android
//	        }
//	        reader.close();
	}
	
	public static void bufferedReader(){
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream("test.xml")));
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test2.xml")));
			String str;
			while((str=reader.readLine())!=null){
				writer.write(str);
			}
			writer.close();
			reader.close();
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	
}
