package restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BAEK_2252_G2_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(temp.nextToken());
        int M = Integer.parseInt(temp.nextToken());
        int[] depth = new int[N];
        List<Integer>[] gr = new List[N];
        for (int i = 0; i < N; i++) {
            gr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            temp = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(temp.nextToken()) - 1;
            int b = Integer.parseInt(temp.nextToken()) - 1;
            gr[a].add(b);
            depth[b]++;
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(gr[i].toString());
//        }


        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (depth[i] == 0) q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int t = q.poll();
            sb.append(t + 1 + " ");
            for (int i = 0; i < gr[t].size(); i++) {
                depth[gr[t].get(i)]--;
                if (depth[gr[t].get(i)] == 0) q.add(gr[t].get(i));
            }
        }
        System.out.println(sb);

    }
}
