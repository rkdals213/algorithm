package SixShop_CodingTest;

import java.util.ArrayList;
import java.util.List;

public class test1 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        System.out.println(solution(s1, s2));
    }

    static public String solution(String s1, String s2) {
        List<Point> list = new ArrayList<>();
        String[] split1 = s1.split("");
        String[] split2 = s2.split("");

        for (int i = 0; i < s1.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < s1.length() - i; j++) {
                if (!split1[j + i].equals(split2[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(new Point(s1.concat(s2.substring(s1.length() - i, s2.length()))));
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < s2.length() - i; j++) {
                if (!split2[j + i].equals(split1[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(new Point(s2.concat(s1.substring(s2.length() - i, s1.length()))));
            }
        }

        if (list.isEmpty()) {
            list.add(new Point(s1.concat(s2)));
            list.add(new Point(s2.concat(s1)));
        }

        list.sort(null);
        return list.get(0).text;
    }

    static class Point implements Comparable<Point> {
        int length;
        String text;

        public Point(String text) {
            this.text = text;
            this.length = text.length();
        }

        @Override
        public int compareTo(Point o) {
            if (this.length == o.length) return this.text.compareTo(o.text);
            return Integer.compare(this.length, o.length);
        }
    }

}
