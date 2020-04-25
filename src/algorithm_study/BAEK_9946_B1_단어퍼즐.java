package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BAEK_9946_B1_단어퍼즐 {
	private static ArrayList<String> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String temp1 = br.readLine();
			String temp2 = br.readLine();
			if(temp1.equals("END")) {
				break;
			}
			list.add(temp1);
			list.add(temp2);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i+=2) {
			sb.append("Case ").append(((i+1)/2)+1).append(": ");
			if(list.get(i).length() == list.get(i+1).length()) {
				char [] tempa = new char[list.get(i).length()];
				char [] tempb = new char[list.get(i+1).length()];
				
				tempa = list.get(i).toCharArray();
				tempb = list.get(i+1).toCharArray();
				
				Arrays.sort(tempa);
				Arrays.sort(tempb);
				
				String a = "";
				String b = "";
				for (int j = 0; j < tempb.length; j++) {
					a+= tempa[j];
					b+= tempb[j];
				}
				
				if(a.equals(b)) {
					sb.append("same").append("\n");
				}else {
					sb.append("different").append("\n");
				}			
				
			}else {
				sb.append("different").append("\n");
			}
		}
		System.out.println(sb);		
	}

}
