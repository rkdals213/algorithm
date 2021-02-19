package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_17140_G4_이차원배열과연산 {
    static int N;
    static int M;
    static int K;
    static int map[][] = new int[3][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        K = Integer.parseInt(temp.nextToken());

        for (int i = 0; i < 3; i++) {
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(temp.nextToken());
            }
        }


    }

}
