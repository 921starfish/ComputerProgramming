package stream_Example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamExample01 {

	public static void main(String[] args) {

		File file = new File("src/stream_Example/file01.txt");
		String str = "abcdefg¥nあいうえお";

		try {
			System.out.println("ファイルへデータを書き出します。");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(str.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("ファイル名が正しくないのでファイルを作成できませんでした。");
		} catch (IOException e) {
			System.out.println("ファイルに正しく書き込めませんでした。");
		}

		try {
			System.out.println("ファイルからデータを読み出します。");
			byte[] bdata = new byte[(int) file.length()];
			FileInputStream fis = new FileInputStream(file);
			fis.read(bdata);
			fis.close();
			str = new String(bdata);
			System.out.println(str);
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが存在しないので、データを読込めませんでした。");
		} catch (IOException e) {
			System.out.println("ファイルのデータを正しく読込めませんでした。");
		}
	}
}