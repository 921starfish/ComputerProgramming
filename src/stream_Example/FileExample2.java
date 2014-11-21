package stream_Example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileExample2 {

	public static void main(String[] args) throws Exception {

		File file =
				new File("src/stream_Example/FileExample2.java");
		BufferedReader br = new BufferedReader(new FileReader(file));
		File file2 =
				new File("src/stream_Example/FileExample2.java.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file2));

		String line;
		int count = 0;
		while ((line = br.readLine()) != null) {
			count += 5;
			bw.write(String.valueOf(count) + ":" + line);
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}