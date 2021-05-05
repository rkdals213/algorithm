package algorithm_study;

public class Pro_LV2_신규아이디추천 {
    public static void main(String[] args) {
        String new_id1 = "...!@BaT#*..y.abcdefghijklm....";
        String new_id2 = "z-+.^.";
        String new_id3 = "=.=";
        String new_id4 = "123_.def";
        String new_id5 = "abcdefghijklmn.p";
        System.out.println(solution(new_id1));
        System.out.println(solution(new_id2));
        System.out.println(solution(new_id3));
        System.out.println(solution(new_id4));
        System.out.println(solution(new_id5));
    }

    static public String solution(String new_id) {
        new_id = toLowerCase(new_id);
        new_id = removeChar(new_id);
        new_id = collectDot(new_id);
        new_id = trimDot(new_id);
        new_id = isEmpty(new_id);
        new_id = trimLength(new_id);
        new_id = appendLength(new_id);
        return new_id;
    }

    static public String toLowerCase(String new_id) {
        return new_id.toLowerCase();
    }

    static public String removeChar(String new_id) {
        String notAc = "~!@#$%^&*()=+[{]}:?,<>/";
        StringBuilder sb = new StringBuilder(new_id);
        for (int i = 0; i < sb.length(); i++) {
            if (notAc.contains(sb.substring(i, i + 1))) {
                sb.replace(i, i + 1, "");
                i--;
            }
        }

        return sb.toString();
    }

    static public String collectDot(String new_id) {
        StringBuilder sb = new StringBuilder();
        boolean checkPoint = false;
        for (int i = 0; i < new_id.length(); i++) {
            if (new_id.charAt(i) == '.') {
                if (!checkPoint) sb.append(new_id.charAt(i));
                checkPoint = true;
            } else {
                sb.append(new_id.charAt(i));
                checkPoint = false;
            }
        }
        return sb.toString();
    }

    static public String trimDot(String new_id) {
        while (new_id.charAt(0) == '.' || new_id.charAt(new_id.length() - 1) == '.') {
            if (new_id.charAt(0) == '.') new_id = new_id.substring(1);
            else if (new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);
            if (new_id.isEmpty()) return new_id;
        }
        return new_id;
    }

    static public String isEmpty(String new_id) {
        if (new_id.isEmpty()) return "a";
        else return new_id;
    }

    static public String trimLength(String new_id) {
        if (new_id.length() > 15) new_id = new_id.substring(0, 15);
        while (new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);
        return new_id;
    }

    static public String appendLength(String new_id) {
        StringBuilder sb = new StringBuilder(new_id);
        while (sb.length() <= 2) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        return sb.toString();
    }
}
