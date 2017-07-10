package com.hust.swordtooffer;

import java.util.Stack;


public class RebuildBinaryTreeNode {

	public static void main(String[] args) {	
		int[] preOrder=new int[]{1,2,4,7,3,5,6,8};
		int[] inOrder=new int[]{4,7,2,1,5,3,6,8};
		//int[][] test=new int[][]{{1,2},{3,4}};
		BinaryTreeNode header=rebuildTreeNode(preOrder,inOrder);
		System.out.println(header.pright.data);
		
		preOrderStack_1(header);
		System.out.println();
		inVisitTreeNode(header);
	}
	
	public static BinaryTreeNode rebuildTreeNode(int[] preOrder,int[] inOrder){
		BinaryTreeNode head=null;
		if(preOrder.length!=inOrder.length){
			return head;
		}
		try{
			head=build(preOrder,inOrder,0,preOrder.length,0,inOrder.length);
		}catch(RuntimeException e){
			head=null;
		}		
		return head;
	}
	public static BinaryTreeNode build(int[] preOrder,int[] inOrder,int preStart,int preEnd,int inStart,int inEnd){
		if(inStart>=inEnd||preStart>preEnd){
			throw new RuntimeException();
		}
		int num=preOrder[preStart];		
		int index=searchNum(inOrder,num,inStart,inEnd);
		if(index==-1){
			throw new RuntimeException();
		}
		//�����������ĳ���
		int leftLength=index-inStart;//����ʽһ��Ϊ��ȷ����û�����������������Ϊ��ȷ������������������ĵڼ���������Ȼû��ȷ��
		//�����������ĳ���
		int rightLength=inEnd-index-1;
		BinaryTreeNode node=new BinaryTreeNode();
		node.data=num;
		if(leftLength>0){
			node.pleft=build(preOrder,inOrder,preStart+1,preEnd,inStart,index);
		}
		if(rightLength>0){
			node.pright=build(preOrder,inOrder,preStart+leftLength+1,preEnd,index+1,inEnd);
		}
		return node;
	}
	
	/*
	 * ����������в��������������
	 */
	public static int searchNum(int[] inOrder,int num,int start,int end){
		if(start>end){
			return -1;
		}
		int length=inOrder.length;
		for(int i=start;i<end;i++){
			if(num==inOrder[i]){
				return i;
			}
		}
		return -1;
	}
	//���������ݹ�������
	public static void preVisitTreeNode(BinaryTreeNode header){
		while(header!=null){
			System.out.print(header.data+" ");
			preVisitTreeNode(header.pleft);
			preVisitTreeNode(header.pright);	
		}		
	}
	public static void inVisitTreeNode(BinaryTreeNode header){
		while(header!=null){
			inVisitTreeNode(header.pleft);
			System.out.print(header.data+" ");
			inVisitTreeNode(header.pright);	
		}		
	}
	
	//������ͼ��������ȱ�����dfs��
	 public static void preOrderStack_1(BinaryTreeNode root){  
	        if(root==null)return;  
	        Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();  
	        s.push(root);  
	        while(!s.isEmpty()){  
	        	BinaryTreeNode temp=s.pop();  
	            System.out.println(temp.data);  
	            if(temp.pright!=null) s.push(temp.pright);  
	            if(temp.pleft!=null) s.push(temp.pleft);  
	        }  
	    }  
	
}
