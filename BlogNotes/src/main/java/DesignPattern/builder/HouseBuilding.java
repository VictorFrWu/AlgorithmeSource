package DesignPattern.builder;

public abstract class HouseBuilding {
	protected House house = new House();

	public abstract void buildBasic();

	public abstract void buildWall();

	public abstract void buildRoof();

	public House buildHouse() {
		return house;
	}
}
