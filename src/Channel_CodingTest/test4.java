package Channel_CodingTest;

public class test4 {
    public static void main(String[] args) {
        System.out.println(solution(6,3,"RBGRGB"));
//        System.out.println(solution(3,2,"BGG"));
//        System.out.println(solution(4,2,"GBBG"));
    }
    static int length;
    static int K;

    static public int solution(int n, int k, String bulbs) {
        int answer = -2;
        length = n;
        K = k;
        System.out.println(change(bulbs, 1));
        return answer;
    }

    static String change(String bulbs, int i) {
        StringBuilder next = new StringBuilder(bulbs.substring(0, i));
        for (int j = i; j < i + K; j++) {
            if (bulbs.charAt(j) == 'R') next.append("G");
            else if(bulbs.charAt(j) == 'G') next.append("B");
            else if(bulbs.charAt(j) == 'B') next.append("R");
        }

        next.append(bulbs.substring(i+K));

        return next.toString();
    }

    static class Point {
        String bulb;
        int count;

        public Point(String bulb, int count) {
            this.bulb = bulb;
            this.count = count;
        }
    }
}
