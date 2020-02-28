package DesignPattern.AbstractFactory;

public class LdFactory implements AbsFactory{

	@Override
	public Pizza createPizza(String orderType) {
		Pizza pizza = null;
		System.out.println("use abstract factory design pattern");
		if(orderType.equals("cheese")) {
			pizza = new LondonCheesePizza();
		}else {
			pizza = new LondonPepporPizza();
		}
		return pizza;
	}

}
