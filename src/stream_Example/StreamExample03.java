package stream_Example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamExample03 {

	public static void main(String[] args) {

		File file = new File("src/stream_Example/file01.txt");
		String str = "abcdefg¥nあいうえお";

		try {
			System.out.println("ファイルへデータを書き出します。");
			FileWriter fw = new FileWriter(file);
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			System.out.println("ファイルに正しく書き込めませんでした。");
		}

		try {
			System.out.println("ファイルからデータを読み出します。");
			str = "";
			FileReader fr = new FileReader(file);
			int c;
			while ((c = fr.read()) != -1) {
				str += (char) c;
			}
			fr.close();
			System.out.println(str);
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが存在しないので、データを読込めませんでした。");
		} catch (IOException e) {
			System.out.println("ファイルのデータを正しく読込めませんでした。");
		}
	}
}