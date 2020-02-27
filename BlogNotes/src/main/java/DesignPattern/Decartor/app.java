package DesignPattern.Decartor;

public class app {
	public static void main(String[] args) {
		// decator design pattern

		// 1 order longblack
		Drink order = new AmericanLong();
		System.out.println(order.cost() + " " + order.getDes());
		
		//2 add a milk 
		order = new Milk(order);
		System.out.println(order.cost() + " " + order.getDes());
		
		//3 add chocolate
		order = new Chocolate(order);
		System.out.println(order.cost() + " " + order.getDes());
		
		
		// second order
		Drink order2 = new Deacf();
		System.out.println(order2.cost() + " " + order2.getDes());
		
		//add soja 
		order2 = new Soja(order2);
		System.out.println(order2.cost() + " " + order2.getDes());
	}
}
