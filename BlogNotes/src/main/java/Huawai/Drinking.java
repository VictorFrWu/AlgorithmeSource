package Huawai;

import java.util.Scanner;

public class Drinking {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while (sc.hasNext()) {
			n = sc.nextInt();
			System.out.println(count(n));
		}

	}

	public static int Drink(int n) {
		if (n <= 0)
			return 0;
		else if (n == 3)
			return 1;
		else if (n == 2)
			return 1;
		else// 此时表明对应为3的倍数，递归
		{
			int h = 0;
			h = n / 3;
			return h + Drink(n - 3 * h + h);
		}
	}

	public static int count(int n) {
		if (n <= 1) {
			return 0;
		}
		int count = 0;
		while (n > 1) {
			count += n / 3;
			n = n / 3 + n % 3;
			if (n == 2) {
				count++;
				break;
			}
		}
		return count;
	}

//	import java.util.*;
//	public class Main{
//	    public static void main(String[] args){
//	        Scanner scan = new Scanner(System.in);
//	        while(scan.hasNext()){
//	            int n = scan.nextInt();
//	            if(n<=3){
//	                System.out.println(1);
//	            }
//	            int count = 0;
//	            while(n>=2){
//	                count += n/3;
//	                n = n/3 + n%3;
//	                if(n == 2){
//	                    count++;
//	                    break;
//	                }
//	            }
//	            System.out.println(count);
//	        }
//	    }
//	}
}