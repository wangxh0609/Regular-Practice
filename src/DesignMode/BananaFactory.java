package DesignMode;

public class BananaFactory implements FruitFactoryMethod {

	@Override
	public Fruit getFruit() {
		// TODO Auto-generated method stub
		return new Banana();
	}

}
