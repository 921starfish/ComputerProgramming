package zenki;

public class CastExample {

	public static void main(String[] args) {
		byte bdata = 100;


		//byte型からint型へ：キャストせずにＯＫ
		int idata = bdata;


		//int型からbyte型へ：キャストが必要
		bdata = (byte)idata;

		long ldata = 1234567890123L;

		//long型からint型へ：キャストが必要
		idata = (int)ldata;
		//キャストに成功しても、値が正しいかは別の話
		System.out.println("idata = " + idata);


		float fdata = 1234.5678F;
		//float型からdouble型へ：キャストせずにＯＫ
		double ddata = fdata;
		//double型からfloat型へ：キャストが必要
		fdata = (float)ddata;
		System.out.println("fdata = " + fdata);
	}

}
