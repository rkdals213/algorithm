package algo_ad.day01;

public class ChangeNotation {

	public static void main(String[] args) {
		int num = 149;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toOctalString(num));
		System.out.println(Integer.toHexString(num));
		
		int num2 = 0x95; // 16진수
		System.out.println(num2);
	}

}
