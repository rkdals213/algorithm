package ElevenST_CodingTest;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(solution("aabab"));
        System.out.println(solution("dog"));
        System.out.println(solution("aa"));
        System.out.println(solution("baaaa"));
    }

    static int solution(String S) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (i == 0 && S.charAt(i) != 'a') {
                sb.append("aa");
            } else if (i == 0 && S.charAt(i) == 'a') {

            } else if (i != 0) {
                if (S.charAt(i) != 'a') {
                    if (sb.length() > 1) {
                        if (sb.substring(sb.length() - 2, sb.length()).equals("aa")) ;
                        else if (sb.charAt(sb.length() - 1) == 'a') sb.append("a");
                        else if (sb.charAt(sb.length() - 1) != 'a') sb.append("aa");
                    } else if (sb.length() > 0) {
                        if (sb.charAt(sb.length() - 1) == 'a') sb.append("a");
                        else if (sb.charAt(sb.length() - 1) != 'a') sb.append("aa");
                    } else {
                        sb.append("aa");
                    }
                }
            }
            sb.append(S.charAt(i));
            if (sb.length() >= 3 && sb.substring(sb.length() - 3, sb.length()).equals("aaa")) return -1;
            if (sb.length() > 100000) {
                sb.delete(0, 10);
                answer += 10;
            }

        }
        System.out.println(sb);
        if (sb.charAt(sb.length() - 1) != 'a') sb.append("aa");
        answer += sb.length() - S.length();
        return answer;
    }
}
