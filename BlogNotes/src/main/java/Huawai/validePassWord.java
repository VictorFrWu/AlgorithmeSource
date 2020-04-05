package Huawai;

import java.util.Scanner;

public class validePassWord {
	public static boolean checkLength(String password) {
		if (password == null || password.length() <= 8)
			return false;
		return true;
	}

	// 2.包括大小写字母.数字.其它符号,以上四种至少三种
	public static boolean checkCharKinds(String password) {
		int Digit = 0, lowercase = 0, uppercase = 0, others = 0;
		char[] ch = password.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= '0' && ch[i] <= '9') {
				Digit = 1;
				continue;
			} else if (ch[i] >= 'a' && ch[i] <= 'z') {
				lowercase = 1;
				continue;
			} else if (ch[i] >= 'A' && ch[i] <= 'Z') {
				uppercase = 1;
				continue;
			} else {
				others = 1;
				continue;
			}
		}
		int total = Digit + lowercase + uppercase + others;
		return total >= 3 ? true : false;
	}

	// 3.不能有相同长度超2的子串重复
	public static boolean checkCharRepeat(String password) {
		for (int i = 0; i < password.length() - 2; i++) {
			String substr1 = password.substring(i, i + 3);
			if (password.substring(i + 1).contains(substr1))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextLine()) {
			String psw = cin.nextLine();
			if (checkLength(psw) && checkCharKinds(psw) && checkCharRepeat(psw))
				System.out.println("OK");
			else
				System.out.println("NG");
		}
	}
}
