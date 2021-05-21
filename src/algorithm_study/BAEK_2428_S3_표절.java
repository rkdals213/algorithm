package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BAEK_2428_S3_표절 {
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer temp = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(temp.nextToken()));
        }
        list.sort(Integer::compareTo);

        Queue<Integer> q = new LinkedList<>();
        for (int t : list) {
            if (!q.isEmpty()) {
                if (q.peek() >= t * 0.9) {
                    result += q.size();
                } else {
                    while (!q.isEmpty() && q.peek() < t * 0.9) {
                        q.poll();
                    }
                    if (!q.isEmpty()) {
                        result += q.size();
                    }
                }
            }
            q.add(t);
        }
        System.out.println(result);
    }
}
