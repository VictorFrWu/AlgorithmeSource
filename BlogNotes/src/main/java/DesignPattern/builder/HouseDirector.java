package DesignPattern.builder;

public class HouseDirector {
	HouseBuilding hb = null;

	public HouseDirector(HouseBuilding hb) {
		super();
		this.hb = hb;
	}

	public HouseBuilding getHb() {
		return hb;
	}

	public void setHb(HouseBuilding hb) {
		this.hb = hb;
	}

	// director control the step of building house
	public House construct() {
		hb.buildBasic();
		hb.buildWall();
		hb.buildRoof();
		return hb.buildHouse();
	}

}
