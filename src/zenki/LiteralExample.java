package zenki;

public class LiteralExample {

	public static void main(String[] args) {
		int idata;

		//８進数の例
		idata = 022;
		System.out.println(idata);

		//１６進数の例
		idata = 0x12AB;
		System.out.println(idata);

		//２進数の例（java7以降）
		idata = 0b10100101;
		System.out.println(idata);

		//桁区切りの例（java7以降）
		idata = 123_456_789;
		System.out.println(idata);

		double ddata;

		//実数の指数表現の例
		ddata = 5.67e4;
		System.out.println(ddata);

		ddata = 5.67e-4;
		System.out.printf("%10.8f%n", ddata);

	}
}
