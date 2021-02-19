package algo_basic.day03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RecurTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        recur2(3);

    }

    public static void recur2(int k) {
        // 두가지 케이스를 반드시 고려한다
        // 1. 종료조건 - base case
        if (k == 0) {
            System.out.println("재귀종료");
            return;
        }
        // 2. 그렇지 않으면 재귀 호출
        System.out.println("before : " + k);
        recur2(k - 1); // 다시 자기자신을 부를 때는 종료조건으로 수렴할 것
        System.out.println("after : " + k);
    }

    public static void recur3(int k, int n, int[] arr) {
        if (k == n) {
            return;
        }
        arr[0] = k;
        System.out.println(k + " : " + arr[0]);
        recur3(k + 1, n, arr);
        arr[0] = k;
        System.out.println(k + " : " + arr[0]);
    }

    public static int recur4(int k) {
        if (k <= 0) {
            return 0;
        } else {
            return k + recur4(k - 1);
        }
    }

    public static int getMulti(int n, int m) {
        if (n >= m) {
            return n;
        } else {
            return n * getMulti(n + 1, m);
        }
    }

    public static int getPower(int n, int m) {
        if (m <= 1) {
            return n;
        } else {
            return n * getPower(n, m - 1);
        }
    }

    public static void getDigitSum(int num, int sum) {
        if (num >= 0 && num < 10) {
            System.out.println(num + sum);
            return;
        } else {
            getDigitSum(num / 10, sum + (num % 10));
        }
    }

    @Test
    public void recur3Test() {
        int[] arr = new int[1];
        recur3(0, 3, arr);
        System.out.println(recur4(3));
        System.out.println(getMulti(1, 5));
        assertEquals(getMulti(1, 5), 120);
        System.out.println(getPower(2, 4));
        getDigitSum(12321, 0);
    }
}
