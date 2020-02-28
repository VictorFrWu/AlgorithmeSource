package DesignPattern.adapter.Class1;

public class Phone {
	public void charge(Voltage5 v5) {
		if(v5.output5() == 5) {
			System.out.println("telephone has charged");
		}else {
			throw new IllegalArgumentException("can not charge");
		}
	}
}
