package zenki;

public class ContinueBreakExample {

	public static void main(String[] args) {
		for(int i = 1;i <= 5;i++){
			if(i == 3){
				System.out.println(i + "番目でcontinue");
				continue;
			}
			System.out.println(i + "番目の処理");
		}
		System.out.println();

		for(int i = 1;i <= 5;i++){
			if(i == 3){
				System.out.println(i + "番目でcontinue");
			}else{
				System.out.println(i + "番目の処理");
			}
		}
		System.out.println();

		for(int i = 1;i <= 5;i++){
			if(i == 3){
				System.out.println(i + "番目でbreak");
				break;
			}
			System.out.println(i + "番目の処理");
		}
		System.out.println();

	}
}
