package com.hust.swordtooffer;

/*��ά����ÿ��ÿ�е�������
 * �Ӹö�ά�������ҳ�ָ��������
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
	
	/*�����Ͻ�����
	 * �����ֵ��������ֵ��ֵ����� ��ʱ������-1
	 * �����ֵС������ֵ��ֵ������ ��ʱ������ +1
	 * ������ ����ҽ��� ����true
	 * �Դ����ƣ�ֱ����>rowLen������<0���ҽ�������false
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
