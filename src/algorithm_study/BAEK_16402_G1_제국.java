package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEK_16402_G1_제국 {
    static int N;
    static int M;
    static int[] root;
    static String[] country;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());

        root = new int[N];
        country = new String[N];

        for (int i = 0; i < N; i++) {
            temp = new StringTokenizer(br.readLine());
            temp.nextToken();
            temp.nextToken();
            country[i] = temp.nextToken();
            root[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            temp = new StringTokenizer(br.readLine(), " ,");
            temp.nextToken();
            temp.nextToken();
            String a = temp.nextToken();
            temp.nextToken();
            temp.nextToken();
            String b = temp.nextToken();
            int c = Integer.parseInt(temp.nextToken());

            int a1 = -1;
            int b1 = -1;
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (country[j].equals(a)) {
                    a1 = j;
                    count++;
                }
                if (country[j].equals(b)) {
                    b1 = j;
                    count++;
                }
                if (count == 2) {
                    break;
                }
            }
            union(a1, b1, c);
        }
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < root.length; i++) {
            if (root[i] == -1) {
                pq.add(country[i]);
            }
        }
        ;
        int size = pq.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println("Kingdom of " + pq.poll());
        }

    }

    static int find(int k) {
        if (root[k] == -1) {
            return k;
        }
        while (true) {
            int t = root[k];
            if (root[t] == -1) {
                return t;
            }
            root[k] = root[t];
        }
    }

    static boolean union(int a, int b, int c) {
        if (c == 1) {
            int roota = find(a);
            int rootb = find(b);

            if (roota != rootb) {
                root[rootb] = roota;
                return true;
            } else {
                root[a] = -1;
                root[b] = a;
                return true;
            }
        } else {
            int roota = find(a);
            int rootb = find(b);

            if (roota != rootb) {
                root[roota] = rootb;

                return true;
            } else {
                root[b] = -1;
                root[a] = b;
                return true;
            }
        }
    }
}