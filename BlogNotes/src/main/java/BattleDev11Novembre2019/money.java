package BattleDev11Novembre2019;

import java.util.*;
import java.math.*;

// Do not modify Change
class Change {
	long coin2 = 0;
	long bill5 = 0;
	long bill10 = 0;
}

class Solution {

	// Do not modify this method​​​​​​‌​​​‌​‌‌​​​​​‌​‌​‌​​​‌‌​‌ signature
	static Change optimalChange(long s) {
		if (s <= 1 || s > Long.MAX_VALUE)
			return null;
		Change c = new Change();
		if (s % 2 > 0) {
			if (s % 10 == 5) {
				c.bill10 = s / 10;
				c.bill5 = 1;
				c.coin2 = 0;
			} else if (s % 10 < 5) {
				c.bill10 = s / 10 - 1;
				c.bill5 = 1;
				c.coin2 = ((s % 10) + 5) / 2;
			} else {
				c.bill10 = s / 10;
				c.bill5 = 1;
				c.coin2 = ((s % 10) - 5) / 2;
			}
		} else {
			c.bill10 = s / 10;
			c.bill5 = 0;
			c.coin2 = (s % 10) / 2;
		}
		return c;
	}
}

public class money {
	public static void main(String[] args) {
		long s = 17L; // Change this value to perform other tests
		Change m = Solution.optimalChange(s);

		System.out.println("Coin(s)  2€: " + m.coin2);
		System.out.println("Bill(s)  5€: " + m.bill5);
		System.out.println("Bill(s) 10€: " + m.bill10);

		long result = m.coin2 * 2 + m.bill5 * 5 + m.bill10 * 10;
		System.out.println("\nChange given = " + result);
	}

}
