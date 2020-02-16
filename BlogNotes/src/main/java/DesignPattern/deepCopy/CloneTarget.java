package DesignPattern.deepCopy;

import java.io.Serializable;

public class CloneTarget implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String cloneName;
	public String cloneClass;

	@Override
	public String toString() {
		return "CloneTarget [cloneName=" + cloneName + ", cloneClass=" + cloneClass + "]";
	}

	public CloneTarget(String cloneName, String cloneClass) {
		super();
		this.cloneName = cloneName;
		this.cloneClass = cloneClass;
	}


	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
