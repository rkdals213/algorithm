package algo_basic.day03;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strs = "abcdefgfedcba";
		System.out.println(Palin(strs, 0, strs.length()-1));
	}
	public static boolean Palin(String str, int from, int to) {
		//base case		
		if(from == to) {			// 홀수개의 문자열인 경우
			return true;
		}else if(from+1==to) {		// 짝수개의 문자열인 경우
			return str.charAt(from)==str.charAt(to);
		}else {
			return str.charAt(from)==str.charAt(to) && Palin(str, from+1, to-1);
		}
	}

}
