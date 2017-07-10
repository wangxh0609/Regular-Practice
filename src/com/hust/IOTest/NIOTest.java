package com.hust.IOTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

public class NIOTest {

	public static void main(String[] args) {
		nioTest();

	}
	
	public static void nioTest(){
		try {
			RandomAccessFile aFile = new RandomAccessFile("test.xml", "rw");
			FileChannel inchannel=aFile.getChannel();//Channel
			ByteBuffer buf=ByteBuffer.allocate(48);
			int bytesRead=inchannel.read(buf);//��bufд����   buf.put(127); 
			while(bytesRead!=-1){
				System.out.println("Read " + bytesRead);  
				buf.flip(); //flip()���� 

					//flip������Buffer��дģʽ�л�����ģʽ������flip()�����Ὣposition���0������limit���ó�֮ǰposition��ֵ�� 
 
				  
				while(buf.hasRemaining()){  
					System.out.print((char) buf.get());  
				}  
				  
				buf.clear();  
				bytesRead = inchannel.read(buf);  
			}  
			aFile.close();  
			
			
		} catch (Exception e) {			
			e.printStackTrace();
		} 
	}

	public static void transform(){
		try{
		RandomAccessFile fromFile = new RandomAccessFile("test.xml", "rw");  
		FileChannel      fromChannel = fromFile.getChannel();  
		  
		RandomAccessFile toFile = new RandomAccessFile("test2.xml", "rw");  
		FileChannel      toChannel = toFile.getChannel(); 
		long position = 0;  
		long count = fromChannel.size();  
		  
		toChannel.transferFrom(fromChannel, position, count);
		}catch(Exception e){
			
		}
	}
	
	public static void selectorTest(){
		try {
		   // Object obj=new Object();
		    //obj.wait();
		    //Thread
			Selector selector = Selector.open();
			//channel.configureBlocking(false);  
			//SelectionKey key = channel.register(selector,  
			   // Selectionkey.OP_READ);
		} catch (Exception e) {			
			e.printStackTrace();
		} 
	}
	
	
	
}
