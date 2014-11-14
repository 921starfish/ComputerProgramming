package zenki;

public class EscapeExample {

	public static void main(String[] args) {
		System.out.println("abcdef");
		System.out.println("abc\tdef");//タブ
		System.out.println("abc\ndef");//改行
		System.out.println("abc\\def");//￥マーク
		System.out.println("\"abcdef\"");//ダブルクォーテーション
		System.out.println("\'");//シングルクォーテーション
		System.out.println('a');//char型
		System.out.println('\"');//char型のダブルクォーテーション
		System.out.println("\u548c");//Unicodeで文字を 和
	}
}
