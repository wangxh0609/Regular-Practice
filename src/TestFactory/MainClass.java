package TestFactory;

import java.util.Scanner;

public class MainClass { 
	public static void main(String[] args){
		System.out.println("--------���������--------");
		System.out.println("--------�����һ��������--------");
		Scanner scan=new Scanner(System.in);
		String strNum1=scan.nextLine();
		System.out.println("���������");
		String oper=scan.nextLine();
		System.out.println("����ڶ���������");
		String strNum2=scan.nextLine();
		double num1=Double.parseDouble(strNum1);
		double num2=Double.parseDouble(strNum2);
		if("+".equals(oper)){
			Operation operation=new AddOperation();
			operation.setNum1(num1);
			operation.setNum2(num2);
			operation.getResult();
		}
		
	}

}
