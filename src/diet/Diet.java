package diet;

class Diet {
	static double weightAverage(Person person) {
		// 標準体重の計算式：
		//       標準体重(kg) = 22 × 身長(m) × 身長(m)
		//                              ただし、女性は 21

		double heightMeter = person.height / 100;
		double weightAverage = 22 * Math.pow(heightMeter, 2);
		return weightAverage;
	}

	static double fatnessIndex(Person person) {
		// 肥満度の計算式
		//        肥満度(%) = ( 体重(kg) - 標準体重(kg) ) ÷
		//                                              標準体重(kg) × 100

		double weightAverage = weightAverage(person);
		double fatnessIndex = (person.weight - weightAverage) /
				weightAverage * 100;
		return fatnessIndex;
	}
}