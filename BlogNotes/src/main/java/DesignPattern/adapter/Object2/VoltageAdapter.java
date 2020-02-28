package DesignPattern.adapter.Object2;

public class VoltageAdapter implements Voltage5 {

	private Voltage220 voltage220;
	
	public VoltageAdapter(Voltage220 voltage220) {
		this.voltage220 = voltage220;
	}
	
	@Override
	public int output5() {
		// TODO Auto-generated method stub
		int dst = 0;
		if(voltage220 != null) {
			int src = voltage220.output220();
			dst = src/44;
		}
		return dst;
	}

}
