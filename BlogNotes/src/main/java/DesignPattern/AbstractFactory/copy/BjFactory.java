package DesignPattern.AbstractFactory.copy;

public class BjFactory implements AbsFactory{

	@Override
	public Pizza createPizza(String orderType) {
		// TODO Auto-generated method stub
		System.out.println("use abstract factory design pattern");
		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new BeijingCheesePizza();
		}else {
			pizza = new BeijingPepporPizza();
		}
		return pizza;
	}

}
