package Dev_Matching;

import java.util.StringTokenizer;

public class test2 {
    public static void main(String[] args) {
        System.out.println(solution("PM 01:00:00", 0));
        System.out.println(solution("PM 11:59:59", 36000));
    }

    static String solution(String p, int n) {
        StringTokenizer temp = new StringTokenizer(p, " :");

        String M = temp.nextToken();
        int hour = Integer.parseInt(temp.nextToken());
        int min = Integer.parseInt(temp.nextToken());
        int sec = Integer.parseInt(temp.nextToken());

        sec += n;

        if (sec >= 60) {
            min += sec / 60;
            sec = sec % 60;
        }

        if (min >= 60) {
            hour += min / 60;
            min = min % 60;
        }


        if (hour >= 12) hour = hour % 12;

        if (M.equals("PM")) hour += 12;

        StringBuilder sb = new StringBuilder();

        if (hour < 10) sb.append(0);
        sb.append(hour);
        sb.append(":");
        if (min < 10) sb.append(0);
        sb.append(min);
        sb.append(":");
        if (sec < 10) sb.append(0);
        sb.append(sec);
        return sb.toString();
    }
}
