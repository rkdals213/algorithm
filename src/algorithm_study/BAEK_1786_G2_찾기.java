package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BAEK_1786_G2_찾기 {
    static List<Integer> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        String pattern = br.readLine();
        KMP(origin, pattern);
        System.out.println(count);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pi.length; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            // 맞는 경우
            if (pattern.charAt(i) == pattern.charAt(j)) {
                // i길이 문자열의 공통길이는 j의 위치 + 1
                pi[i] = ++j;
            }
        }
        return pi;
    }


    static void KMP(String origin, String pattern) {
        int[] pi = getPi(pattern);
        int j = 0;
        for (int i = 0; i < origin.length(); i++) {
            while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            // 맞는 경우
            if (origin.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    list.add(i - pattern.length() + 2);
                    count++;
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }
}
