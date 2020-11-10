package algorithm_study;

import algo_basic.day08.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_2042_G1_구간합구하기 {
    static int[] input;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(temp.nextToken());
        int M = Integer.parseInt(temp.nextToken());
        int K = Integer.parseInt(temp.nextToken());

        input = new int[N + 1];
        int h = (int) (Math.log(N) / Math.log(2));
        tree = new long[1 << (h + 1) + 1];

        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        init(1, N, 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M + K; i++) {
            temp = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(temp.nextToken());
            int b = Integer.parseInt(temp.nextToken());
            int c = Integer.parseInt(temp.nextToken());

            if (a == 1) { // 업데이트
                int diff = c - input[b];
                input[b] = c;
                update(1, N, 1, b, diff);
            } else { // 구간합
                sb.append(sum(1, N, 1, b, c)).append("\n");
            }

            System.out.println(Arrays.toString(tree));
        }

        System.out.println(sb);
    }

    static long init(int start, int end, int node) {
        if (start == end)
            return tree[node] = input[start];

        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static void update(int start, int end, int node, int b, int diff) {
        if (b < start || b > end) return;
        tree[node] = tree[node] + diff;

        if (start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2, b, diff);
        update(mid + 1, end, node * 2 + 1, b, diff);
    }

    static long sum(int start, int end, int node, int left, int right) {
        if (left <= start && end <= right) {
            return tree[node];
        }
        if(left > end || start > right)
            return 0;

        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

}
