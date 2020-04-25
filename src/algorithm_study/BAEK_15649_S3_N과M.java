package algorithm_study;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_15649_S3_N과M {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input_a = scanner.nextInt();
		int input_b = scanner.nextInt();
		int [] result;
		int [] flag;
		int count = 0;
		result = new int [input_a];
		flag = new int [input_a];
		
		perm(result,flag,count,input_a,input_b);		
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
        for(int i=0; i<r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
