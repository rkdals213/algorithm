//package algorithm_study;
//
//import java.util.*;
//
//public class Pro_LV3_여행경로 {
//    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        System.out.println(solution(tickets));
//    }
//
//    static public List<String> solution(String[][] tickets) {
//        String[] answer = {};
//        Arrays.sort(tickets, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                String[] s1 = (String[]) o1;
//                String[] s2 = (String[]) o2;
//                if (s1[0].equals(s2[0])) return s1[1].compareTo(s2[1]);
//                else return s1[0].compareTo(s2[0]);
//            }
//        });
//
//        visited = new boolean[tickets.length];
//
//        return DFS(new ArrayList<>(), tickets, "");
//    }
//
//    static boolean[] visited;
//
//    static List<String> DFS(List<String> result, String[][] tickets, String next) {
//        for (int i = 0; i < tickets.length; i++) {
//            if (visited[i] || !tickets[i][0].equals(next)) continue;
//            visited[i] = true;
//            result.add(tickets[i][0]);
//            DFS(result, tickets, tickets[i][1]);
//            visited[i] = false;
//        }
//    }
//}
