package DesignPattern.deepCopy;

public class app {
	public static void main(String[] args) throws CloneNotSupportedException {
		ProtoType p = new ProtoType();
		p.name = "wuhe";
		p.target = new CloneTarget("deep", "clone");

		ProtoType p2 = (ProtoType) p.deepclone();
		ProtoType p3 = (ProtoType) p.deepclone();
		System.out.println(p.toString() + " hashcode " + p.target.hashCode());
		System.out.println(p2.toString() + " hashcode " + p2.target.hashCode());
		System.out.println(p3.toString() + " hashcode " + p3.target.hashCode());
	}
}
