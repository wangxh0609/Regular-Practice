import java.util.*;

import javax.swing.plaf.DimensionUIResource;
public class Test {

	public static void main(String[] args) {
		
	
		String str=new String();
		StringBuilder sb=new StringBuilder();
		StringBuffer sbuffer=new StringBuffer();
		//list
		ArrayList arrayList=new ArrayList();
		LinkedList linkedList=new LinkedList();
		Vector vector=new  Vector<>();
		
		HashSet hs=new HashSet();
		LinkedHashSet lhs=new LinkedHashSet();
		TreeSet ts=new TreeSet();
		
		HashMap map1=new HashMap();
		WeakHashMap map2=new WeakHashMap();
		LinkedHashMap map3=new LinkedHashMap();
		TreeMap map4=new TreeMap();
		//Scanner sc=new Scanner(System.in);
//		while(sc.hasNextLine()){
//			int parseInt=stringToInt(sc.nextLine());
//			System.out.println(parseInt);
//		}
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		//输入n作为二维数组的长度
		String array[][] = new String [n][n];
		for( int i = 0;i < n; i++){
		for(int j = 0;j < n; j++){
		array[i][j] = input.next();
		}
		}

	}

	public static <T> int stringToInt(T str){
		int myInt=0;
		if(str==null){
			return 0;
		}
		else{
			if(str instanceof String){
				try{
					myInt=Integer.parseInt((String)str);
				}
				catch(Exception e){
					System.out.println("转换失败！");
				}
			}
		}
		return myInt;
		
	}
}
