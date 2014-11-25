package diet;

class DietExample {

	public static void main(String[] args) {
		Person taro = new Person("太郎くん", 160.0, 55.0);
		System.out.println(taro.name + "の身長における標準体重は" +
				Diet.weightAverage(taro));
		System.out.println(taro.name + "の肥満度は" + Diet.fatnessIndex(taro));
	}

}