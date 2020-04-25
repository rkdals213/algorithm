package algo_ad.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1240_D3_단순2진암호코드 {
	static String [] code = {"0001101","0011001","0010011","0111101",
			"0100011","0110001","0101111","0111011","0110111","0001011"};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < TC; i++) {
			sb.append("#").append(i+1).append(" ");
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(temp.nextToken());
			int M = Integer.parseInt(temp.nextToken());
			String [] map = new String[N];
			for (int j = 0; j < N; j++) {
				map[j] = br.readLine();				
			}		
			int startingx = 0;
			int startingy = 0;
			for (int j= 0; j < map.length; j++) {
		outer : for (int j2 = map[0].length()-1; j2 >=0 ; j2--) {
					if(map[j].charAt(j2) == '1') {
						startingx = j;
						startingy = j2-55;
						break outer;
					}
				}				
			}
			int count = 0;
			int [] result = new int [8];
			int sum = 0;
			while(true) {
				if(count >= 8)break;				
				String t = map[startingx].substring(startingy, startingy+7);
				for (int j = 0; j < code.length; j++) {
					if(t.contains(code[j])) {
						result[count] = j;
						sum += j;
					}
				}
				startingy += 7;
				count++;
			}
			//System.out.println(Arrays.toString(result));
			int check1 = 0;
			int check2 = 0;
			for (int j = 0; j < result.length; j+=2) {
				check1 += result[j];
			}
			for (int j = 1; j < result.length; j+=2) {
				check2 += result[j];
			}
			if(((check1 * 3) + check2) % 10 == 0) {
				sb.append(sum).append("\n");
			}else {
				//System.out.println((check1 * 3) + check2);
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);

	}

}
