package Channel_CodingTest;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(12));
        System.out.println(solution(5));
        System.out.println(solution(500000));
    }

    static public int solution(int b) {
        for (int i = 2; i < b; i++) {
            long c = (long) i * i + (long) b * b;
            if (Math.sqrt(c) == (int) Math.sqrt(c)) {
                return (int) Math.sqrt(c);
            }
        }
        return -1;
    }
}
