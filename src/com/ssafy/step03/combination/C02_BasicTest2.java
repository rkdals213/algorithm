package com.ssafy.step03.combination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author taehee kim
 */
public class C02_BasicTest2 {

    static int N, R;
    static int[] input, number;
    static int totalCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        input = new int[N];
        number = new int[R];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        combination(N, R);
        System.out.println("총 경우의 수:" + totalCnt);
    }

    // n번째 원소(순서)를 r위치(순서)에 조합해보기
    private static void combination(int n, int r) {
        if (r == 0) {
            ++totalCnt;
            System.out.println(Arrays.toString(number));
            return;
        }
        if (n < r) return;
        // 선택
        number[r - 1] = input[n - 1];
        combination(n - 1, r - 1);
        // 비선택
        combination(n - 1, r);
    }


}







