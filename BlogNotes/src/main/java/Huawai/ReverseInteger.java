package Huawai;

import java.util.Scanner;

public class ReverseInteger {
	  public static void main(String[] args){
	        Scanner scan = new Scanner(System.in);
	        String str = scan.nextLine();
	        StringBuilder sb = new StringBuilder(str);
	        System.out.println(sb.reverse().toString());
	    }
}
