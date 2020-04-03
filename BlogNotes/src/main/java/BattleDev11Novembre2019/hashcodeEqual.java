package BattleDev11Novembre2019;

public class hashcodeEqual {
	public static void main(String[] args) {
		String i = "1", j ="1";
		if(i.equals(j)) {
			System.out.println(i.hashCode() + " " + j.hashCode());
		}
	}
}
