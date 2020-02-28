package DesignPattern.AbstractFactory.copy;

import java.util.Calendar;

public class CalendarTest {
	/**
	 * @param args
	 * 
	 *             Calendar
	 * 
	 *             c getIntsance check timezone and local default format
	 */
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c);
	}
}
