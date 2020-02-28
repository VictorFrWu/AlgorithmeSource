package DesignPattern.AbstractFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class OrderPizza {
	AbsFactory abs;

	public OrderPizza(AbsFactory abs) {
		setAbs(abs);
	}

	public void setAbs(AbsFactory abs) {
		Pizza pizza = null;
		String orderType = "";
		this.abs = abs;
		do {
			orderType = getType();
			pizza = abs.createPizza(orderType);
			if (pizza != null) {
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
			} else {
				System.out.println("failed");
				break;
			}
		} while (true);
	}

	private String getType() {
		try {
			BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input pizza type :");
			String str = strin.readLine();
			return str;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
