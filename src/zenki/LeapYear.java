package zenki;

//うるう年の計算プログラム
//4で割り切れたら  うるう年
//  ただし、100で割り切れたら  平年
//  ただし、400で割り切れたら  うるう年
import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("西暦を入力して：");
		int year = scan.nextInt();
		scan.close();
		boolean leap = false; //うるう年の時、trueになる

		if(year %  4 == 0){
			if(year % 100 == 0){
				if(year % 400 == 0){
					leap = true;
				}
			}else{
				leap = true;
			}
		}

		if(leap){//if(leap == true)としてもよい
			System.out.println("その年はうるう年です");
		}else{
			System.out.println("その年は平年です");
		}
	}

}
