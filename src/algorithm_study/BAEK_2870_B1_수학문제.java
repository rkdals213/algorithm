package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BAEK_2870_B1_수학문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		ArrayList<String> array = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());	
		char [][] input = new char [N][100];
		String [] temp = new String [N];
		for (int i = 0; i < N; i++) {
			temp[i] = br.readLine();					
		}
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length(); j++) {
				if(temp[i].charAt(j) >= '0' && temp[i].charAt(j) <= '9') {
					input[i][j] = temp[i].charAt(j);
				}
			}	
		}		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				String k = "";
				if(input[i][j] != '\u0000') {
					for (int k2 = j; k2 < input[i].length; k2++) {
						if(input[i][k2] == '\u0000') {							
							break;
						}
						else {
							k += input[i][k2];
							j++;
						}
					}
				}
				if(k != "")	{
					int c = 0;
					int l = k.length()-1;
					while (c < l) {						
						if(k.charAt(c) == '0') {
							k = k.substring(1, k.length());
							l = k.length()-1;
						}else break;
					}
					array.add(k);
				}
			}
		}
		array.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				if(o2.length() > o1.length()) {
					return -1;
				}else if(o2.length() < o1.length()) {
					return 1;
				}else {
					return o1.compareTo(o2);
				}		
			}		
		});
		for (int i = 0; i < array.size(); i++) {
			sb.append(array.get(i)).append("\n");
		}
		System.out.println(sb);
	}	
}
