package com.hust.swordtooffer;

import java.util.Arrays;

public class MinNumInRotatedArray {

	public static void main(String[] args) {
		
		int[] intArr=new int[]{1,2,3,4,5};
		System.out.println(findMinNumInArray(intArr));
		//Arrays.binarySearch(a, key)
	}
	
	public static int findMinNumInArray(int[] intArr){
		if(intArr==null){
			return Integer.MAX_VALUE;
		}
		int length=intArr.length;
		if(length==1){
			return intArr[0];
		}
		int end=length-1;
		int start=0;
		int mid=start;
		if(intArr[0]<intArr[end]){
			return intArr[0];
		}
		while(intArr[start]>=intArr[end]){
			if(end-start==1){//注意用这个返回
				mid=end;
				break;
			}
			mid=(start+end)/2;
			if(intArr[start]>=intArr[end]&&intArr[start]>=intArr[mid]){
				return MinInOrder(intArr,start,end);
			}
			//起始比中间大说明在最小前半部分
			if(intArr[start]>intArr[mid]){
				end=mid;
			}else{//起始比中间小说明最小在后半部分	
				start=mid;
			}
			
		}
	
		return intArr[mid];
		
		
	}

	private static int MinInOrder(int[] intArr, int start, int end) {
		int result=intArr[start];
		for(int i=start+1;i<end;i++){
			if(result>intArr[i]){
				result=intArr[i];
			}
		}
		return result;
	}

}
