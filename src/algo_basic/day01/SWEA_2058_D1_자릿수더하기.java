package algo_basic.day01;

import java.util.Scanner;

public class SWEA_2058_D1_자릿수더하기 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //System.out.println(n);        
        int sum = 0;
        while(n>0) {
            sum+=n%10;
            n/=10;
        }
        System.out.println(sum);
    }     
}