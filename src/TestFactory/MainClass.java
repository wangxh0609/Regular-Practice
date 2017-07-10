package TestFactory;

import java.util.Scanner;

public class MainClass { 
	public static void main(String[] args){
		System.out.println("--------计算机程序--------");
		System.out.println("--------输入第一个操作数--------");
		Scanner scan=new Scanner(System.in);
		String strNum1=scan.nextLine();
		System.out.println("输入运算符");
		String oper=scan.nextLine();
		System.out.println("输入第二个操作数");
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
