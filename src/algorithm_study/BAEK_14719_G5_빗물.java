package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_14719_G5_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(temp.nextToken());
        int W = Integer.parseInt(temp.nextToken());

        int[] map = new int[W];

        temp = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(temp.nextToken());
        }

        int i = 0;
        int j = 1;

        int result = 0;

        while (j < W) {
            int t = j;
            if (map[i] <= map[j]) {
                if (i + 1 == j) {
                    i++;
                    j++;

                } else {
                    for (int k = i + 1; k < j; k++) {
                        result += map[i] - map[k];
                        map[k] = map[i];
                    }
                    i = j;
                    j++;
                }
            } else {
                for (int k = j; k < W; k++) {
                    if (map[t] < map[k]) {
                        t = k;
                    }
                    if (map[t] >= map[i]) break;
                }
                j = t;
                for (int k = i + 1; k < j; k++) {
                    int min = Math.min(map[i], map[j]);
                    result += min - map[k];
                    map[k] = min;
                }
                i = j;
                j++;
            }
        }

        System.out.println(result);
    }
}
