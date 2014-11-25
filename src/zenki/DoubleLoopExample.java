package zenki;

public class DoubleLoopExample {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				if (i * j > 30) {
					break;
				}
				System.out.printf("%3d ", i * j);
			}
			System.out.println(":end!");
		}
		System.out.println();

		for (int i = 1; i <= 10; i++) {
			boolean check = false;
			for (int j = 1; j <= 10; j++) {
				if (i * j > 30) {
					check = true;
					break;
				}
				System.out.printf("%3d ", i * j);
			}
			if (check) {
				break;
			}
			System.out.println(":end!");
		}
		System.out.println();

		System.out.println();

		outerloop: for (int i = 1; i <= 10; i++) {
			//innerloop:
			for (int j = 1; j <= 10; j++) {
				if (i * j > 30) {
					break outerloop;
				}
				System.out.printf("%3d ", i * j);
			}
			System.out.println(":end!");
		}//outerloop_end
	}

}
