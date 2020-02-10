package delegate;

public class Fotconn implements OledTch {
	private OledTch oledMap; //富土康的OLED生产图纸
	
	//构造函数：甲方指定用哪家的图纸就用哪家的图纸
	public Fotconn(OledTch oledMap) {
		this.oledMap = oledMap;
	}
	
	//构造函数：默认情况下，用华为的生产图纸
	public Fotconn() {
		this.oledMap = new Huawei();
	}
	
	@Override
	public void tchName() {
		// TODO Auto-generated method stub
		System.out.print("| 富土康生产的——");
		oledMap.tchName();
		System.out.print(" |");
	}
	
	@Override
	public void colorSaturation() {
		// TODO Auto-generated method stub
		System.out.print("| 富土康生产的——");
                oledMap.colorSaturation();
		System.out.print(" |");
	}

}