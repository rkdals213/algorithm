package NTS_CodingTest;

public class Test2 {
    public static void main(String[] args) {
        solution(1);
        solution(2);
        solution(3);
    }

    static int [] dp = new int [46];

    static int solution(int N) {
        int answer = 0;

        answer = fibo(N);
        System.out.println(answer);
        return answer;
    }

    static int fibo(int N){
        if(N <= 1){
            return dp[N] = 1;
        }else{
            if(dp[N] != 0) return dp[N];
            else return dp[N] = fibo(N-1) + fibo(N-2);
        }
    }
}
