package DesignPattern.deepCopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ProtoType implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public CloneTarget target;

	public ProtoType() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Object deep = super.clone();
		ProtoType deepProtoType = (ProtoType) deep;
		deepProtoType.target = (CloneTarget) target.clone();
		return deepProtoType;
	}

	
	public Object deepclone() throws CloneNotSupportedException {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			// serialisation
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);

			// deserialisation
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			ProtoType deep = (ProtoType) ois.readObject();
			return deep;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				bos.close();
				oos.close();
				bis.close();
				ois.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

	@Override
	public String toString() {
		return "ProtoType [name=" + name + ", target=" + target + "]";
	}

}
