package stream_Example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSV_Example {

	public static void main(String[] args) throws IOException {

		double[] d = new double[300];
		for (int i = 1; i < d.length; i++) {
			d[i] = func(i * 30. / d.length);
		}
		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter("src/stream_Example/DampedOscillation.csv"));

		bw.write("θ, Sin(θ)/θ");
		bw.newLine();
		for (int i = 1; i < d.length; i++) {
			bw.write(String.valueOf(i * 30. / d.length));
			bw.write(",");
			bw.write(String.valueOf(d[i]));
			bw.newLine();
		}
		bw.close();
		System.out.println("ファイル出力終了しました。");
	}

	static double func(double x) {
		return Math.sin(x) / x;
	}
}