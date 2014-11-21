package stream_Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamExample06 {

	public static void main(String[] args) {

		System.out.println("キーボードからデータを入力します。");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			while (!(line = br.readLine()).equals("")) {
				System.out.println("入力された文字列は：" + line);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("キーボードが使用できなくなっています。");
		}
	}
}