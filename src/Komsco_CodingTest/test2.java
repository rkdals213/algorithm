package Komsco_CodingTest;

import java.util.*;

public class test2 {
    public static void main(String[] args) {
        String[] purchase = {"2019/01/01 5000", "2019/01/20 15000", "2019/02/22 30000"};
        System.out.println(Arrays.toString(solution(purchase)));
    }

    static int[] solution(String[] purchase) {
        int[] answer = {};

        answer = new int[5];

        int[] days = new int[366];

        for (int i = 0; i < purchase.length; i++) {
            StringTokenizer temp = new StringTokenizer(purchase[i], "/ ");
            temp.nextToken();
            int mon = Integer.parseInt(temp.nextToken());
            int day = Integer.parseInt(temp.nextToken());

            int t = 0;

            for (int j = 0; j < mon; j++) {
                t += month[j];
            }

            t += day;
            days[t] = Integer.parseInt(temp.nextToken());
        }

        int check = 0;

        for (int i = 1; i < 31; i++) {
            check += days[i];
            if (check < 10000) answer[0]++;
            else if (check < 20000) answer[1]++;
            else if (check < 50000) answer[2]++;
            else if (check < 100000) answer[3]++;
            else if (check >= 100000) answer[4]++;
        }
        // System.out.println(check);
        for (int i = 1; i < 336; i++) {
            check -= days[i];
            check += days[i + 30];
            if (check < 10000) answer[0]++;
            else if (check < 20000) answer[1]++;
            else if (check < 50000) answer[2]++;
            else if (check < 100000) answer[3]++;
            else if (check >= 100000) answer[4]++;
        }


        return answer;
    }

    static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

}
