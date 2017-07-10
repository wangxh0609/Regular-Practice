package TestFactory;

public class AddOperation extends Operation {

	@Override
	public double getResult() {
		// TODO Auto-generated method stub
		double result=this.getNum1()+this.getNum2();
		return result;
	}

}
