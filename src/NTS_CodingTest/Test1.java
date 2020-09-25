package NTS_CodingTest;

public class Test1 {
    public static void main(String[] args) {
        int[][] a1 = {{1, 2}, {3, 4}, {5, 6}, {-1, 7}, {8, 9}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}};
        int[][] a2 = {{1, 2}, {-1, -1}, {-1, -1}};
        int[][] a3 = {{-1, 1}, {-1, -1}};
//        solution(a1,a2);
        solution(a1,a3);
    }

    static int[][] tt1, tt2;

    static int solution(int[][] t1, int[][] t2) {
        int answer = 0;
        tt1 = new int[t1.length][2];
        tt2 = new int[t1.length][2];
        tt1 = t1.clone();
        tt2 = t2.clone();

        for (int i = 0; i < t1.length; i++) {
            answer += go(i,0);
        }

        System.out.println(answer);

        return answer;
    }

    static int go(int t1now, int t2now) {
        if ((tt1[t1now][0] == -1 && tt1[t1now][1] == -1) && (tt2[t2now][0] == -1 && tt2[t2now][1] == -1)) return 1;
        else if(tt1[t1now][0]*tt2[t2now][0] < 0 || tt1[t1now][1]*tt2[t2now][1] < 0) return 0;
        else {
            int left = 0;
            int right = 0;
            if(tt1[t1now][0] != -1)left = go(tt1[t1now][0], 0);
            if(tt1[t1now][1] != -1)right = go(tt1[t1now][1], 0);
            return left & right;
        }
    }
}
