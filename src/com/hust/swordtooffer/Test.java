package com.hust.swordtooffer;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		String str="abdcs";
		str.toUpperCase();
		str.toLowerCase();
		str.toCharArray();
		str.contains(str);
		str.charAt(0);
		System.out.println(str.substring(0, 1));
		Map<String,Integer> map=new HashMap<String,Integer>();
		List<String> strList=new ArrayList<String>();
		Iterator iter=strList.iterator();
		iter.hasNext();
		iter.next();
		for(String str1:map.keySet()){
			strList.add(str1);
		}
		for(Map.Entry<String, Integer> entry:map.entrySet()){
			entry.getKey();
			entry.getValue();
		}
	}

}
