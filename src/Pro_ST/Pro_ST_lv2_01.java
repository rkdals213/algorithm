package Pro_ST;

import java.util.ArrayList;
import java.util.List;

public class Pro_ST_lv2_01 {
    public static void main(String[] args) {
        String[] a = {"119", "97674223", "1195524421"};
        String[] b = {"123","456","789"};
        String[] c = {"12","123","1235","567","88"};
        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));
    }

    static boolean solution(String[] phone_book) {
        boolean answer = true;

        for (int i = 0; i < phone_book.length; i++) {
            String a = phone_book[i];
            for (int j = 0; j < phone_book.length; j++) {
                String b = phone_book[j];
                if(a.length() > b.length() || i == j) continue;
                if(a.equals(b.substring(0, a.length()))) return false;
            }
        }

        return answer;
    }
}
