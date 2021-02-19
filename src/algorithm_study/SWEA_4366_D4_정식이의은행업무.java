package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4366_D4_정식이의은행업무 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            String bInput = br.readLine();
            String tInput = br.readLine();
            char[] B = new char[bInput.length()];
            char[] T = new char[tInput.length()];
            B = bInput.toCharArray();
            T = tInput.toCharArray();

            outer:
            for (int i = 0; i < B.length; i++) {
                char[] nextB = B.clone();
                if (nextB[i] == '0') nextB[i] = '1';
                else nextB[i] = '0';
                for (int j = 0; j < T.length; j++) {
                    char[] nextT = T.clone();
                    for (int k = 1; k < 3; k++) {
                        int t = T[j] - '0';
                        t = (t + k) % 3;
                        nextT[j] = java.lang.Character.forDigit(t, 10);
                        if (toHex(2, nextB) == toHex(3, nextT)) {
                            sb.append(toHex(2, nextB));
                            break outer;
                        }
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int toHex(int a, char[] input) {
        int result = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            result += (input[i] - '0') * Math.pow(a, input.length - i - 1);
        }
        return result;
    }
}
