package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2005_D2_파스칼의삼각형 {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			sb.append("#").append(i+1).append("\n");
			N = Integer.parseInt(br.readLine());
			int [][] triangle = new int [N][N];
			triangle[0][0] = 1;
			sb.append(triangle[0][0]).append("\n");
			for (int j = 1; j < triangle.length; j++) {
				triangle[j][0] = 1;
				sb.append(triangle[j][0]).append(" ");
				for (int j2 = 1; j2 < triangle.length; j2++) {
					triangle[j][j2] = triangle[j-1][j2-1] + triangle[j-1][j2];
					if(triangle[j][j2] != 0) {
						sb.append(triangle[j][j2]).append(" ");
					}
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		
		
		
	}

}
