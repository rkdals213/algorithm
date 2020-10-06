package algorithm_study;

import java.util.Arrays;

public class Pro_LV3_가장긴팰린드롬 {
    public static void main(String[] args) {
        System.out.println(solution("abcdcba"));
        System.out.println(solution("abacde"));
        System.out.println(solution(""));
        System.out.println(solution("aabba"));
        System.out.println(solution("aa"));
        System.out.println(solution("abcdef"));
        System.out.println(solution("aba"));
        System.out.println(solution("abca"));


    }

    static int[][] dp;

    static int solution(String s) {
        int answer = 0;
        dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(dp[i][j] == 0){
                    dp[i][j] = check(i, j, s);
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer;
    }

    static int check(int i, int j, String line) {
        if (i == j) return dp[i][j] = 1;

        if (dp[i][j] != 0) return dp[i][j];

        if (i + 1 == j) {
            if (line.charAt(i) == line.charAt(j)) return dp[i][j] = 2;
            else return dp[i][j] = -1;
        }

        if (line.charAt(i) != line.charAt(j)) return dp[i][j] = -1;
        else{
            int temp = check(i + 1, j - 1, line);
            if(temp < 0) return dp[i][j] = -1;
            else return dp[i][j] = temp + 2;
        }

    }

}
