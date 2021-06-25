package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_2374_G5_같은수로만들기 {
    static int[] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(go(0, N));
    }

    static long go(int start, int end) {
        if (end - start <= 3) {
            int max = findMax(start, end);
            int min = findMin(start, end);
            for (int i = start; i < end; i++) {
                map[i] = max;
            }
            return max - min;
        }

        long result = 0;

//        result += go(0, N / 2);
//        result += go(N / 2, end);

        result += go(0, N / 4);
        result += go(N / 4, 2 * N / 4);
        result += go(2 * N / 4, 3 * N / 4);
        result += go(3 * N / 4, end);

        result += findMax(start, end) - findMin(start, end);
        return result;
    }

    static int findMaxIndex(int start, int end) {
        int max = 0;
        int index = 0;
        for (int i = start; i < end; i++) {
            if (map[i] > max) {
                max = map[i];
                index = i;
            }
        }
        return index;
    }

    static int findMax(int start, int end) {
        int max = 0;
        for (int i = start; i < end; i++) {
            max = Math.max(max, map[i]);
        }
        return max;
    }

    static int findMin(int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            min = Math.min(min, map[i]);
        }
        return min;
    }
}
