package algorithm_study;

public class Pro_LV1_124나라의숫자 {
    public static void main(String[] args) {
        for (int i = 10; i < 11; i++) {
            System.out.println(i + " : " + solution(i));
        }
    }

    static String[] map = {"4", "1", "2"};

    static public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            answer.insert(0, map[n % 3]);
            n = (n - 1) / 3;
        }

        return answer.toString();
    }
}
