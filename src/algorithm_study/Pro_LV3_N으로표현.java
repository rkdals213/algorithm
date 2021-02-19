package algorithm_study;

// 아직 덜품
public class Pro_LV3_N으로표현 {
    public static void main(String[] args) {
        System.out.println(solution(5, 24));
//        System.out.println(solution(2, 11));
    }

    static int answer = -1;

    static int solution(int N, int number) {
        go(0, 0, N, number);
        return answer;
    }

    static void go(int cur, int count, int N, int number) {
        if (count > 8) {
            return;
        }

        if (cur < 0) return;

        if (cur == number) {
            if (answer == -1 || count < answer) {
                answer = count;
            }
        }
        int temp = N;
        for (int i = 0; i < 8 - count; i++) {
            go(cur + temp, count + 1 + i, N, number);
            go(cur - temp, count + 1 + i, N, number);
            go(cur * temp, count + 1 + i, N, number);
            go(cur / temp, count + 1 + i, N, number);

            temp = mulTen(temp, N);
        }
    }

    static int mulTen(int temp, int N) {
        return temp * 10 + N;
    }

}
