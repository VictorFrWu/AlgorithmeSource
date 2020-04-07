package Huawai;

import java.util.*;

public class CodeEncryptDecrypt {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String encrypt = scan.next();
			String decrypt = scan.next();
			System.out.println(encryptCode(encrypt));
			System.out.println(decryptCode(decrypt));
		}
		scan.close();
	}

	public static String encryptCode(String str) {
		StringBuilder sb = new StringBuilder();
		char[] cs = str.toCharArray();
		for (char c : cs) {
			if (Character.isDigit(c)) {
				if (c == '9') {
					sb.append('0');
				} else {
					char temp = (char) (c + 1);
					sb.append(temp);
				}
			} else if (Character.isLetter(c)) {
				if (c < 'z' && c >= 'a') {
					char temp = (char) (c - 31);
					sb.append(temp);
					continue;
				}
				if (c == 'z') {
					sb.append('A');
					continue;
				}
				if (c == 'Z') {
					sb.append('a');
					continue;
				}
				if (c < 'Z' && c >= 'A') {
					char temp = (char) (c + 33);
					sb.append(temp);
					continue;
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String decryptCode(String str){
        StringBuilder sb = new StringBuilder();
        char[] cs = str.toCharArray();
        for(char c : cs){
            if(Character.isDigit(c)){
                if(c == '0'){
                    sb.append('9');
                }else{
                    char temp = (char)(c - 1);
                    sb.append(temp);
                }
            }
            else if(Character.isLetter(c)){
                if(c <= 'z' && c > 'a'){
                    char temp = (char)(c - 33);
                    sb.append(temp);
                    continue;
                }
                if(c == 'a'){
                    sb.append('Z');
                    continue;
                }
                if(c == 'A'){
                    sb.append('z');
                    continue;
                }
                 if(c <= 'Z' && c > 'A'){
                    char temp = (char)(c + 31);
                    sb.append(temp);
                    continue;
                }
            }else {
            	sb.append(c);
            }
        }
        return sb.toString();
    }
}