package Huawai;

import java.util.Scanner;

public class PasswordNote {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.next();
			int record = 0;
			int alph = 0, Alph = 0, num = 0, sign = 0;
			// first critere length
			if (str.length() <= 4) {
				record += 5;
			} else if (str.length() > 4 && str.length() < 7) {
				record += 10;
			} else {
				record += 25;
			}

			for (char c : str.toCharArray()) {
				if (Character.isDigit(c)) {
					num++;
				} else if (Character.isLetter(c)) {
					if (c >= 'a' && c <= 'z') {
						alph = 1;
					} else {
						Alph = 1;
					}
				} else {
					sign++;
				}
			}

			// letter score
			if ((alph == 0 && Alph == 1) || (alph == 1 && Alph == 0)) {
				record += 10;
			} else if (alph == 1 && Alph == 1) {
				record += 20;
			}

			// number score
			if (num == 1) {
				record += 10;
			} else if (num > 1) {
				record += 25;
			}

			// sign score
			if (sign == 1) {
				record += 10;
			} else if (sign > 1) {
				record += 20;
			}

			// award score
			if (sign > 0 && alph == 1 && Alph == 1 && num > 0) {
				record += 5;
			} else if (sign > 0 && num > 0 && (alph == 0 || Alph == 0)) {
				record += 3;
			} else if (num > 0 && (alph == 1 || Alph == 1)) {
				record += 2;
			}

			// count
			if (record >= 90) {
				System.out.println("VERY_SECURE");
			} else if (record >= 80) {
				System.out.println("SECURE");
			} else if (record >= 70) {
				System.out.println("VERY_STRONG");
			} else if (record >= 60) {
				System.out.println("STRONG");
			} else if (record >= 50) {
				System.out.println("AVERAGE");
			} else if (record >= 25) {
				System.out.println("WEAK");
			} else {
				System.out.println("VERY_WEAK");
			}
		}
		scan.close();
	}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		while (sc.hasNext()) {
//			String str = sc.nextLine();
//			System.out.println(GetPwdSecurityLevel(str));
//		}
//		sc.close();
//	}
//
//	public static String GetPwdSecurityLevel(String Password) {
//		int sum = 0;
//		sum += LengthAdd(Password);
//		sum += LetterAdd(Password);
//		sum += IntegerAdd(Password);
//		sum += SymbolAdd(Password);
//		sum += AwardAdd(Password);
//		if (sum >= 90)
//			return "VERY_SECURE";
//		else if (sum >= 80)
//			return " SECURE";
//		else if (sum >= 70)
//			return "VERY_STRONG";
//		else if (sum >= 60)
//			return "STRONG";
//		else if (sum >= 50)
//			return "AVERAGE";
//		else if (sum >= 25)
//			return "WEAK";
//		return "VERY_WEAK";
//	}
//
//	public static int LengthAdd(String Password) {
//		if (Password.length() <= 4)
//			return 5;
//		else if (Password.length() >= 5 && Password.length() <= 7)
//			return 10;
//		return 25;
//	}
//
//	public static int LetterAdd(String Password) {
//		int UpperLetter = 0;
//		int LowerLetter = 0;
//		for (int i = 0; i < Password.length(); i++) {
//			String ch = String.valueOf(Password.charAt(i));
//			if (ch.matches("[A-Z]"))
//				UpperLetter++;
//			else if (ch.matches("[a-z]"))
//				LowerLetter++;
//		}
//		if (UpperLetter != 0 && LowerLetter != 0)
//			return 20;
//		else if ((UpperLetter == 0 && LowerLetter != 0) || (UpperLetter != 0 && LowerLetter == 0))
//			return 10;
//		return 0;
//	}
//
//	public static int IntegerAdd(String Password) {
//		int NumOfInteger = 0;
//		for (int i = 0; i < Password.length(); i++) {
//			if (Password.charAt(i) >= '0' && Password.charAt(i) <= '9')
//				NumOfInteger++;
//		}
//		if (NumOfInteger == 0)
//			return 0;
//		else if (NumOfInteger == 1)
//			return 10;
//		return 20;
//	}
//
//	public static int SymbolAdd(String Password) {
//		int NumOfSymbol = 0;
//		for (int i = 0; i < Password.length(); i++) {
//			char ch = Password.charAt(i);
//			if ((ch >= 0x21 && ch <= 0x2F) || (ch >= 0x3A && ch <= 0x40) || (ch >= 0x5B && ch <= 0x60)
//					|| (ch >= 0x7B && ch <= 0x7E))
//				NumOfSymbol++;
//		}
//		if (NumOfSymbol == 0)
//			return 0;
//		else if (NumOfSymbol == 1)
//			return 10;
//		return 25;
//	}
//
//	public static int AwardAdd(String Password) {
//		int LetterNum = LetterAdd(Password);
//		int IntegerNum = IntegerAdd(Password);
//		int SymbolNum = SymbolAdd(Password);
//		if (LetterNum != 0 && IntegerNum != 0 && SymbolNum == 0)
//			return 2;
//		else if (LetterNum == 10 && IntegerNum != 0 && SymbolNum != 0)
//			return 3;
//		else if (LetterNum == 20 && IntegerNum != 0 && SymbolNum != 0)
//			return 5;
//		return 0;
//	}
}
