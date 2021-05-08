package algorithm_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Pro_LV3_섬연결하기 {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(solution(n, costs));
    }

    static int[] root;

    static int solution(int n, int[][] costs) {
        int answer = 0;
        root = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = -1;
        }

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer a = o1[2];
                Integer b = o2[2];
                return a.compareTo(b);
            }
        });
                for (int i = 0; i < costs.length; i++) {
            if(union(costs[i][0], costs[i][1])){
                answer += costs[i][2];
            }
        }


        return answer;
    }

    static int find(int x) {
        if(root[x] == -1) return x;
        else return root[x] = find(root[x]);
    }

    static boolean union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);

        if(rootx != rooty) {
            root[rootx] = rooty;
            return true;
        }
        return false;
    }
}
