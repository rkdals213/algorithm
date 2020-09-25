package NTS_CodingTest;

import java.util.ArrayList;
import java.util.List;

public class Test4 {

    public static void main(String[] args) {
        int[][] a = {{2, 5}, {3, 7}, {10, 11}};
        int[][] b = {{3, 4}, {4, 5}, {6, 7}, {8, 10}};
        solution(a);
        solution(b);
    }

    static int solution(int[][] flowers) {
        int answer = 0;

        int [] map = new int [365];
        for (int i = 0; i < flowers.length; i++) {
            for (int j = flowers[i][0]; j < flowers[i][1]; j++) {
                if(map[j] > 0) continue;
                else map[j]++;

                answer++;
            }
        }

        return answer;
    }

    static class flower {
        int start, end;

        public flower(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
