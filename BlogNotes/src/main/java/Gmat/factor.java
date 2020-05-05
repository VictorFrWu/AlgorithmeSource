package Gmat;

public class factor {
	public static void main(String[] args) {
		int i = 0;
		float a = 13.3f;
		while(a<15f) {
			float temp = (float) (a*(0.0049));
			a+=temp;
			i++;
		}
		System.out.println(i);
	}
}
