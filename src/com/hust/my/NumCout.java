package com.hust.my;
import java.util.*;  
public class NumCout{  
    public static void main(String[] args){  
        Scanner scan=new Scanner(System.in);  
        while(scan.hasNextLine()){  
            String str=scan.nextLine();  
            englishCount=getEnglishCharCount(str);  
            blankCount=getBlankCharCount(str);  
            numCount=getNumberCharCount(str);  
            int otherCount=getOtherCharCount(str);  
            System.out.println(englishCount+" "+blankCount+" "+numCount+" "+otherCount);  
        }  
          
    }  
     
    private static int englishCount=0;  
    private static int numCount=0;  
    private static int blankCount=0;  
    public static int getEnglishCharCount(String str)  
    {  
        if(str!=null){  
            int count=0;  
            int length=str.length();  
            for(int i=0;i<length;i++){  
                char tem=str.charAt(i);  
                if((tem>='a'&&tem<='z')||(tem>='A'&&tem<='Z')){  
                    count++;     
                }  
            }  
            englishCount=count;  
            return count;  
        }  
          
        return 0;  
    }  
      
    /** 
     * 统计出空格字符的个数。 
     *  
     * @param str 需要输入的字符串 
     * @return 空格的个数 
     */  
    public static int getBlankCharCount(String str)  
    {  
        if(str!=null){  
            String[] charArr=str.split(" ");     
            blankCount=charArr.length-1;  
            return charArr.length-1;  
        }  
        else{  
            return 0;  
        }  
    }  
      
    /** 
     * 统计出数字字符的个数。 
     *  
     * @param str 需要输入的字符串 
     * @return 英文字母的个数 
     */  
    public static int getNumberCharCount(String str)  
    {  
         if(str!=null){  
            int count=0;  
            int length=str.length();  
            for(int i=0;i<length;i++){  
                char tem=str.charAt(i);  
                if((tem>='0'&&tem<='9')){  
                    count++;     
                }  
            }  
            numCount=count;  
            return count;  
        }  
        return 0;  
    }  
      
    /** 
     * 统计出其它字符的个数。 
     *  
     * @param str 需要输入的字符串 
     * @return 英文字母的个数 
     */  
    public static int getOtherCharCount(String str)  
    {  
          
        return str.length()-numCount-blankCount-englishCount;  
    }  
      
      
}  






