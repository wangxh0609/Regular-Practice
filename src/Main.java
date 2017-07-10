
import java.util.*;
public class Main{
	   public static void main(String[] args) {
	     Scanner sc=new Scanner(System.in);
		 int n=sc.nextInt();
	     int[] array=new int[n];
	     for (int i=0;i<n;i++){
	       array[i]=sc.nextInt();
	     }
	     System.out.println( isHasReverseSub(array));
	   }  
	  public static boolean isHasReverseSub(int[] a){
	    if(a==null){
	      	return false;
	    }
	    int len=a.length;
	    int i=0;
	    int j=len-1;
	    while(i+1<len&&a[i+1]>=a[i]){
	      i++;
	    }
	    if(i==len-1){
	      return false;
	    }
	    while(j>=0&&a[j]>=a[j-1]){
	      j--;
	    }
	    if(i-1>=0&&a[j]<a[i-1]){
	    	return false;
	    }
	    if(j+1<len-1&&a[i]>a[j+1]){
	    	return false;
	    }	   
	   while(a[i+1]<=a[i]){
	     i++;
	   }
	  if(i==j){
		  return true;
	  }
	  else{
		  return false;
	  }
	}
}