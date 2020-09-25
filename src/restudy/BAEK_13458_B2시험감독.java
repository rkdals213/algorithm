package restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_13458_B2시험감독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, B, C;
        N = Integer.parseInt(br.readLine());
        int [] A = new int [N];
        long result = 0;

        StringTokenizer temp = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(temp.nextToken());
        }
        temp = new StringTokenizer(br.readLine());
        B = Integer.parseInt(temp.nextToken());
        C = Integer.parseInt(temp.nextToken());

        for (int i = 0; i < N; i++) {
            A[i] -= B;
            result++;
            if(A[i] > 0){
                if(A[i]%C == 0) result += A[i]/C;
                else result += 1 + A[i]/C;
            }
        }

        System.out.println(result);

    }
}
