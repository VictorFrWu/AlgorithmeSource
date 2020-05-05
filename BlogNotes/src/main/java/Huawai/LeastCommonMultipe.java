package Huawai;

import java.util.Scanner;

/**
 * @author mac
 *         链接：https://www.nowcoder.com/questionTerminal/22948c2cad484e0291350abad86136c3?answerType=1&f=discussion
 *         来源：牛客网
 * 
 *         求最大公约数有两种方法 更相减损法和辗转相处法 最小公倍数在求出最大公约数后 两个数相乘除以最大公约数就是最小公倍数
 *         以下我们用的是更相减损法
 *         更相减损法是拿两个数中的较大值减去较小值，然后在减数、被减数、差之间选取两个较小值继续相减，直到减数和被减数相等，得出的数就是最大公约数。
 *         例：//更相减损术： //8 10 //10 - 8=2 //8 - 2= 6 //6-2=4 //4-2=2
 *         //2==2于是最大公约数就是2
 */
public class LeastCommonMultipe {
//	public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        while(scan.hasNext()){
//            int n = scan.nextInt();
//            int m = scan.nextInt();
//            if(n==0 || m==0){
//                System.out.println(0);
//            }
//            for(int i = 1;i<=(n*m);i++){
//                if(i%n == 0 && i%m==0){
//                    System.out.println(i);
//                    break;
//                }
//            }
//        }
//        scan.close();
//    }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			if (n == 0 || m == 0) {
				System.out.println(0);
			} else {
				System.out.println(n * m / helper(n, m));
			}
		}
		scan.close();
	}

	public static int helper(int n, int m) {
		if (n == m) {
			return n;
		}
		int diff = Math.abs(n - m);
		return helper(diff, Math.min(n, m));
	}
}
