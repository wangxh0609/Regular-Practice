package com.hust.swordtooffer;

/*二维数组每行每列递增排序
 * 从该二维数组中找出指定的数字
 */
public class FindNumberInArray {
	public static void main(String[] args){
		int[][] intArr=new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		int number=5;
		System.out.println(findNumberCheck(intArr,number));
		
	}
	
	public static boolean findNumberCheck(int[][] sourceArr,int number){
		if(sourceArr==null||sourceArr.length==0){
			return false;
		}
		return findNumber(sourceArr,number);
	}
	
	/*从右上角找起
	 * 如果该值大于输入值则值在左边 此时所在列-1
	 * 如果该值小于输入值则值在下面 此时所在行 +1
	 * 如果想等 则查找结束 返回true
	 * 以此类推，直到行>rowLen或者列<0查找结束返回false
	 */
	public static boolean findNumber(int[][] sourceArr,int number){
		int rowLen=sourceArr.length;
		int columnLen=sourceArr[0].length;
		for(int i=0;i<rowLen;i++){
			for(int j=columnLen;j>0;j--){
				int test=sourceArr[i][j-1];
				if(number>sourceArr[i][j-1]){
					break;				
				}
				else if(number<sourceArr[i][j-1]){
					columnLen=columnLen-1;
					
				}
				else{
					return true;
				}
			}
		}
		return false;
	}

}
