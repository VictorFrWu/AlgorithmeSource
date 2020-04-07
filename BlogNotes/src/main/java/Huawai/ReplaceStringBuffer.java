package Huawai;

public class ReplaceStringBuffer {
	public static void main(String[] args) {

	}

	public String replaceSpace(StringBuffer str) {
		String s = str.toString();
		return s.replaceAll(" ", "%20");
	}
}
