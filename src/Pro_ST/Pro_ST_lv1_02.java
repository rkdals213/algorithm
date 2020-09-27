package Pro_ST;

import java.util.*;

public class Pro_ST_lv1_02 {
    public static void main(String[] args) {
        int[] a = {2,1,3,4,1};
        int[] b = {5,0,2,7};
        System.out.println(Arrays.toString(solution(a)));
        System.out.println(Arrays.toString(solution(b)));
    }

    static int[] solution(int[] numbers) {
        int[] answer = {};

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        answer = new int [set.size()];
        Object[] list = new Object[set.size()];
        list = set.toArray();

        for (int i = 0; i < list.length; i++) {
            answer[i] = (int) list[i];
        }

        Arrays.sort(answer);

        return answer;
    }
}
