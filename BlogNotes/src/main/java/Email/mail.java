package Email;

import org.junit.Test;

public class mail {
	public static boolean isValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	@Test
	public void test() {
		String mail = "dachichiwuhe@gmail.com";
		System.out.println(isValid(mail));
	};
}
