package com.hust.swordtooffer;

public class ReplaceBlankWithNum {

	public static void main(String[] args) {
		System.out.println(replaceBlank("we are happy"));
	}
	public static String replaceBlank(String srcStr){
		if(srcStr==null){
			return "";
		}
		char[] srcChar=srcStr.toCharArray();
		StringBuilder sb=new StringBuilder();
		int length=srcChar.length;
		for(int i=0;i<length;i++){
			if(srcChar[i]!=' '){
				sb.append(srcChar[i]);
			}
			else{
				sb.append("%20");
			}
		}		
		return sb.toString();
		
	}
}
