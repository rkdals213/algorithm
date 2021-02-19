package Komsco_CodingTest;

import java.util.Arrays;

public class test3 {
    public static void main(String[] args) {
        long a = 6;
        long b = 12;
        long c = 1000007;
        System.out.println(Arrays.toString(solution(a)));
        System.out.println(Arrays.toString(solution(b)));
        System.out.println(Arrays.toString(solution(c)));
    }

    static long[] solution(long n) {
        long[] answer = new long[2];

        long div = 2;
        int cnt = 0;

        while (div <= n / 2) {
            if (n % div == 0) {
                cnt++;
                if (cnt > 2) {
                    answer[0] = -1;
                    answer[1] = -1;
                    return answer;
                }
                answer[cnt - 1] = div;

            }
            div++;

        }

        return answer;
    }

}
