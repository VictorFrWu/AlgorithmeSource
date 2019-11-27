package BattleDev11Novembre2019;

import java.util.Scanner;

/**
 * @author he.wu For your grandmother's 80th birthday, you are responsible for
 *         preparing the gift: a square wooden frame to paste a picture of the
 *         star of the evening. Because your budget is tight, you decide to
 *         build the frames in your workshop. You decide to reuse old materials.
 *         You have a box full of thin planks of wood of the same thickness and
 *         width but of different lengths. Your grandmother won't blame you if
 *         the frames aren't all the same size, having said that - she insists
 *         that they're square. You then decide to randomly take 4 boards in the
 *         box and cut them, if necessary, in order to build the largest square
 *         frame possible. Note that when you cut a board, you keep the part you
 *         are interested in and you throw the second part into the box, you can
 *         no longer use it for this frame. The objective is to determine how
 *         many centimetres you need to throw back into the box if you build the
 *         largest square frame possible. Data format Input Rows 1 to 4: an
 *         integer between 10 and 1,000 representing to the length of a wooden
 *         plank expressed in centimetres. Output An integer representing the
 *         number of centimetres of wood you throw into the cardboard if you
 *         build the largest square frame possible
 */
public class birthday2 {

	public static void main(String[] argv) throws Exception {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int i = 0;
		int[] record = new int[4];
		int min = Integer.MAX_VALUE;
		while (sc.hasNextLine() && i < 4) {
			record[i] = sc.nextInt();
			sum += record[i];
			min = Math.min(min, record[i]);
			i++;
			/* Lisez les données et effectuez votre traitement */
		}
		/*
		 * Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes
		 * les données.
		 */
		System.out.println(sum - 4*min);
	}

}
