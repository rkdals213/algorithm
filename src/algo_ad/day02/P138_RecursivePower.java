package algo_ad.day02;

public class P138_RecursivePower {

	public static void main(String[] args) {
		// 2의 50승을 구해보자
		int x = 2;
		int n = 50;
		long start = System.nanoTime();
		double byApi = Math.pow(x, n);
		long mid = System.nanoTime();
		double byDnc = byDnc(x, n);
		long end = System.nanoTime();
		System.out.printf("by api : %f, %d%n", byApi, mid-start);
		System.out.printf("by api : %f, %d%n", byDnc, end-mid);
	}
	public static double byDnc(int x, int n) {
		if(n==1) {
			return x;
		}
		if(n%2==0) {
			double d1 = byDnc(x, n/2);
			return d1 * d1;
		}else {
			double d1 = byDnc(x, n/2);
			return d1 * d1 * x;
		}
	}
}
