package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_16637_G4_괄호추가하기 {
	static int N;
	static int max = Integer.MIN_VALUE;
	static char [] input;
	static int [] operrand;
	static char [] operator;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new char[N];
		operrand = new int[(N/2)+1];	// 숫자만 저장하는 배열
		operator = new char[N/2];		// 연산자만 저장하는 배열
		String temp = br.readLine();
		input = temp.toCharArray();
		for (int i = 0; i < input.length; i++) {
			if(i%2 == 0) {
				operrand[i/2] = input[i]-'0';	// 입력의 홀수번은 숫자로 저장
			}else {
				operator[i/2] = input[i];		// 입력의 짝수번은 연산자로 저장
			}
		}
		
		reCur(0, operrand[0]);		// 재귀 시작, 최초의 result값은 숫자배열의 첫번째 값임
		System.out.println(max);
		
	}
	
	static void reCur(int idx, int result) {
		if(idx >= N/2) {	// idx가 연산자의 개수보다 크다면
			max = Math.max(max, result);	// 재귀를 종료하고 최고값을 갱신함
			return;
		}
		
		int cal_result = calculate(result, operrand[idx+1], operator[idx]);	
		// 괄호를 무시하고 계산하는 경우의 수로 현재 연산자를 기준으로 계산하여 다음 연산을 다음 재귀로 넘긴다
		// 초기에는 첫번째 숫자와 idx = 0+1 번째 숫자를 0번째 연산자로 계산한다
		reCur(idx+1, cal_result);
		// idx를 1증가시키고 연산 결과를 재귀로 넣어 다음 연산을 진행한다
		
		if(idx+1 < N/2) { // 만약 idx+1값이 연산자의 수보다 작다면
			int after_result = calculate(operrand[idx+1], operrand[idx+2], operator[idx+1]);
			// 현재 연산자 보다 뒤에있는 연산자를 괄호로 묶는다고 가정하여 뒤에것을 먼저 계산한 뒤
			int cur_result = calculate(result, after_result, operator[idx]);
			// 뒤에 것 계산한 결과를 앞에 것과 계산한다
			reCur(idx+2, cur_result);
			// 그다음 결과값을 재귀에 넣고 연산을 두번 했기 때문에 idx는 2를 증가시킨다
		}
	}
	
	static int calculate(int a, int b, int o) {
		if(o == '+') {
			return a+b;
		}else if(o == '-') {
			return a-b;
		}else if(o == '*') {
			return a*b;
		}
		return 1;
	}
}
