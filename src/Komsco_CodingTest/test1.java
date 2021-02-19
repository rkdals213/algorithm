package Komsco_CodingTest;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        int[] people = {3, 3, 3, 2, 1, 3, 5, 6, 7, 1, 2, 2, 3, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(people)));
    }

    static int[] solution(int[] people) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < people.length; i++) {
            int t = people[i];
            if (map.containsKey(t)) {
                if (map.get(t) == 3) {
                    map.replace(t, 0);
                    list.add(t);
                } else {
                    map.replace(t, map.get(t) + 1);
                }
            } else {
                map.put(t, 1);
            }

        }
        if (list.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }
        return answer;
    }

}
