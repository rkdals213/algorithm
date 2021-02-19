package Pro_ST;

import java.util.ArrayList;
import java.util.List;

public class Pro_ST_lv1_01 {
    public static void main(String[] args) {
        int[] a = {5, 9, 7, 10};
        int[] b = {2, 36, 1, 3};
        int[] c = {3, 2, 6};
        System.out.println(solution(a, 5));
        System.out.println(solution(b, 1));
        System.out.println(solution(c, 10));
    }

    static int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) list.add(arr[i]);
        }

        if (list.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[list.size()];
            list.sort(null);
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }


        return answer;
    }
}
