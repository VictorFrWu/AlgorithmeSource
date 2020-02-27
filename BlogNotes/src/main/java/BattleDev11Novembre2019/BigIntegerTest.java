package BattleDev11Novembre2019;

import java.math.BigInteger;

public class BigIntegerTest {
	public static void main(String[] args) {
		BigInteger bi = new BigInteger("1");
		bi.add(new BigInteger("1"));
		System.out.println(bi);
		BigInteger bi2 = bi.add(new BigInteger("1"));
		System.out.println(bi2);
	}
}
