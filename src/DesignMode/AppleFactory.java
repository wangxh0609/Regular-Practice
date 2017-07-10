package DesignMode;

public class AppleFactory implements FruitFactoryMethod {

	@Override
	public Fruit getFruit() {
		return new Apple();
	}

}
