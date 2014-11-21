package stream_Example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamExample05 {

	public static void main(String[] args) {

		File file = new File("src/stream_Example/file02.txt");
		String str = "abcdefg¥nあいうえお";

		System.out.println("ファイルへデータを書き出します。");
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "EUC_JP"));
			bw.write(str);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			System.out.println("ファイルに正しく書き込めませんでした。");
		}

		System.out.println("ファイルからデータを読み出します。");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "SJIS"));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが存在しないので、データを読込めませんでした。");
		} catch (IOException e) {
			System.out.println("ファイルのデータを正しく読込めませんでした。");
		}
	}

}