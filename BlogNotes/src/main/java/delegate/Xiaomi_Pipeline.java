package delegate;

import org.junit.Test;

public class Xiaomi_Pipeline {

	public void oled() {
		Sumsung sumsung = new Sumsung(); // 确定使用三星的OLED技术
		Fotconn fotconn = new Fotconn(sumsung);// 告诉乙方 富土康：“我要三星图纸生产的OLED”

		System.out.println("小米正在生产: ");
		fotconn.tchName();
		fotconn.colorSaturation();

	}

	@Test
	public void testXiaomi8() {
		Xiaomi_Pipeline xiaomi8 = new Xiaomi_Pipeline();
		xiaomi8.oled();

	}
}
