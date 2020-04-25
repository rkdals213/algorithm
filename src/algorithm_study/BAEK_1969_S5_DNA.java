package algorithm_study;

import java.util.Scanner;

public class BAEK_1969_S5_DNA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = "";
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int numresult = 0;
		char [] dna = {'A','C','G','T'};
		String [] input = new String [N];
		for (int i = 0; i < N; i++) {
			input[i] = s.next();
		}
		
		for (int j = 0; j < M; j++) {
			int [] count = new int [4];
			for (int i = 0; i < N; i++) {				
				switch (input[i].charAt(j)) {
				case 'A':
					count[0]++;
					break;
				case 'C':
					count[1]++;
					break;
				case 'G':
					count[2]++;
					break;
				case 'T':
					count[3]++;
					break;
				default:
					break;
				}			
			}
			
			int max = Integer.MIN_VALUE;
			int temp = 0;
			for (int i = 0; i < count.length; i++) {
				if(max < count[i]) {
					max = count[i];
					temp = i;
				}
			}
			result += dna[temp];
			for (int i = 0; i < count.length; i++) {
				if(temp != i) numresult+=count[i];
			}
			
		}				
		System.out.println(result);
		System.out.println(numresult);
	}
}
