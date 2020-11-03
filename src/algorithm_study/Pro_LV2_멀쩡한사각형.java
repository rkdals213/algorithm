package algorithm_study;

public class Pro_LV2_멀쩡한사각형 {
    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }

    static long solution(int w, int h) {
        long answer = 0L;

        long gcd = getGcd(w, h);
        answer = (long) w * (long) h - ((long) w + (long) h - gcd);

        return answer;
    }

    static long getGcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
