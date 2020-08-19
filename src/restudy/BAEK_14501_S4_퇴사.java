package restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_14501_S4_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] input = new int [N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer t = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(t.nextToken());
            input[i][1] = Integer.parseInt(t.nextToken());
        }

        int [] DP = new int [N+1];
        for (int i = N-1; i >= 0; i--) {
            for (int j = i; j >= 0 ; j--) {
                if(j + input[i][0] > N) break;
                if(j < i) DP[j] = DP[j+1];
                else DP[j] = Math.max(DP[j], input[i][1] + DP[j+input[i][0]]);
            }
        }
        System.out.println(DP[0]);
    }
}
