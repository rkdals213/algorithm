package algo_ad.day01;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "이름:홍길동,수학:100,영어:80,국어:100";
		// 학생의 이름과 총점은?
		StringTokenizer tokens = new StringTokenizer(src, ":,"); // 이 문장을 구성하고 있는 character를 가지고 토크나이징
		System.out.println(tokens.countTokens());
		// 이름은 불필요
		tokens.nextToken();
		String name = tokens.nextToken();
		System.out.println(name + " : " + tokens.countTokens());
		int sum = 0;
		while(tokens.hasMoreTokens()) {
			tokens.nextToken();
			sum += Integer.parseInt(tokens.nextToken());
		}
		System.out.println("총점 : " + sum);
	}

}
