package zenki;

public class StringConnectExample {

	public static void main(String[] args) {
		String s = ""; //String s = null; とは違う。
		//char c = ''; これはダメ。
		s = s + "abc";
		s += "def";
		s += 10;
		System.out.println("s = " + s);
		System.out.println("s = " + s + 20);
		System.out.println("s = " + s + (10+20));
		System.out.println(10 + 20 + s);
	}
}
