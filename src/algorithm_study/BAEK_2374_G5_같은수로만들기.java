package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_2374_G5_같은수로만들기 {
    static int[] map;
    static int N;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
            if (map[i] > max) {
                max = map[i];
            }
        }

        go(max, 0, N - 1);
        System.out.println(result);
    }

    static void go(int preMax, int start, int end) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (map[i] > max) {
                max = map[i];
                index = i;
            }
            if (map[i] < min) {
                min = map[i];
            }
        }

        if (start == end) {
            result += preMax - max;
        } else if (index == start) {
            result += preMax - max;
            go(max, start + 1, end);
        } else if (index == end) {
            result += preMax - max;
            go(max, start, end - 1);
        } else {
            result += preMax - max;
            go(max, start, index - 1);
            go(max, index + 1, end);
        }
    }
}
