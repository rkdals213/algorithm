package algorithm_study;

import java.util.Arrays;

public class Pro_LV4_도둑질 {
    public static void main(String[] args) {
//        int[] money = {91, 90, 5, 7, 5, 7};
        int[] money = {1, 1, 4, 1, 4};
        System.out.println(solution(money));
    }

    static int[] dp1;
    static int[] dp2;
    static int size;

    public static int solution(int[] money) {
        size = money.length;

        dp1 = new int[money.length];
        dp2 = new int[money.length];

        dp1[0] = money[0];
        dp1[1] = 0;
        dp1[2] = dp1[0] + money[2];
        dp2[1] = money[1];
        dp2[2] = money[2];

        if(size == 3) return Arrays.stream(money).max().getAsInt();

        for (int i = 3; i < money.length; i++) {
            dp1[i] = money[i] + Integer.max(dp1[i-2], dp1[i-3]);
            dp2[i] = money[i] + Integer.max(dp2[i-2], dp2[i-3]);
        }

        int dp1Max = Integer.max(dp1[size-2], dp1[size-3]);
        int dp2Max = Integer.max(dp2[size-2], dp2[size-1]);

        return Integer.max(dp1Max, dp2Max);
    }
}
