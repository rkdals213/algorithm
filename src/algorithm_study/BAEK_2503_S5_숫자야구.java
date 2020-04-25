package algorithm_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BAEK_2503_S5_숫자야구 {
	static ArrayList<String> list = new ArrayList<>();
	
	private static int [] src = {1,2,3,4,5,6,7,8,9};
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		int [] flag = new int [9];		
		perm(src, flag, 0, 9, 3);
		int TC = s.nextInt();
		int [][] inputArray = new int [TC][3];
		String [] input2 = new String [TC];
		int [] strike = new int [TC];
		int [] ball = new int [TC]; 
		for (int i = 0; i < TC; i++) {	
			String input = s.next();
			input2[i] = input;
			strike[i] = s.nextInt();
			ball[i] = s.nextInt();		
			
			for (int j = 0; j < 3; j++) {
				inputArray[i][j] = input.charAt(j)-'0';
			}					
		}
		
		System.out.println(baseball(strike, ball, input2));
		
	}
	public static int baseball(int [] strike, int [] ball, String [] input) {

		String temp;
		int count;
		int result = 0;
		for (int i = 0; i < list.size(); i++) {	
			count = 0;
			
			temp = list.get(i);			
			for (int j = 0; j < strike.length; j++) {	
				int s = 0;
				int b = 0;
				
				for (int j2 = 0; j2 < temp.length(); j2++) {
					for (int k = 0; k < input[j].length(); k++) {
						if(temp.charAt(j2) == input[j].charAt(k)) {
							if(j2 == k) {
								s++;
							}else {
								b++;
							}
						}
					}					
				}	
				
				if(strike[j] == s && ball[j] == b) {
					count++;
				}else{	
					break;
				}
			}			
			if(count == ball.length) result++; 
		}
		return result;
	}	
	
	public static int perm(int [] result, int [] flag, int count, int a, int b) {
		if(count == b) {
			print(result, b);
			return 0;
		}
		else {
			for(int i=0; i<a; i++) {
				if(flag[i]==0) {
					flag[i] = 1;
					result[count] = i+1;
					perm(result,flag,count+1,a,b);
					flag[i] = 0;
				}
			}
			return 0;
		}
	}
	
	static void print(int[] arr, int r) {
		String temp = "";
        for(int i=0; i<r; i++) {
            temp += arr[i];
        }        
        list.add(temp);
    }
}
