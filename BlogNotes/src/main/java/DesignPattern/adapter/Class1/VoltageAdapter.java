package DesignPattern.adapter.Class1;

public class VoltageAdapter extends Voltage220 implements Voltage5 {

	@Override
	public int output5() {
		// TODO Auto-generated method stub
		int src = output220();
		int dstv = src / 44;
		return dstv;
	}

}
