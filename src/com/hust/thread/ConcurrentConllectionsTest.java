package com.hust.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

//����������
public class ConcurrentConllectionsTest {
	public static void main(String[] args){
		
		//ConcurrentHashMap<String, Integer> chmap=new ConcurrentHashMap<String,Integer>();
		Collection users=new ArrayList();
		users=new CopyOnWriteArrayList<>();//�����ڵ����в�������
		
		users.add("1");
		users.add("2");
		users.add("3");
		Iterator itUsers=users.iterator();
		while(itUsers.hasNext()){
			String user=(String)itUsers.next();
			if("3".equals(user)){
				users.remove(user);
			}else{
				System.out.println(user);
			}
		}
		
		
	}
}

class Business{
	
	public void test(){
		//������ʹ��  
		Collections.synchronizedMap(null);
		
		
	}
}
