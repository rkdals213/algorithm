package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK_1764_S4_듣보잡 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());

        HashMap<String, Integer> list = new HashMap<>();
        List<String> listN = new ArrayList<>();
        for (int i = 0; i < N + M; i++) {
            String t = br.readLine();
            if (list.containsKey(t)) {
                list.replace(t, 1);
            } else {
                list.put(t, 0);
                listN.add(t);
            }
        }
        listN.sort(null);
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listN.size(); i++) {
            if (list.get(listN.get(i)) == 1) {
                sb.append(listN.get(i)).append("\n");
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }

}
