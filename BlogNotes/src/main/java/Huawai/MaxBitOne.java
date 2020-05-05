package Huawai;

import java.util.Scanner;

/**
 * @author mac 功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 * 
 *         输入: 一个byte型的数字
 * 
 *         输出: 无
 * 
 *         返回: 对应的二进制数字中1的最大连续数 输入描述: 输入一个byte数字
 * 
 *         输出描述: 输出转成二进制之后连续1的个数
 * 
 *         示例1 输入 复制 3 输出 复制 2
 */
public class MaxBitOne {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		while (sc.hasNext()) {
//			int input = sc.nextInt();
//			String bi = Integer.toBinaryString(input);
//			String subs = "1";
//			int cnt = 1;
//			for (int i = 1; i <= bi.length(); i++) {
//				if (bi.contains(subs)) {
//					cnt = subs.length();
//					subs += "1";
//				}
//			}
//			System.out.println(cnt);
//		}
//	}

//	public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int input = sc.nextInt();
//            String[] strs = Integer.toBinaryString(input).split("0");
//            int max = 0;
//            for(String s : strs){
//                max = Math.max(max,s.length());
//            }
//            System.out.println(max);
//        }
//    }
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int count = 0;
			int n = scan.nextInt();
			while (n != 0) {
				n = n & (n << 1);
				count++;
			}
			System.out.println(count);
		}

	}

}
