package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Apple {

	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static void main(String[] args) throws Exception {
		// 正常的调用
		Apple apple = new Apple();
		apple.setPrice(5);
		System.out.println("Apple Price:" + apple.getPrice());
		// 使用反射调用
		Class<?> clz = Class.forName("reflect.Apple");
		Constructor<?> appleConstructor = clz.getConstructor();
		Object appleObj = appleConstructor.newInstance();
		Method setPriceMethod = clz.getMethod("setPrice", int.class);
		setPriceMethod.invoke(appleObj, 14);
		Method getPriceMethod = clz.getMethod("getPrice");
		System.out.println("Apple Price:" + getPriceMethod.invoke(appleObj));

		Class<Apple> clz1 = Apple.class;
		Field[] fields = clz1.getFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}
}