package algo_ad.day01;

import java.math.BigDecimal;

public class FloatTest {

	public static void main(String[] args) {	
		double a = 1.1;
		double b = 2;
		System.out.println(b-a);

		BigDecimal bd1 = new BigDecimal(a+"");
		BigDecimal bd2 = new BigDecimal(b+"");
		
		System.out.println(bd2.subtract(bd1));
		// 실수는 연산 안하는게 가장 좋다
	}
}
