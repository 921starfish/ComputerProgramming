package myMethods;

public class MyMethods {

	static boolean sequencialSearch(int[] data, int value) { // 逐次探査(sequencial search)
		for (int i : data) {
			if (i == value) {
				return true;
			}
		}
		return false;
	}

	static boolean binarySearch(int[] data, int value) { // 二分探索(Binary Search)
		java.util.Arrays.sort(data); // 本来は既に昇順の配列を引数に
		int left = 0;
		int right = data.length - 1;
		int middle = 0;
		while (left <= right) {
			middle = (left + right) / 2; // 整数をわっているので注意
			if (data[middle] == value) {
				return true;
			} else if (data[middle] > value) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return false;
	}
}
