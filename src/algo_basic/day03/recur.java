package algo_basic.day03;

public class recur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(StringLength("abcdefg"));
		printString("abcdefg");
		System.out.println();
		reverseString("abcdefg");
		System.out.println();
		getDigit(10);
		System.out.println();
		int [] arr = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(getSum(arr, 0));
		int [] arr2 = {1,2,3,4,5,6,7,8,9,10,3};
		System.out.println(getMax(arr2, 0, 0));
		
	}
	public static int StringLength(String a) {
		if(a.equals("")) {
			return 0;
		}
		else {
			return 1+StringLength(a.substring(1));
		}
	}
	public static void printString(String a) {
		if(a.equals("")) {
			return;
		}
		else {
			System.out.print(a.charAt(0));
			printString(a.substring(1));
		}
	}
	public static void reverseString(String b) {
		if(b.equals("")) {
			return;
		}
		else {
			reverseString(b.substring(1));
			System.out.print(b.charAt(0));			
		}
	}
	public static void getDigit(int k) {
		if(k <= 0) {
			return;
		}else {
			getDigit(k/2);
			System.out.print(k%2);			
		}		
	}	
	public static int getSum(int [] arr, int i) {
		if(i >= arr.length-1) {
			return arr[i];
		}else {
			return arr[i] + getSum(arr, i+1);
		}
	}
	public static int getMax(int [] arr, int i, int max) {
		if(i >= arr.length-1) {
			return max;
		}else {
			if(arr[i] > max) {
				max = arr[i];
			}
			return getMax(arr, i+1, max);
		}
	}		
}
