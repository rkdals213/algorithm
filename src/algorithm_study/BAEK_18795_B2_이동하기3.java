package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_18795_B2_이동하기3 {
    static int N;
    static int M;
    static long[] A;
    static long[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        A = new long[N];
        B = new long[M];


        temp = new StringTokenizer(br.readLine());
        long t = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(temp.nextToken());
            t += A[i];
        }
        temp = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(temp.nextToken());
            t += B[i];
        }
        System.out.println(t);
    }
}
