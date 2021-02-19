package com.ssafy.step08.DP;

public class Fibo {
    // dp : memoization을 위한 배열을 만들어야함
    static int[] memo; // memo[n] : n번째 피보나치 수를 저장할 배열

    public static void main(String[] args) {
        init(10);
        System.out.println(fibo(4));
        System.out.println(fiboUp(4));
    }

    static void init(int n) {
        memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1; // 점화식으로는 구하지 못하는 기저조건
    }

    // 어떤 함수의 호출 결과가 전달된 파라미터에 의해서만 결정되는 상태에서 함수의 호출이 여러번 중복된다면 - 메모이제이션
    // 이런 함수를 referential transparency 참조적 투명성
    // 이런식으로 큰것 --> 작은것 가는 DP를 하향식 DP(재귀 호출 형태로 구성)

    static int fibo(int n) {
        if (n < 2) {
            return memo[n]; // 기저조건
        } else {
            if (memo[n] > 0) { // 이미 값을 구해놓은 경우
                return memo[n];
            } else {
                return memo[n] = fibo(n - 1) + fibo(n - 2);
            }
        }
    }

    static int fiboUp(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }
}
