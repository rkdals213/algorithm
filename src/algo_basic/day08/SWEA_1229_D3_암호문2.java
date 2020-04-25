package algo_basic.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1229_D3_암호문2 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int i = 0; i < 10; i++) {
			List<String> list = new ArrayList<>();
			sb.append("#").append(i+1).append(" ");
			int length = Integer.parseInt(br.readLine());
			StringTokenizer temp = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < length; j++) {
				list.add(temp.nextToken());
			}
			int TC = Integer.parseInt(br.readLine());
			temp = new StringTokenizer(br.readLine());			
			for (int j = 0; j < TC; j++) {
				String type = temp.nextToken();
				if(type.equals("I")) {
					int idx = Integer.parseInt(temp.nextToken());
					int t = Integer.parseInt(temp.nextToken());
					for (int k = 0; k < t; k++) {
						String tempforinsert = temp.nextToken();
						list.add(idx, tempforinsert);
						idx+=1;
					}
				}else if(type.equals("D")) {
					int idx = Integer.parseInt(temp.nextToken());
					int t = Integer.parseInt(temp.nextToken());
					for (int k = 0; k < t; k++) {
						list.remove(idx);
					}
				}
			}	
			for (int j = 0; j < 10; j++) {
				sb.append(list.get(j)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
