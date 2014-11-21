package stream_Example;

import java.io.File;
import java.util.Date;

public class FileExample {

	public static void main(String[] args) {

		File file = new File("src/stream_Example/FileExample.java");
		System.out.println("ファイル名＝" + file.getName());
		System.out.println("絶対パス名＝" + file.getAbsolutePath());
		System.out.println("ファイルの大きさ＝" + file.length());
		System.out.println("最終更新時刻＝" + (new Date(file.lastModified())).toString());

		File current = new File(".");
		String[] filesName = current.list();
		if (filesName == null) {
			System.out.println(current + "はディレクトリではありません");
		} else {
			System.out.println(current + "内のファイル一覧を表示します");
			for (int i = 0; i < filesName.length; i++) {
				System.out.println(filesName[i]);
			}
		}
	}
}