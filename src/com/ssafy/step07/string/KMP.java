package com.ssafy.step07.string;

public class KMP {
    // 모든 경우를 다 비교하지 않아도 부분 문자열을 찾을 수 있는 알고리즘
    // 접두사와 접미사 개념을 활용해서 반복되는 연산을 최대한 줄이도록
    // 지금까지 검사한 문자열의 접두사와 접미사가 일치하는 최대길이만큼 겹침을 이용
    public static void main(String[] args) {
        String origin = "HELLOSSAFY";
        String pattern = "SSAFY";
        KMP(origin, pattern);
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
                    System.out.println("OK" + (i - pattern.length() + 1));
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }
}
