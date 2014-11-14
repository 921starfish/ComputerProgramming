package myMethods;

class MyMethodsMain {

	public static void main(String[] args) {
		int[] array = new int[] { 10, 5, 20, 3, 0, -5, 6, 100, 22, 456 };
		int value = 0;
		if (MyMethods.sequencialSearch(array, value)) {
			System.out.println(value + "が見つかりました！");
		} else {
			System.out.println(value + "は見つかりませんでした！");
		}

		if (MyMethods.binarySearch(array, value)) {
			System.out.println(value + "が見つかりました！");
		} else {
			System.out.println(value + "は見つかりませんでした！");
		}
	}

}
