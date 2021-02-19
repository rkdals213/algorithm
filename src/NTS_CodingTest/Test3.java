package NTS_CodingTest;

public class Test3 {
    public static void main(String[] args) {
        int[] a = {2, 2, 2, 3};
        int[] b = {6, 5, 7, 3, 4, 2};

        solution(a);
        solution(b);

    }

    static int solution(int[] histogram) {
        int answer = 0;

        for (int i = 0; i < histogram.length - 2; i++) {
            for (int j = i + 2; j < histogram.length; j++) {
                int t = (histogram[j] - histogram[i] + 1) * Math.min(histogram[i], histogram[j]);
                answer = Integer.max(answer, t);
            }
        }

        System.out.println(answer);

        return answer;
    }
}
