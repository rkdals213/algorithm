package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4530_D4_극한의청소작업 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(temp.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TC; i++) {
            sb.append("#").append(i + 1).append(" ");
            temp = new StringTokenizer(br.readLine());
            Long start = Long.parseLong(temp.nextToken());
            Long end = Long.parseLong(temp.nextToken());
        }


    }

}
